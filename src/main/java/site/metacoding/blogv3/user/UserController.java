package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserService userService;

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
//        System.out.println("requestDTO = " + requestDTO);

        User sessionUser = userService.join(requestDTO);
        // 회원가입 후 바로 로그인....... 필요없나요?
        session.setAttribute("sessionUser", sessionUser);

        return "redirect:/";
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
    public String login(UserRequest.LoginDTO requestDTO) {
//        System.out.println("requestDTO 1 = " + requestDTO);

        User sessionUser = userService.login(requestDTO);
        session.setAttribute("sessionUser", sessionUser);

        return "redirect:/";
    }

    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {

        return "user/passwordResetForm";
    }

    @GetMapping("/user/update-form")
    public String updateForm() {

        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

}