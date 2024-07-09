package site.metacoding.blogv3.post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String content;
        private Integer categoryId;
        private MultipartFile thumbnailFile;

    }

}
