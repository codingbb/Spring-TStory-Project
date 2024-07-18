package site.metacoding.blogv3.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscribeJPARepository extends JpaRepository<Subscribe, Integer> {

//    select u.id, p.title, s.subscriber_id, s.subscribe_id from user_tb u
//    inner join post_tb p on u.id = p.user_id
//    inner join subscribe_tb s on u.id = s.subscribe_id where  s.subscriber_id = 1;

//    select u.id, s.subscriber_id, u.username, s.subscribe_id from subscribe_tb s
//    inner join user_tb u on u.id = s.subscribe_id where  s.subscriber_id = 1;
    @Query("select s from Subscribe s join fetch s.user u where s.subscriber.id = :sessionUserId")
    List<Subscribe> findSubscribeList(Integer sessionUserId);
}
