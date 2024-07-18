package site.metacoding.blogv3.subscribe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.blogv3.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeJPARepository subscribeRepo;

    @Transactional
    public void save() {

    }

    public SubscribeResponse.ListDTO subscribeList(User user) {
        List<Subscribe> subscribeList = subscribeRepo.findSubscribeList(user.getId());
        List<SubscribeResponse.ListDTO.SubDTO> listDTOs = subscribeList.stream().map(subscribe
                -> new SubscribeResponse.ListDTO.SubDTO(subscribe)).toList();

        SubscribeResponse.ListDTO listDTO = new SubscribeResponse.ListDTO(listDTOs);

        return listDTO;
    }
}
