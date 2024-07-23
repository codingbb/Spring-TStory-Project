package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import site.metacoding.blogv3._core.util.ApiUtil;
import site.metacoding.blogv3._core.util.EmailUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@ModelAttribute UserRequest.JoinDTO requestDTO) {
        System.out.println("JOIN_requestDTO = " + requestDTO);

        if (!requestDTO.getIsEmailConfirmed()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiUtil<>(HttpStatus.BAD_REQUEST.value(), "이메일 인증이 필요합니다."));

        } else {
            User sessionUser = userService.join(requestDTO);
            // 회원가입 후 바로 로그인
            session.setAttribute("sessionUser", sessionUser);
            return ResponseEntity.ok(new ApiUtil<>(200));
        }

    }

    @GetMapping("/send-mail")
    public ResponseEntity<?> sendMail(String email) {
        String emailCode = userService.mailCheck(email);
        System.out.println("emailCode = " + emailCode);

        session.setAttribute("emailCode", emailCode);

        return ResponseEntity.ok(new ApiUtil<>(emailCode));

    }

    @GetMapping("/check-email-code")
    public ResponseEntity<?> checkEmailCode(String emailCode) {
        String sessionEmailCode = (String) session.getAttribute("emailCode");
        System.out.println("sessionEmailCode = " + sessionEmailCode);
        
        if (sessionEmailCode != null && sessionEmailCode.equals(emailCode)) {
            return ResponseEntity.ok(new ApiUtil<>(true));
        } else {
            return ResponseEntity.ok(new ApiUtil<>(false));
        }
    }


    @GetMapping("/username-check")
    public ResponseEntity<?> usernameCheck(String username) {
//        System.out.println("username = " + username);
        UserEnum usernameCheck = userService.usernameCheck(username);
//        System.out.println("usernameCheck = " + usernameCheck);
        return ResponseEntity.ok(new ApiUtil<>(usernameCheck));

    }


    @GetMapping("/join-form")
    public String joinForm() {

        return "user/joinForm";
    }

    @GetMapping("/login-form")
    public String loginForm() {

        return "user/loginForm";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserRequest.LoginDTO requestDTO, Errors errors) {
        System.out.println("requestDTO 1 = " + requestDTO);

        User sessionUser = userService.login(requestDTO);
        session.setAttribute("sessionUser", sessionUser);

        return ResponseEntity.ok(new ApiUtil<>(sessionUser));
//        return "redirect:/";
    }

    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {

        return "user/passwordResetForm";
    }

    @GetMapping("/user/update-form")
    public String updateForm(HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        UserResponse.UpdateDTO updateDTO = userService.UpdateForm(sessionUser.getId());
//        System.out.println("updateDTO = " + updateDTO);
        request.setAttribute("model", updateDTO);

        return "user/updateForm";
    }

    @PutMapping("/user/update")
    public ResponseEntity<?> update(@Valid @RequestBody UserRequest.UpdateDTO requestDTO, Errors errors) {
        System.out.println("requestDTO22222 = " + requestDTO);
//        System.out.println("비번 확인용 = " + requestDTO);
        User sessionUser = (User) session.getAttribute("sessionUser");
        userService.userUpdate(sessionUser.getId(), requestDTO);

        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

}
