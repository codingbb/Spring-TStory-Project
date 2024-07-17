package site.metacoding.blogv3.reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final ReplyService replyService;
    private final HttpSession session;


    @PostMapping("/reply/delete/{replyId}")
    public String delete(@PathVariable Integer replyId, ReplyRequest.DeleteDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO);
        User user = (User) session.getAttribute("sessionUser");
        replyService.replyDelete(user, replyId, requestDTO);

        return "redirect:/post/detail/" + requestDTO.getPostId();
    }


    @PostMapping("/reply/update/{replyId}")
    public String update(@PathVariable Integer replyId, ReplyRequest.UpdateDTO requestDTO) {
        System.out.println("코멘트!! = " + requestDTO);
        User user = (User) session.getAttribute("sessionUser");
        replyService.replyUpdate(user, replyId, requestDTO);

        return "redirect:/post/detail/" + requestDTO.getPostId();
    }

    @PostMapping("/reply/save")
    public String save(ReplyRequest.SaveDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO);
        User user = (User) session.getAttribute("sessionUser");
        replyService.replySave(user.getId(), requestDTO);

//        postid 붙여서 하기
        return "redirect:/post/detail/" + requestDTO.getPostId();
    }

}
