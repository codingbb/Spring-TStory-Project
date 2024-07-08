package site.metacoding.blogv3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "main";
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
    public String postWriteForm() {

        return "post/writeForm";
    }


}
