package site.metacoding.blogv3.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostJPARepository extends JpaRepository<Post, Integer> {


    @Query("select new site.metacoding.blogv3.post.PostResponse$ListDTO$PostDTO(p.id, p.user.id, p.thumbnailFile, p.title, p.content, p.createdAt) " +
            "from Post p where p.user.id = :sessionUserId order by p.id desc")
    // 스프링이 알아서 페이징 처리를 해줌
    Page<PostResponse.ListDTO.PostDTO> findByPostList(Integer sessionUserId, Pageable pageable);

    @Query("select new site.metacoding.blogv3.post.PostResponse$ListDTO(p.id, p.thumbnailFile, p.title, p.content, p.createdAt) " +
            "from Post p where p.user.id = :sessionUserId order by p.id desc")
    List<PostResponse.ListDTO> findByPostList(Integer sessionUserId);

    @Query("select new site.metacoding.blogv3.post.PostResponse$DetailDTO(p.id, p.title, p.content, p.user.id, p.user.username, p.createdAt)" +
            "from Post p where p.id = :postId")
    Optional<PostResponse.DetailDTO> findByPostId(Integer postId);

    @Query("select p from Post p ORDER BY rand() limit 8")
    List<Post> findAllRandom();

    @Query("select p from Post p where p.user.id = :userId order by p.id desc")
    List<Post> findAllUserPostList(Integer userId);

    @Query("select p from Post p where p.user.id = :sessionUserId order by p.id desc")
    List<Post> findAllPostList(Integer sessionUserId);
}
