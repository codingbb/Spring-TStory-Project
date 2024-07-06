package site.metacoding.blogv3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {


    // 로그인용 쿼리메소드
    Optional<User> findByUsernameAndPassword (@Param("username") String username, @Param("password") String password);

    @Query("select u from User u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
