package site.metacoding.blogv3.subscribe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3._core.exception.Exception404;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeJPARepository subscribeRepo;
    private final UserJPARepository userRepo;
    private final SubscribeQueryRepository subscribeQueryRepo;


    @Transactional
    public void cancel(User sessionUser, SubscribeRequest.SaveDTO requestDTO) {
        User user = userRepo.findById(requestDTO.getSubscribeId())
                .orElseThrow(() -> new Exception404("존재하지 않는 블로그입니다."));

        subscribeRepo.deleteSubscribe(sessionUser.getId(), requestDTO.getSubscribeId());

    }

    @Transactional
    public void save(User sessionUser, SubscribeRequest.SaveDTO requestDTO) {
        User userOP = userRepo.findById(requestDTO.getSubscribeId())
                .orElseThrow(() -> new Exception404("존재하지 않는 블로그입니다."));

        // 구독하려는 사람(구독자), 구독대상자
//        subscribeRepo.existsBySubId(sessionUser.getId(), requestDTO.getSubscribeId());

        subscribeRepo.save(requestDTO.toEntity(sessionUser, userOP));

    }

    public List<SubscribeResponse.ListDTO> subscribeList(User fromUserId) {
//        fromUserId = SessionUsrId
        List<SubscribeResponse.ListDTO> rows = subscribeQueryRepo.subscribeList(fromUserId.getId());
        System.out.println("rows = " + rows);

        return rows;
    }

}
