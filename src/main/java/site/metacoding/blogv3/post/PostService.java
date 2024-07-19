package site.metacoding.blogv3.post;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.category.Category;
import site.metacoding.blogv3.category.CategoryJPARepository;
import site.metacoding.blogv3.category.CategoryResponse;
import site.metacoding.blogv3.reply.Reply;
import site.metacoding.blogv3.reply.ReplyJPARepository;
import site.metacoding.blogv3.subscribe.Subscribe;
import site.metacoding.blogv3.subscribe.SubscribeJPARepository;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostJPARepository postRepo;
    private final CategoryJPARepository categoryRepo;
    private final UserJPARepository userRepo;
    private final ReplyJPARepository replyRepo;
    private final SubscribeJPARepository subscribeRepo;

    @Transactional
    public void postUpdate(Integer postId, Integer sessionUserId, PostRequest.UpdateDTO requestDTO) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        if (post.getUser().getId() != sessionUserId) {
            throw new RuntimeException("수정 권한이 존재하지 않습니다");
        }

        if (!requestDTO.getThumbnailFile().isEmpty()) {
            // 의미있는 메소드
            post.update(requestDTO);

        } else {
            post.setTitle(requestDTO.getTitle());
            post.setContent(requestDTO.getContent());
            post.setCategory(requestDTO.getCategory());
            post.setThumbnailFile(post.getThumbnailFile());

        }

    }

    public PostResponse.UpdateFormDTO updateForm(Integer postId, Integer sessionUserId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
        List<PostResponse.UpdateFormDTO.CategoryNameDTO> categoryNameDTOS = categoryRepo.findByUserIdUpdate(sessionUserId);
//        System.out.println("categoryNameDTOS = " + categoryNameDTOS);

        if (post.getUser().getId() != sessionUserId) {
            throw new RuntimeException("수정 권한이 존재하지 않습니다");
        }

        PostResponse.UpdateFormDTO updateFormDTO = new PostResponse.UpdateFormDTO(post, categoryNameDTOS);
//        System.out.println("updateFormDTO = " + updateFormDTO);

        return updateFormDTO;

    }


    @Transactional
    public void delete(Integer postId, User user) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));

        if (user.getId() != post.getUser().getId()) {
            throw new RuntimeException("게시글 삭제 권한이 없습니다.");
        }

        postRepo.deleteById(postId);

    }


    @Transactional
    public PostResponse.WriteFormDTO writeForm(Integer sessionUserId) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        List<PostResponse.WriteFormDTO.CategoryNameDTO> categoryList = categoryRepo.findByUserId(sessionUser.getId());
//        System.out.println("categoryList = " + categoryList);

        PostResponse.WriteFormDTO writeFormDTO = new PostResponse.WriteFormDTO(categoryList);

        return writeFormDTO;

    }

    @Transactional
    public void postSave(Integer sessionUserId, PostRequest.SaveDTO requestDTO) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        Category category = categoryRepo.findById(requestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리가 존재하지 않습니다"));


        //1. 퀼 에디터로 작성된 내용을 Jsoup을 사용하여 파싱
        Document doc = Jsoup.parse(requestDTO.getContent());

        //2. 파싱된 문서에서 YouTube URL 패턴을 찾는다.
        Pattern youtubePattern = Pattern.compile("https://www\\.youtube\\.com/watch\\?v=([a-zA-Z0-9_-]+)");
        Matcher matcher = youtubePattern.matcher(requestDTO.getContent());

        while (matcher.find()) {
            //3. 찾은 YouTube URL에서 동영상 ID를 추출
            String videoId = matcher.group(1);

            //4. 동영상 ID를 사용하여 iframe 태그를 생성하고 문서에 삽입한다.
            Element iframe = new Element("iframe");
            iframe.attr("width", "560");
            iframe.attr("height", "315");
            iframe.attr("src", "https://www.youtube.com/embed/" + videoId);
            iframe.attr("frameborder", "0");
            iframe.attr("allowfullscreen", "true");

            //5. iframe이 삽입된 걸로 교체
            Element pTag = doc.select("p:containsOwn(" + matcher.group() + ")").first();
            if (pTag != null) {
                pTag.replaceWith(iframe);
            }
        }

        String content = doc.html();


//        Elements imgElements = doc.select("img");   //태그 찾기
//        for (Element element : imgElements) {
//            element.attr("width", "560");
//            element.attr("height", "315");
//        }
//        String content = doc.html();
//        System.out.println("content = " + content);


        postRepo.save(requestDTO.toEntity(sessionUser, category, content, requestDTO.getThumbnailFile()));

    }


    // readOnly를 하면 DB에 반영을 하지 않게 되어 프로그램이 더 깔끔해진다 (페이징)
    @Transactional(readOnly = true)
    public Page<PostResponse.ListDTO.PostDTO> postList(Integer sessionUserId, Pageable pageable) {
        Page<PostResponse.ListDTO.PostDTO> postLists = postRepo.findByPostList(sessionUserId, pageable);
//        System.out.println("postLists = " + postLists);

        return postLists;
    }

    //    페이징 xx
    @Transactional(readOnly = true)
    public PostResponse.ListDTO postList(User sessionUser) {
        List<Post> postList = postRepo.findAllPostList(sessionUser.getId());
//        List<PostResponse.ListDTO> postLists = postRepo.findByPostList(sessionUser.getId());
        List<PostResponse.ListDTO.PostDTO> postDTOs = postList.stream().map(post
                -> new PostResponse.ListDTO.PostDTO(post)).toList();

        PostResponse.ListDTO listDTO = new PostResponse.ListDTO(postDTOs, sessionUser);

        return listDTO;
    }

    @Transactional(readOnly = true)
    public PostResponse.DetailDTO postDetail(Integer postId, User sessionUser) {
//        게시글 부분
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
//        PostResponse.DetailDTO detailDTO = new PostResponse.DetailDTO(post, replies, sessionUser);
        PostResponse.DetailDTO detailDTO = new PostResponse.DetailDTO(post, sessionUser);

        return detailDTO;

    }


    @Transactional(readOnly = true)
    public List<PostResponse.IndexDTO> indexPostAll() {
        List<Post> postList = postRepo.findAllRandom();
        List<PostResponse.IndexDTO> indexDTOs = postList.stream().map(post -> new PostResponse.IndexDTO(post)).toList();

        return indexDTOs;
    }

    @Transactional(readOnly = true)
    public PostResponse.UserBlogListDTO userBlogList(Integer userId, User sessionUser) {
        List<Post> postList = postRepo.findAllUserPostList(userId);
        List<PostResponse.UserBlogListDTO.PostDTO> postDTOs = postList.stream().map(post ->
                new PostResponse.UserBlogListDTO.PostDTO(post)).toList();

        boolean isSubCheck = false;
//        System.out.println("isSubCheck 111111= " + isSubCheck);

        if (sessionUser != null) {
            // true - 구독 중, false - 구독 x
            Subscribe subscribe = subscribeRepo.existsBySubId(sessionUser.getId(), userId);
            if (subscribe != null) {
                isSubCheck = true;
            }
        }

//        System.out.println("isSubCheck222222222 = " + isSubCheck);

        PostResponse.UserBlogListDTO blogListDTOs = new PostResponse.UserBlogListDTO(postDTOs, userId, sessionUser, isSubCheck);
//        System.out.println("blogListDTOs 3333333 = " + blogListDTOs);

        return blogListDTOs;
    }
}
