package site.metacoding.blogv3.image;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.post.Post;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "image_tb")
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private String imgFilename;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Image(Integer id, Post post, String imgFilename, LocalDateTime createdAt) {
        this.id = id;
        this.post = post;
        this.imgFilename = imgFilename;
        this.createdAt = createdAt;
    }
}
