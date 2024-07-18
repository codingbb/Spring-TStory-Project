package site.metacoding.blogv3.subscribe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SubscribeController {
    private final SubscribeService subscribeService;
    private final HttpSession session;

    // 나를 구독
    @GetMapping("/sub/subscribers-list")
    public String list() {

        return "subscribe/subscribersList";
    }

    //내가 구독
    @GetMapping("/sub/subscribe")
    public String myList(HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        List<SubscribeResponse.ListDTO> listDTOs = subscribeService.subscribeList(user);
//        System.out.println("listDTOs = " + listDTOs);
        request.setAttribute("model", listDTOs);
        return "subscribe/subscribeList";
    }

    @PostMapping("/sub/save")
    public String save() {
        User user = (User) session.getAttribute("sessionUser");
        subscribeService.save();
        return null;
    }

}
