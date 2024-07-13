package site.metacoding.blogv3.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostJPARepository extends JpaRepository<Post, Integer> {


    @Query("select new site.metacoding.blogv3.post.PostResponse$ListDTO(p.id, p.thumbnailFile, p.title, p.content, p.createdAt) " +
            "from Post p where p.user.id = :sessionUserId order by p.id")
    List<PostResponse.ListDTO> findByPostList(Integer sessionUserId);

}
