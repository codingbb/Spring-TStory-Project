package site.metacoding.blogv3.subscribe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeJPARepository SubscribeRepo;

    @Transactional
    public void save() {

    }
}
