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
            private Integer toUser;
            private Integer fromUser;    // pk
            private String username;

            public SubDTO(Subscribe subscribe) {
                this.toUser = subscribe.getToUser().getId();
                this.fromUser = subscribe.getFromUser().getId();
                this.username = subscribe.getToUser().getUsername();
            }
        }
    }

}
