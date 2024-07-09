package site.metacoding.blogv3.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryJPARepository categoryRepo;
    private final UserJPARepository userRepo;

    @Transactional
    public void save(String categoryName, Integer sessionUserId) {
        User sessionUser = userRepo.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));

        Optional<Category> categoryOP = categoryRepo.findByCategoryNameAndUserId(categoryName, sessionUserId);

        if (categoryOP.isPresent()) {
            throw new RuntimeException("이미 존재하는 카테고리입니다.");
        } else {
            categoryRepo.save(Category.builder()
                    .categoryName(categoryName)
                    .user(sessionUser)
                    .build());
        }

    }
}
