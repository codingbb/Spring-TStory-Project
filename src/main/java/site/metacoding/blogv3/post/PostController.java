package site.metacoding.blogv3.post;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import site.metacoding.blogv3._core.util.ApiUtil;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;
    private final HttpSession session;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        List<PostResponse.IndexDTO> postList = postService.indexPostAll();
        request.setAttribute("model", postList);
        return "main";
    }


    @GetMapping("/post/update-form/{postId}")
    public String updateForm(@PathVariable Integer postId, HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
//        System.out.println("postId = " + postId);
        PostResponse.UpdateFormDTO updateFormDTO = postService.updateForm(postId, user.getId());

        request.setAttribute("model", updateFormDTO);
        return "post/updateForm";
    }


    @PostMapping("/post/update/{postId}")
    public String update(@PathVariable Integer postId, PostRequest.UpdateDTO requestDTO) {
        User user = (User) session.getAttribute("sessionUser");
        postService.postUpdate(postId, user.getId(), requestDTO);

        return "redirect:/post/list";
    }


    @PostMapping("/post/delete/{postId}")
    public String delete(@PathVariable Integer postId) {
        User user = (User) session.getAttribute("sessionUser");
        postService.delete(postId, user);

        return "redirect:/post/list";
    }


    @PostMapping("/post/save")
    public String save(@ModelAttribute PostRequest.SaveDTO requestDTO) {
//        System.out.println("post RequestDTO = " + requestDTO);

        User user = (User) session.getAttribute("sessionUser");
        postService.postSave(user.getId(), requestDTO);

        return "redirect:/post/list";
    }


    @GetMapping("/post/detail/{postId}")
    public String postDetail(@PathVariable Integer postId, HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
//        System.out.println("user = " + user);
        PostResponse.DetailDTO postDetail = postService.postDetail(postId, user);

        request.setAttribute("model", postDetail);

        return "post/detail";
    }

    @GetMapping("/api/post/list")
    public ResponseEntity<?> postList(@PageableDefault(size = 5) Pageable pageable) {
        User user = (User) session.getAttribute("sessionUser");
        Page<PostResponse.ListDTO> listDTOs = postService.postList(user.getId(), pageable);
//        System.out.println("listDTOs = " + listDTOs);

//        request.setAttribute("model", listDTOs);
        return ResponseEntity.ok(new ApiUtil<>(listDTOs));
    }

    @GetMapping("/post/list")
    public String postList(HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        List<PostResponse.ListDTO> listDTOs = postService.postList(user.getId());

        request.setAttribute("model", listDTOs);
        return "post/list";
    }


    //    유저들의 블로그 post list 보기
    @GetMapping("/user/{userId}/post")
    public String userPost(@PathVariable Integer userId) {
        List<PostResponse.UserBlogListDTO> postList = postService.userBlogList(userId);
        System.out.println("postList = " + postList);

//        return "redirect:/";
        return "/post/list";

    }


    @GetMapping("/post/write-form")
    public String postWriteForm(HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        PostResponse.WriteFormDTO writeFormDTOList = postService.writeForm(user.getId());
//        System.out.println("writeFormDTOList = " + writeFormDTOList);

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
