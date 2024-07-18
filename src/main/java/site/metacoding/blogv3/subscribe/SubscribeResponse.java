package site.metacoding.blogv3.subscribe;

import lombok.Data;

public class SubscribeResponse {

    @Data
    public static class ListDTO {
        private Integer userId;
        private Integer subscribeId;    // 내가 구독
        private String username;

        public ListDTO(Subscribe subscribe) {
            this.userId = subscribe.getUser().getId();
            this.subscribeId = subscribe.getId();
            this.username = subscribe.getUser().getUsername();
        }
    }

}
