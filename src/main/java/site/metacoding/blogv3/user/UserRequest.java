package site.metacoding.blogv3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class UpdateDTO {
        private String password;
        private String newPassword;
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }

    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
        private Boolean isEmailConfirmed;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
//                    .emailConfirm(isEmailConfirmed)
                    .build();

        }
    }

}
