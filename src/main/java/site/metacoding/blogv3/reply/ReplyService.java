package site.metacoding.blogv3.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.post.PostJPARepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyJPARepository replyRepo;
    private final UserJPARepository userRepo;
    private final PostJPARepository postRepo;

    @Transactional
    public ReplyResponse.SaveDTO replySave(Integer sessionUserId, ReplyRequest.SaveDTO requestDTO) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new RuntimeException("게시글이 존재하지 않습니다."));

        Reply reply = replyRepo.save(requestDTO.toEntity(sessionUser, post, requestDTO.getComment()));

        return new ReplyResponse.SaveDTO(sessionUser, reply);
    }


    @Transactional
    public ReplyResponse.UpdateDTO replyUpdate(User user, Integer replyId, ReplyRequest.UpdateDTO requestDTO) {
        Reply reply = replyRepo.findById(replyId).orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다"));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new RuntimeException("게시글이 존재하지 않습니다."));

        if (user.getId() != requestDTO.getUserId()) {
            throw new RuntimeException("댓글 수정 권한이 없습니다");
        }

        reply.setComment(requestDTO.getComment());

        return new ReplyResponse.UpdateDTO(reply, user);

    }

    @Transactional
    public void replyDelete(User user, Integer replyId, ReplyRequest.DeleteDTO requestDTO) {
        Reply reply = replyRepo.findById(replyId).orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다"));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new RuntimeException("게시글이 존재하지 않습니다."));

        if (user.getId() != requestDTO.getUserId()) {
            throw new RuntimeException("댓글 삭제 권한이 없습니다");
        }

        replyRepo.deleteById(replyId);

    }

    @Transactional(readOnly = true)
    public Page<ReplyResponse.ListDTO> replyList(User user, Integer postId, Pageable pageable) {
        Page<ReplyResponse.ListDTO> replies = replyRepo.findAllReply(postId, pageable);

        replies.forEach(reply -> {
            reply.setIsReplyOwner(user != null && user.getId() == reply.getUserId());
        });

        return replies;
    }
}
