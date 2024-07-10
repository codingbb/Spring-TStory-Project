package site.metacoding.blogv3.post;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;
    private final HttpSession session;

    @PostMapping("/post/save")
    public String save(@ModelAttribute PostRequest.SaveDTO requestDTO) {
        System.out.println("post RequestDTO = " + requestDTO);

        User user = (User) session.getAttribute("sessionUser");
        postService.postSave(user.getId(), requestDTO);

        return "redirect:/post/list";
    }


    @GetMapping("/post/detail")
    public String postDetail() {

        return "post/detail";
    }

    @GetMapping("/post/list")
    public String postList() {

        return "post/list";
    }

    @GetMapping("/post/write-form")
    public String postWriteForm(HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        PostResponse.WriteFormDTO writeFormDTOList = postService.writeForm(user.getId());
        System.out.println("writeFormDTOList = " + writeFormDTOList);
        
        request.setAttribute("model", writeFormDTOList);

        if (writeFormDTOList.getCategoryNameDTO().isEmpty()) {
            request.setAttribute("noCategory", true);
//            return "redirect:/category/write-form";
        } else {
            request.setAttribute("noCategory", false);
        }

        return "post/writeForm";
    }



}