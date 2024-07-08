package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.errors.exception.LoginFailException;
import site.metacoding.blogv3._core.util.EmailUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userRepo;
    private final EmailUtil emailUtil;


    // 이메일 인증
    public String mailCheck(String email) {
        String decodedEmail;
        // 이메일 주소 디코딩
        try {
            decodedEmail = URLDecoder.decode(email, "UTF-8");
            System.out.println("decodedEmail = " + decodedEmail);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        // 타이틀
        String subject = "[Tistroy 회원가입 인증메일입니다]";

//        랜덤한 인증번호
        Random random = new Random();
        int randomNumb;
        String randomNumStr = "";

        for (int i = 0; i < 8; i++) {
            // 0부터 9까지
            randomNumb = random.nextInt(10);
            randomNumStr = randomNumStr + randomNumb;

        }
//        System.out.println("randomNumStr = " + randomNumStr);

        emailUtil.sendEmail(decodedEmail, subject, randomNumStr);

        return randomNumStr;

    }


    @Transactional
    public User join(UserRequest.JoinDTO requestDTO) {
        Optional<User> userOP = userRepo.findByUsername(requestDTO.getUsername());

        //포함하면 true 반환 되어서 throw가 실행될 것임
        if (userOP.isPresent()) {
            throw new RuntimeException("중복된 아이디입니다.");
        }

        if (requestDTO.getIsEmailConfirmed() == true) {
            User user = userRepo.save(requestDTO.toEntity());
            return user;

        } else {
            throw new RuntimeException("이메일 인증이 필요합니다.");
        }

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
