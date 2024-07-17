package site.metacoding.blogv3.reply;

import lombok.Data;
import site.metacoding.blogv3.user.User;

public class ReplyResponse {

    @Data
    public static class UpdateDTO {
        private Integer id;     //replyId
        private String comment;
        private Integer userId;
        private String username;
        private Integer postId;
        private Boolean isReplyOwner;

        public UpdateDTO(Reply reply, User user) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId();
            this.username = reply.getUser().getUsername();
            this.postId = reply.getPost().getId();

            isReplyOwner = false;
            if (user != null) {
                if (user.getId() == reply.getUser().getId()) {
                    isReplyOwner = true;
                }
            }
        }
    }


    @Data
    public static class ListDTO {
        private Integer id; //reply Id
        private String comment;
        private Integer userId;
        private String username;
        private Integer postId;
        private Boolean isReplyOwner;

        public ListDTO(Integer id, String comment, Integer userId, String username, Integer postId) {
            this.id = id;
            this.comment = comment;
            this.userId = userId;
            this.username = username;
            this.postId = postId;

        }
    }


    @Data
    public static class SaveDTO {
        private Integer id; //reply Id
        private String comment;
        private Integer userId;
        private String username;
        private Integer postId;
        private Boolean isReplyOwner;

        public SaveDTO(User sessionUser, Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId();
            this.username = reply.getUser().getUsername();
            this.postId = reply.getPost().getId();

            this.isReplyOwner = false;
            if (sessionUser != null) {
                if (sessionUser.getId() == reply.getUser().getId()) {
                    isReplyOwner = true;
                }
            }

        }
    }


}
