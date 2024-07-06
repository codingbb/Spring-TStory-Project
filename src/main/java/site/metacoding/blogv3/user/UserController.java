package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.metacoding.blogv3._core.util.ApiUtil;


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

    @GetMapping("/username-check")
    public ResponseEntity<?> usernameCheck(String username) {
//        System.out.println("username = " + username);
        UserEnum usernameCheck = userService.usernameCheck(username);

//        System.out.println("usernameCheck = " + usernameCheck);
        
        if (usernameCheck.equals(UserEnum.USER_EXIST)) {
            return ResponseEntity.ok(new ApiUtil<>(usernameCheck));
        } else {
            return ResponseEntity.ok(new ApiUtil<>(usernameCheck));
        }

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
    public String updateForm(HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        UserResponse.UpdateDTO updateDTO = userService.UpdateForm(sessionUser.getId());
//        System.out.println("updateDTO = " + updateDTO);
        request.setAttribute("model", updateDTO);

        return "user/updateForm";
    }

    @PostMapping("/user/update")
    public ResponseEntity<?> update(@RequestBody UserRequest.UpdateDTO requestDTO) {
//        System.out.println("비번 확인용 = " + requestDTO);
        User sessionUser = (User) session.getAttribute("sessionUser");
        userService.userUpdate(sessionUser.getId(), requestDTO);

        return ResponseEntity.ok(new ApiUtil<>(true));
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

}
