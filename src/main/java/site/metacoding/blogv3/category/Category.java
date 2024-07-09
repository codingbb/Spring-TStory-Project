package site.metacoding.blogv3.category;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "category_tb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Category(Integer id, String categoryName, User user, LocalDateTime createdAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.user = user;
        this.createdAt = createdAt;
    }
}
