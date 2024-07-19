package site.metacoding.blogv3.subscribe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.user.User;
import site.metacoding.blogv3.user.UserJPARepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeJPARepository subscribeRepo;
    private final UserJPARepository userRepo;


    @Transactional
    public void cancel(User sessionUser, SubscribeRequest.SaveDTO requestDTO) {
        User user = userRepo.findById(requestDTO.getSubscribeId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 블로그입니다."));

        subscribeRepo.deleteSubscribe(sessionUser.getId(), requestDTO.getSubscribeId());

    }

    @Transactional
    public void save(User sessionUser, SubscribeRequest.SaveDTO requestDTO) {
        User userOP = userRepo.findById(requestDTO.getSubscribeId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 블로그입니다."));

        // 구독하려는 사람(구독자), 구독대상자
//        subscribeRepo.existsBySubId(sessionUser.getId(), requestDTO.getSubscribeId());

        subscribeRepo.save(requestDTO.toEntity(sessionUser, userOP));

    }

    public SubscribeResponse.ListDTO subscribeList(User sessionUser) {
        List<Subscribe> subscribeList = subscribeRepo.findSubscribeList(sessionUser.getId());
        List<SubscribeResponse.ListDTO.SubDTO> listDTOs = subscribeList.stream().map(subscribe
                -> new SubscribeResponse.ListDTO.SubDTO(subscribe)).toList();

        SubscribeResponse.ListDTO listDTO = new SubscribeResponse.ListDTO(listDTOs);

        return listDTO;
    }

}
