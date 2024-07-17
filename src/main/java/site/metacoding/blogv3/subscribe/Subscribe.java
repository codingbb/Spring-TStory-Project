package site.metacoding.blogv3.subscribe;

import jakarta.persistence.*;
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
    private User subscriber; // 구독하는 사용자

    @JoinColumn(name = "target_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User target; // 구독 당하는 사람

    @CreationTimestamp
    private LocalDateTime createdAt;

}
