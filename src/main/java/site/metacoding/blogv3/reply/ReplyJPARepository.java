package site.metacoding.blogv3.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyJPARepository extends JpaRepository<Reply, Integer> {

    @Query("select r from Reply r where r.post.id = :postId order by r.id desc")
    List<Reply> findByPostId(Integer postId);
}
