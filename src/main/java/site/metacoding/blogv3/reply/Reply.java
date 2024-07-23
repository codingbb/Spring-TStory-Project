package site.metacoding.blogv3.reply;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3.post.Post;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Data
@Table(name = "reply_tb")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Transient
    private Boolean isReplyOwner;

    @Builder
    public Reply(Integer id, String comment, User user, Post post, LocalDateTime createdAt) {
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.post = post;
        this.createdAt = createdAt;
    }


}
