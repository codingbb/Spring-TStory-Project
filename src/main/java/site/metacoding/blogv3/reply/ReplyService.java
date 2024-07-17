package site.metacoding.blogv3.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.post.PostJPARepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyJPARepository replyRepo;
    private final UserJPARepository userRepo;
    private final PostJPARepository postRepo;

    @Transactional
    public void replySave(Integer sessionUserId, ReplyRequest.SaveDTO requestDTO) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new RuntimeException("게시글이 존재하지 않습니다."));

        replyRepo.save(requestDTO.toEntity(sessionUser, post, requestDTO.getComment()));
    }


    @Transactional
    public void replyUpdate(User user, Integer replyId, ReplyRequest.UpdateDTO requestDTO) {
        Reply reply = replyRepo.findById(replyId).orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다"));
        Post post = postRepo.findById(requestDTO.getPostId()).orElseThrow(()
                -> new RuntimeException("게시글이 존재하지 않습니다."));

        reply.setComment(requestDTO.getComment());

    }
}
