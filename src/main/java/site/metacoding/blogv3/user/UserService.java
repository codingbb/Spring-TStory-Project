package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.errors.exception.LoginFailException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userRepo;

    @Transactional
    public User join(UserRequest.JoinDTO requestDTO) {
        User user = userRepo.save(requestDTO.toEntity());
        return user;
    }

    public User login(UserRequest.LoginDTO requestDTO) {
        User user = userRepo.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword())
                .orElseThrow(() -> new RuntimeException());

        return user;
    }
}
