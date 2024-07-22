package site.metacoding.blogv3.subscribe;

import lombok.Builder;
import lombok.Data;
import site.metacoding.blogv3.post.Post;

import java.util.List;

public class SubscribeResponse {

    @Data
    public static class ListDTO {
        //        post_id, title, user_id, username 을 List로
        private Integer toUserId;
        private Integer fromUserId;
        private String username;
        private Integer postId;
        private String title;
//        private List<PostDTO> postDTOs;


        @Builder
        public ListDTO(Integer toUserId, Integer fromUserId, String username, Integer postId, String title) {
            this.toUserId = toUserId;
            this.fromUserId = fromUserId;
            this.username = username;
            this.postId = postId;
            this.title = title;
        }


//        @Data
//        public static class PostDTO {
//            private Integer postId;
//            private String title;
//
//            @Builder
//            public PostDTO(Integer postId, String title) {
//                this.postId = postId;
//                this.title = title;
//            }
//        }
    }

}


