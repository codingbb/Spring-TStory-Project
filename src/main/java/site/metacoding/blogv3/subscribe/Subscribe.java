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

    @JoinColumn(name = "from_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User fromUser; // (구독자) - 세션

    @JoinColumn(name = "to_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User toUser; // (구독)

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Subscribe(Integer id, User fromUser, User toUser, LocalDateTime createdAt) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.createdAt = createdAt;
    }
}
