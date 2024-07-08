package site.metacoding.blogv3.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;


}
