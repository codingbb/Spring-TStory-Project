package site.metacoding.blogv3.subscribe;

import lombok.Data;
import site.metacoding.blogv3.user.User;

public class SubscribeRequest {

    @Data
    public static class SaveDTO {
        private Integer subscribeId;    //구독하려는 블로그 주인

        public Subscribe toEntity(User fromUser, User toUser) {
            return Subscribe.builder()
                    .fromUser(fromUser)
                    .toUser(toUser)
                    .build();
        }

    }


}
