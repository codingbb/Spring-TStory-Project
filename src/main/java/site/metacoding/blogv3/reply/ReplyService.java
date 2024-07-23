package site.metacoding.blogv3.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.exception.ApiException404;
import site.metacoding.blogv3._core.exception.Exception403;
import site.metacoding.blogv3._core.exception.Exception404;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.post.PostJPARepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyJPARepository replyRepo;
    private final UserJPARepository userRepo;
    private final PostJPARepository postRepo;

    @Transactional
    public ReplyResponse.SaveDTO replySave(Integer sessionUserId, ReplyRequest.DTO requestDTO) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new Exception404("회원 정보가 존재하지 않습니다."));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new Exception404("게시글이 존재하지 않습니다."));

        Reply reply = replyRepo.save(requestDTO.toEntity(sessionUser, post, requestDTO.getComment()));

        return new ReplyResponse.SaveDTO(sessionUser, reply);
    }


    @Transactional
    public ReplyResponse.UpdateDTO replyUpdate(User user, Integer replyId, ReplyRequest.DTO requestDTO) {
        Reply reply = replyRepo.findById(replyId).orElseThrow(() -> new ApiException404("존재하지 않는 댓글입니다"));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new Exception404("게시글이 존재하지 않습니다."));

        if (user.getId() != requestDTO.getUserId()) {
            throw new Exception403("댓글 수정 권한이 없습니다");
        }

        reply.setComment(requestDTO.getComment());

        return new ReplyResponse.UpdateDTO(reply, user);

    }

    @Transactional
    public void replyDelete(User user, Integer replyId, ReplyRequest.DeleteDTO requestDTO) {
        Reply reply = replyRepo.findById(replyId).orElseThrow(() -> new ApiException404("존재하지 않는 댓글입니다"));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new Exception404("게시글이 존재하지 않습니다."));

        if (user.getId() != requestDTO.getUserId()) {
            throw new Exception403("댓글 삭제 권한이 없습니다");
        }

        replyRepo.deleteById(replyId);

    }

    public Page<ReplyResponse.ListDTO> replyList(User sessionUser, Integer postId, Pageable pageable) {
        Page<ReplyResponse.ListDTO> replies = replyRepo.findAllReply(postId, pageable);

        replies.forEach(reply -> {
            reply.setIsReplyOwner(sessionUser != null && sessionUser.getId() == reply.getUserId());
        });

        return replies;
    }
}
