package site.metacoding.blogv3.subscribe;

import lombok.Data;

import java.util.List;

public class SubscribeResponse {

    @Data
    public static class ListDTO {
        private List<SubDTO> subDTOs;

        public ListDTO(List<SubDTO> subDTOs) {
            this.subDTOs = subDTOs;
        }

        @Data
        public static class SubDTO {
            private Integer userId;
            private Integer subscribeId;    // 내가 구독
            private String username;

            public SubDTO(Subscribe subscribe) {
                this.userId = subscribe.getUser().getId();
                this.subscribeId = subscribe.getId();
                this.username = subscribe.getUser().getUsername();
            }
        }
    }

}
