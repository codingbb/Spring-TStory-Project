package site.metacoding.blogv3.reply;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.metacoding.blogv3._core.util.ApiUtil;
import site.metacoding.blogv3.user.User;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final ReplyService replyService;
    private final HttpSession session;

    @GetMapping("/api/reply/list")
    public ResponseEntity<?> replyList(@RequestParam Integer postId, @PageableDefault(size = 3) Pageable pageable) {
        User user = (User) session.getAttribute("sessionUser");
        Page<ReplyResponse.ListDTO> replies = replyService.replyList(user, postId, pageable);

        return ResponseEntity.ok(new ApiUtil<>(replies));
    }

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
    public ResponseEntity<?> save(@RequestBody ReplyRequest.SaveDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO);
        User user = (User) session.getAttribute("sessionUser");
        ReplyResponse.SaveDTO reply = replyService.replySave(user.getId(), requestDTO);
//        postid 붙여서 하기
        return ResponseEntity.ok(new ApiUtil<>(reply));
    }

}
