package site.metacoding.blogv3.subscribe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class SubscribeQueryRepository {
    private final EntityManager em;

    public List<SubscribeResponse.ListDTO> subscribeList(Integer fromUserId) {
        String q = """
                SELECT post_id, title, user_id, u.username
                        FROM (SELECT p.id AS post_id, p.title, p.user_id, s.to_user_id, s.id,
                                ROW_NUMBER() OVER (PARTITION BY p.user_id ORDER BY p.id DESC) AS rn
                                FROM post_tb p
                            
                                JOIN subscribe_tb s
                                ON p.user_id = s.to_user_id
                                WHERE s.from_user_id = ?) AS subquery

                        INNER JOIN user_tb u
                        ON subquery.to_user_id = u.id
                        WHERE rn <= 2
                        ORDER BY subquery.id DESC, post_id DESC
                   """;

        Query query = em.createNativeQuery(q);
        query.setParameter(1, fromUserId);

//        return query.getResultList();

        List<Object[]> rows = query.getResultList();
        List<SubscribeResponse.ListDTO> listDTOs = new ArrayList<>();    // 담는 리스트
        SubscribeResponse.ListDTO listDTO = null;      // row 담는 것

        for (Object[] row : rows) {
            Integer postId = (Integer) row[0];
            String title = (String) row[1];
            Integer toUserId = (Integer) row[2];
            String username = (String) row[3];

            if (listDTO != null && listDTO.getToUserId().equals(toUserId)) {
                listDTO.getPostDTOs().add(new SubscribeResponse.ListDTO.PostDTO(postId, title));

            } else {
                listDTO = SubscribeResponse.ListDTO.builder()
                        .toUserId(toUserId)
                        .username(username)
                        .postDTOs(new ArrayList<>())
                        .build();
                listDTO.getPostDTOs().add(new SubscribeResponse.ListDTO.PostDTO(postId, title));
                listDTOs.add(listDTO);
            }

        }

        return listDTOs;

    }


}
