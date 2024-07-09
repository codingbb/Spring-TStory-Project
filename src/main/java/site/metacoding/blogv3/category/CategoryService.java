package site.metacoding.blogv3.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryJPARepository categoryRepo;
    private final UserJPARepository userRepo;

    @Transactional
    public void save(String categoryName, Integer sessionUserId) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        categoryRepo.save(Category.builder()
                .categoryName(categoryName)
                .user(sessionUser)
                .build());

    }
}
