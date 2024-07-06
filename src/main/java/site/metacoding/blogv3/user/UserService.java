package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.errors.exception.LoginFailException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userRepo;

    @Transactional
    public User join(UserRequest.JoinDTO requestDTO) {
        Optional<User> userOP = userRepo.findByUsername(requestDTO.getUsername());

        //포함하면 true 반환 되어서 throw가 실행될 것임
        if (userOP.isPresent()) {
            throw new RuntimeException("중복된 아이디입니다.");
        }

        User user = userRepo.save(requestDTO.toEntity());
        return user;
    }

    public User login(UserRequest.LoginDTO requestDTO) {
        User user = userRepo.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword())
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        return user;
    }

    public UserResponse.UpdateDTO UpdateForm(Integer sessionUserId) {
        User user = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        return new UserResponse.UpdateDTO(user.getUsername(), user.getEmail());

    }

    //비밀번호 변경
    @Transactional
    public void userUpdate(Integer sessionUserId, UserRequest.UpdateDTO requestDTO) {
        //먼저 조회
        User user = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException());

        if (requestDTO.getNewPassword().equals(user.getPassword())) {
            //
            throw new RuntimeException("동일한 비밀번호로는 변경할 수 없습니다.");
        }

        if (!requestDTO.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("기존 비밀번호가 일치하지 않습니다.");
        }

        user.setPassword(requestDTO.getNewPassword());

    }

//    username 중복 검색
    public UserEnum usernameCheck(String username) {
        Optional<User> userOP = userRepo.findByUsername(username);
//        System.out.println("userOP = " + userOP);

        UserEnum userStatus;

        if (userOP.isPresent()) {
            userStatus = UserEnum.USER_EXIST;
            System.out.println("userStatus = " + userStatus);
            return userStatus;

        } else {
            userStatus = UserEnum.USER_NO_EXIST;
            System.out.println("userStatus = " + userStatus);
            return userStatus;
        }

    }
}
