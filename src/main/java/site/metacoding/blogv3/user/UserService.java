package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.errors.exception.LoginFailException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userRepo;

    @Transactional
    public User join(UserRequest.JoinDTO requestDTO) {
        Optional<User> userOP = userRepo.findByUsername(requestDTO.getUsername());

        //포함하면 true 반환 되어서 throw가 실행될 것임
        if (userOP.isPresent()) {
            throw new RuntimeException();
        }

        User user = userRepo.save(requestDTO.toEntity());
        return user;
    }

    public User login(UserRequest.LoginDTO requestDTO) {
        User user = userRepo.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword())
                .orElseThrow(() -> new RuntimeException());

        return user;
    }
}
