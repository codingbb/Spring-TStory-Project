package site.metacoding.blogv3.subscribe;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class SubscribeController {
    private final SubscribeService subscribeService;
    private final HttpSession session;

    @GetMapping("/sub/list")
    public String list() {

        return "/subscribe/subscribeList";
    }


    @PostMapping("/sub/save")
    public String save() {
        User user = (User) session.getAttribute("sessionUser");
        subscribeService.save();
        return null;
    }

}
