package site.metacoding.blogv3.subscribe;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "subscribe_tb")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "subscriber_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User subscriber; // (남이 나를 구독 - 구독자)

    @JoinColumn(name = "subscribe_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // (내가 남을 구독)

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Subscribe(Integer id, User subscriber, User user, LocalDateTime createdAt) {
        this.id = id;
        this.subscriber = subscriber;
        this.user = user;
        this.createdAt = createdAt;
    }
}
