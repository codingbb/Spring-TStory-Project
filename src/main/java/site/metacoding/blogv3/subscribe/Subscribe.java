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
    private User subscriber; // (구독자)

    @JoinColumn(name = "subscribe_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User subscribe; // (구독)

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Transient
    private boolean isSubCheck;

    @Builder
    public Subscribe(Integer id, User subscriber, User subscribe, LocalDateTime createdAt, boolean isSubCheck) {
        this.id = id;
        this.subscriber = subscriber;
        this.subscribe = subscribe;
        this.createdAt = createdAt;
        this.isSubCheck = isSubCheck;
    }
}
