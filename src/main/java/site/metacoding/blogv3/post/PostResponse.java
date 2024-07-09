package site.metacoding.blogv3.post;

import lombok.Data;

import java.util.List;

public class PostResponse {


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
