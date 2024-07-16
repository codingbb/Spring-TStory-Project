package site.metacoding.blogv3.reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final ReplyService replyService;
    private final HttpSession session;


    @PostMapping("/reply/save")
    public String save(ReplyRequest.SaveDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO);
        User user = (User) session.getAttribute("sessionUser");
        replyService.replySave(user.getId(), requestDTO);

//        postid 붙여서 하기
        return "redirect:/post/detail/" + requestDTO.getPostId();
    }

}
