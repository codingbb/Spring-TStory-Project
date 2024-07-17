package site.metacoding.blogv3.reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyJPARepository extends JpaRepository<Reply, Integer> {

    @Query("select r from Reply r where r.post.id = :postId order by r.id desc")
    List<Reply> findByPostId(Integer postId);

    @Query("select new site.metacoding.blogv3.reply.ReplyResponse$ListDTO" +
            "(r.id, r.comment, r.user.id, r.user.username, r.post.id) " +
            "from Reply r where r.post.id = :postId order by r.id desc")
    Page<ReplyResponse.ListDTO> findAllReply(Integer postId, Pageable pageable);
}
