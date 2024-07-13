package site.metacoding.blogv3.post;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.category.CategoryJPARepository;
import site.metacoding.blogv3.category.CategoryResponse;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostJPARepository postRepo;
    private final CategoryJPARepository categoryRepo;
    private final UserJPARepository userRepo;

    @Transactional
    public PostResponse.WriteFormDTO writeForm(Integer sessionUserId) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        List<PostResponse.WriteFormDTO.CategoryNameDTO> categoryList = categoryRepo.findByUserId(sessionUser.getId());
        System.out.println("categoryList = " + categoryList);

        PostResponse.WriteFormDTO writeFormDTO = new PostResponse.WriteFormDTO(categoryList);

        return writeFormDTO;

    }

    @Transactional
    public void postSave(Integer sessionUserId, PostRequest.SaveDTO requestDTO) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        Category category = categoryRepo.findById(requestDTO.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("카테고리가 존재하지 않습니다"));

        Document doc = Jsoup.parse(requestDTO.getContent());
        Elements imgElements = doc.select("img");   //태그 찾기
        for (Element element : imgElements) {
            element.attr("width", "600");
            element.attr("height", "300");
        }

        String content = doc.html();
        System.out.println("content = " + content);

        postRepo.save(requestDTO.toEntity(sessionUser, category, content, requestDTO.getThumbnailFile()));
        

    }

    public List<PostResponse.ListDTO> postList(Integer sessionUserId) {
        List<PostResponse.ListDTO> listDTOs = postRepo.findByPostList(sessionUserId);
        System.out.println("listDTOs = " + listDTOs);

        return listDTOs;
    }
}
