package site.metacoding.blogv3.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostJPARepository extends JpaRepository<Post, Integer> {


    @Query("select new site.metacoding.blogv3.post.PostResponse$ListDTO(p.id, p.thumbnailFile, p.title, p.content, p.createdAt) " +
            "from Post p where p.user.id = :sessionUserId order by p.id desc")
    List<PostResponse.ListDTO> findByPostList(Integer sessionUserId);


    @Query("select new site.metacoding.blogv3.post.PostResponse$DetailDTO(p.id, p.title, p.content, p.user.id, p.user.username, p.createdAt)" +
            "from Post p where p.id = :postId")
    Optional<PostResponse.DetailDTO> findByPostId(Integer postId);
}
