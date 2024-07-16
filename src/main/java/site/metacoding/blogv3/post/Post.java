package site.metacoding.blogv3.post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import site.metacoding.blogv3._core.util.ImageUtil;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.image.Image;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "post_tb")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private String thumbnailFile; //섬네일

    @Transient
    private Boolean isPostOwner;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Reply> replyList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Post(Integer id, String title, String content, User user, Category category, String thumbnailFile, Boolean isPostOwner, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.category = category;
        this.thumbnailFile = thumbnailFile;
        this.isPostOwner = isPostOwner;
        this.createdAt = createdAt;
    }


    //    의미있는 메소드
    public void update(PostRequest.UpdateDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.category = requestDTO.getCategory();
        String imgThumbnailFile = ImageUtil.save(requestDTO.getThumbnailFile());
        this.thumbnailFile = imgThumbnailFile;
    }

}
