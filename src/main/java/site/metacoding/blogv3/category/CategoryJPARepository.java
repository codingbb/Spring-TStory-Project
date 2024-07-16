package site.metacoding.blogv3.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.metacoding.blogv3.post.PostResponse;
import site.metacoding.blogv3.user.User;

import java.util.List;
import java.util.Optional;

public interface CategoryJPARepository extends JpaRepository<Category, Integer> {


    @Query("select c from Category c where c.categoryName = :categoryName and c.user.id = :sessionUserId")
    Optional<Category> findByCategoryNameAndUserId (String categoryName, Integer sessionUserId);

    @Query("select new site.metacoding.blogv3.post.PostResponse$WriteFormDTO$CategoryNameDTO(c.id, c.categoryName) " +
            "from Category c where c.user.id = :sessionUser order by c.categoryName")
    List<PostResponse.WriteFormDTO.CategoryNameDTO> findByUserId(Integer sessionUser);

    @Query("select new site.metacoding.blogv3.post.PostResponse$UpdateFormDTO$CategoryNameDTO(c.id, c.categoryName) " +
            "from Category c where c.user.id = :sessionUserId order by c.categoryName")
    List<PostResponse.UpdateFormDTO.CategoryNameDTO> findByUserIdUpdate(Integer sessionUserId);
}
