package site.metacoding.blogv3.post;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostResponse {

    @Data
    public static class ListDTO {
        //썸네일, 내용(flow건거), 제목, 생성날짜
        private Integer postId;
        private String thumbnailFile;
        private String title;
        private String content;
        private String createdAt;

        public ListDTO(Integer postId, String thumbnailFile, String title, String content, LocalDateTime createdAt) {
            this.postId = postId;
            this.thumbnailFile = thumbnailFile;
            this.title = title;
            this.content = content;
            this.createdAt = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd (HH:mm)"));

        }
    }


    @Data
    public static class WriteFormDTO {
        private List<CategoryNameDTO> categoryNameDTO;

        public WriteFormDTO(List<CategoryNameDTO> categoryNameDTO) {
            this.categoryNameDTO = categoryNameDTO;
        }

        // 카테고리 네임 뿌리기
        @Data
        public static class CategoryNameDTO {
            private Integer id;     // 카테고리 id (post 저장할때 같이 저장)
            private String categoryName;

            public CategoryNameDTO(Integer id, String categoryName) {
                this.id = id;
                this.categoryName = categoryName;
            }
        }
    }


}
