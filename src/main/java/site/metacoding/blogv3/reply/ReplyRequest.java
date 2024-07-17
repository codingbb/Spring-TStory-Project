package site.metacoding.blogv3.reply;

import lombok.Data;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.user.User;

public class ReplyRequest {

    @Data
    public static class DeleteDTO {
        private Integer postId;
        private Integer userId;
    }


    @Data
    public static class UpdateDTO {
        private Integer postId;
        private Integer userId;
        private String comment;
    }


    @Data
    public static class SaveDTO {
        private String comment;
        private Integer postId;

        public Reply toEntity(User sessionUser, Post post, String comment) {
            return Reply.builder()
                    .comment(comment)
                    .user(sessionUser)
                    .post(post)
                    .build();
        }

    }

}
