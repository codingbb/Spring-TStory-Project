-- 유저 더미
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('cos', '1234', 'cos@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('love', '1234', 'love@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('vivi', '1234', 'vivi@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('cindy', '1234', 'cindy@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('mango', '1234', 'mango@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('kia12', '1234', 'kia12@nate.com', now());
-- 유저 더미 끝

-- 카테고리 더미 (it도 넣기)
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('여행', '1', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('동물', '1', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('동물/여행', '2', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('음식', '2', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('다이어트', '3', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('코딩', '3', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('애니', '3', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('드라마', '3', now());
-- 카테고리 더미 끝

-- 게시글(포스트) 더미
INSERT INTO post_tb (title, content, user_id, category_id, thumbnail_file, created_at)
VALUES ('스위스 13박 14일 여행 후기❤',
        '여러분! 오늘은 제가 지난 여름에 다녀온 스위스 여행에 대한 후기를 들려드리려 합니다.
        저는 13박 14일 동안 스위스 곳곳을 둘러보며 아름다운 자연 경관과 맛있는 음식들을 즐길 수 있었습니다.
        첫 번째로 취리히에서 시작한 여행은 눈부신 알프스 산맥의 풍경에 매료되었습니다.
        호수 위로 반사되는 아름다운 풍경은 마치 그림 속에 들어와 있는 듯한 느낌이었죠.
        또한 베른에서는 중세 시대의 모습이 잘 보존된 아름다운 도시 풍경을 감상할 수 있었습니다.', 1, 1, 'swiss.jpg', DATEADD('DAY', -21, CURRENT_TIMESTAMP)),

       ('여행 팁 - 스위스 여행 준비하기',
        '스위스 여행을 준비하시는 분들을 위해 몇 가지 팁을 알려드리겠습니다.
        첫째, 교통편 예약을 미리 하는 것이 좋습니다. 특히 기차 티켓은 빨리 매진되므로 여유 있게 구매하세요.
        둘째, 숙소는 취리히, 베른, 루체른 등 주요 도시에 위치한 곳으로 선택하는 것이 편리합니다.
        셋째, 스위스 프랑을 준비하세요. 신용카드 사용도 가능하지만 현금 지불이 더 편리합니다.', 1, 1, 'newZealand.jpg', DATEADD('DAY', -15, CURRENT_TIMESTAMP)),

       ('나만의 제주도 여행 코스',
        '제주도에 다녀온 경험을 바탕으로 나만의 여행 코스를 소개해 드릴게요~!
        첫째, 성산일출봉에서 아름다운 일출을 감상하세요. 둘째, 협재 해수욕장에서 맑고 푸른 바다를 즐기세요. 셋째, 한라산 국립공원에서 숲 속 트레킹을 해보세요.
        넷째, 용두암과 주상절리를 둘러보세요. 다섯째, 제주 민속 자연사 박물관에서 제주의 역사와 문화를 배워보세요.
        이 코스를 따라 여행하시면 제주도의 아름다운 자연과 문화를 충분히 경험할 수 있을 것입니다.', 1, 1, 'jeju.jpg', DATEADD('DAY', -13, CURRENT_TIMESTAMP)),

       ('태국 여행 후기😍',
        '태국 여행을 다녀 온 사람이 추천하는 필수 방문 코스!
        첫째, 방콕의 왕궁과 와트 아룬을 방문하세요. 둘째, 아유타야에서 역사와 문화를 경험해 보세요. 셋째, 치앙마이의 불교 사원과 야시장을 둘러보세요.
        넷째, 푸켓의 아름다운 해변과 보트 투어를 즐기세요. 다섯째, 크라비의 피피섬과 홍 섬을 방문하세요.
        이 코스를 따라 여행하시면 태국의 다양한 매력을 만끽할 수 있을 것입니다.', 1, 1, 'thailand.jpg', DATEADD('DAY', -11, CURRENT_TIMESTAMP)),

       ('캐나다 여행 후기',
        '캐나다는 아름다운 자연 풍경과 다양한 문화가 공존하는 매력적인 여행지입니다.
        특히 밴프 국립공원의 에메랄드 빛 호수와 로키 산맥의 웅장한 모습은 정말 인상 깊었습니다.
        또한 토론토의 CN 타워와 나이아가라 폭포는 필수 방문 코스였습니다.
        캐나다의 깨끗한 공기와 친절한 현지인들의 모습도 잊을 수 없는 경험이었습니다.
        다음에 기회가 된다면 다시 방문하고 싶습니다.', 1, 1, 'america.jpg', DATEADD('DAY', -10, CURRENT_TIMESTAMP)),

       ('여름에 일본 빨리 갔다오기 (자유 여행)',
        '오늘은 일본 여행에 대한 포스팅을 해보려고 해요!! 이번 여름에 일본을 갔다왔는데, 덥더라구요~~~
        덥고 습한 날씨 때문에 걱정도 되었지만, 첫 번째로 도쿄에 도착했을 때엔 도쿄 스카이트리 등
        유명 관광지들을 둘러보면서 날씨 걱정이 잊혀졌어요!', 1, 1, 'japan.jpg', DATEADD('DAY', -9, CURRENT_TIMESTAMP)),

       ('일본 여행 필수 경험 - 온천 즐기기',
        '일본 여행의 필수 코스 중 하나는 온천 체험입니다. 일본의 아름다운 자연 풍경과 함께 온천을 즐길 수 있는데요.
        온천에서는 피로를 풀고 스트레스를 해소할 수 있습니다.
        특히 노천 온천은 일본의 전통적인 문화를 느낄 수 있어 좋습니다.
        온천 체험 후에는 근처 료칸에서 편안한 숙박도 가능합니다.', 1, 1, 'japan2.jpg', DATEADD('DAY', -8, CURRENT_TIMESTAMP)),

       ('강아지와의 만남', '산책 나갔을 때 보았던 강아지! 산책로를 걷고 있는데 갑자기 작은 강아지가 저를 향해 다가왔어요.
         강아지의 주인분도 함께 계셨는데, 강아지와 대화를 나누며 재미있는 시간을 보냈습니다.', 1, 2, 'dog2.jpg', DATEADD('DAY', -7, CURRENT_TIMESTAMP)),

       ('강아지와 함께하는 여행',
        '최근 강아지와 함께 여행을 다녀왔습니다.
        강아지가 처음에는 낯선 환경에 적응하지 못했지만, 점차 재미있어 하는 모습이 보였습니다.
        특히 강아지가 바닷가에서 뛰어놀며 신나하는 모습이 정말 귀여웠어요.
        앞으로도 우리 가족은 강아지와 함께 여행을 떠날 계획입니다.', 1, 2, 'dog3.jpg', DATEADD('DAY', -6, CURRENT_TIMESTAMP)),

       ('반려동물과 산책하기',
        '반려동물과 함께 산책하는 것은 반려동물과 유대감을 높이고 운동할 수 있는 좋은 기회입니다.
        산책할 때는 반려동물의 안전을 최우선으로 생각해야 합니다.
        목줄을 착용하고 반려동물이 길을 벗어나지 않도록 주의해야 합니다.
        또한 반려동물이 싫어하는 소음이나 사람, 다른 동물들을 피해 갈 수 있는 장소를 선택하는 것이 좋습니다.', 1, 2, 'dog4.jpg', DATEADD('DAY', -5, CURRENT_TIMESTAMP)),

       ('고양이와 함께하는 하루',
        '반려동물인 고양이와 함께하는 하루는 정말 행복합니다.
        아침에 일어나면 고양이가 침대에 와서 깨워주고, 함께 아침 식사를 합니다.
        식사 후에는 창가에 앉아 새들을 보며 한숨 자는 고양이의 모습이 너무 평화롭습니다.
        저는 그 모습을 보며 고양이가 참 행복해 보인다고 생각합니다.', 1, 2, 'cat2.jpg', DATEADD('DAY', -3, CURRENT_TIMESTAMP)),

       ('반려동물과 함께하는 운동',
        '반려동물과 함께 산책하거나 운동하는 것은 정말 좋습니다.
        강아지와 함께 달리기를 하면 강아지의 활력 넘치는 모습에 저도 에너지가 넘쳐나요.
        또한 고양이와 함께 실내에서 놀이를 하면 둘 다 즐거워하며 건강한 모습을 보입니다.
        반려동물과 함께하는 운동은 우리 모두에게 좋은 영향을 줍니다.', 1, 2, 'dog5.jpg', DATEADD('DAY', -2, CURRENT_TIMESTAMP)),

       ('반려동물과의 추억 만들기',
        '우리 가족은 반려동물과 함께하는 시간을 소중히 여깁니다.
        가족 모두가 모여 반려동물과 함께 사진을 찍고, 영화를 보며 즐거운 시간을 보냅니다.
        특히 반려동물의 생일이나 특별한 날에는 가족이 모여 축제 분위기를 내며 축하하곤 합니다.
        이렇게 반려동물과 함께 만든 추억은 우리 가족에게 큰 행복을 줍니다.', 1, 2, 'cat3.jpg', DATEADD('DAY', -1, CURRENT_TIMESTAMP)),

       ('고양이 집사의 하루 (네로와 함께)', '우리 집 고양이 네로와 함께하는 하루 이야기를 들려드립니다.
         아침 일찍 일어나면 네로가 침대에 와서 깨워줍니다. 그리고 저와 함께 아침 식사를 합니다.
         식사 후에는 네로가 창가에 앉아 새들을 바라보며 한숨 자곤 합니다.
        저는 그 모습을 보며 네로가 참 평화로워 보인다고 생각합니다.', 1, 2, 'cat.jpg', DATEADD('DAY', -1, CURRENT_TIMESTAMP)),
--     여기까지 1번 유저 ssar


       ('요리 레시피 - 마르게리타 피자', '간단하지만 맛있는 마르게리타 피자 만들기! 레시피를 공유합니다~ 아이들 점심 식사나 간식으로 좋아요^^', 2, 4, 'pizza.jpg', DATEADD('DAY', -11, CURRENT_TIMESTAMP)),
       ('맛있는 파스타 만들기', '집에서 직접 만든 맛있는 파스타 레시피를 공유합니다.', 2, 4, 'pasta.jpg', DATEADD('DAY', -8, CURRENT_TIMESTAMP)),
       ('뉴질랜드 가보신분? (저요! 🙋‍♀️)', '뉴질랜드의 아름다운 바다 풍경을 담은 사진입니다 ^^', 2, 3, 'newZealand2.jpg', DATEADD('DAY', -21, CURRENT_TIMESTAMP)),

       ('홈트레이닝 다이어트 루틴', '집에서 운동하는 분들을 위한 효과적인 홈트레이닝 루틴을 소개합니다.', 3, 5, 'exercise.jpg', DATEADD('DAY', -5, CURRENT_TIMESTAMP));


INSERT INTO post_tb (title, content, user_id, category_id, thumbnail_file, created_at)
VALUES ('맛있는 초밥 만들기', '집에서 직접 만든 초밥 사진입니다ㅎㅎ 장인은 아니지만 장인 정신으로!! 신선한 재료와 정성으로 만들었어요~~!', 3, 4, 'sushi.jpg', DATEADD('DAY', -1, CURRENT_TIMESTAMP)),
       ('애니메이션 추천 - 이누야샤', '추억의 애니메이션 이누야샤! 인기 있는 애니메이션 중 하나였죠? 다양하고 매력 넘치는 주인공들의 활약이 인상 깊었어요.', 3, 7, 'anime.jpg', NOW()),
       ('코딩 공부 시작했어요!', '코딩 공부를 처음 시작했는데, 재미있네요. 앞으로 열심히 해서 프로그래밍 실력을 키워나가겠습니다. ^^ 파이팅!', 3, 6, 'coding.jpg', DATEADD('DAY', -3, CURRENT_TIMESTAMP)),
       ('요즘 인기 있는 드라마!! 굿파트너', '최근 방영되고 있는 드라마 중 가장 재미있게 본 작품은 "굿파트너"입니다. 주연 배우가 누구였죠???', 3, 8, 'drama.png', DATEADD('DAY', -5, CURRENT_TIMESTAMP)),
       ('제주도 여행 후기', '제주도에 다녀왔어요. 아름다운 자연 경관과 맛있는 음식들을 즐길 수 있었습니다. 다음에는 해외 여행을 한 번 가보고 싶네요. 어떤가요 ㅎ', 4, 1, 'jeju2.jpg', DATEADD('DAY', -8, CURRENT_TIMESTAMP)),
       ('우리집 뚜비', '우리 집 고양이 뚜비와 함께 보내는 일상이 너무 행복해요 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ 뚜비는 원래 유기묘였는데요, 가족 버릴거면 왜키우지??????? 강아지가 집에 활력을 더해줘요.', 4, 2, 'cat4.jpg', NOW()),
       ('다이어트 성공 후기🎉🎉🎉', '작년부터 꾸준히 운동하고 식단 관리를 해왔는데, 드디어 다이어트에 성공했습니다! 제가 몇 kg을 감량 했을까요? 맞춰보세요 ㅋㅋ', 5, 5, 'diet.jpg', NOW()),
       ('일본 여행 갔다왔어요', '일본 도쿄와 교토를 다녀왔습니다. 전통문화와 현대문화가 공존하는 매력적인 여행지였어요. 무슨 인력거도 탔는데..... 재밌더라구요', 5, 1, 'japan3.jpg', DATEADD('DAY', -2, CURRENT_TIMESTAMP)),
       ('반려동물 돌봄 팁', '반려동물을 키우시는 분들을 위해 반려동물 돌봄 팁을 공유합니다. 1. 돈 없으면 키우지 말 것, 2. 시간 없으면 키우지 말 것', 5, 2, 'pet.jpg', DATEADD('DAY', -5, CURRENT_TIMESTAMP)),
       ('집에서 즐기는 홈파티', '친구들을 초대해서 집에서 간단한 홈파티를 열었어요. 맛있는 음식과 함께 즐거운 시간 보냈습니다.', 6, 4, 'party.jpg', NOW()),
       ('마루를 닮은 우리집 강아지 푸들! 강아!', '학교갔다 돌아오면 왈로아로와오왈!! 하고 짖는 우리집 강아를 소개합니다~~ 한강에 산책이라도 나가면 강아가 신나하며 뛰어다니는 모습이 정말 귀여웠어요.', 6, 2, 'dog6.jpg', DATEADD('DAY', -2, CURRENT_TIMESTAMP)),
       ('코로나19 극복 후기....', '코로나19 감염 후 완치되어 일상으로 돌아왔습니다. 건강의 소중함을 다시 한번 느꼈어요. 다시는 걸리고 싶지 않아요', 6, 6, 'covid.jpg', DATEADD('DAY', -11, CURRENT_TIMESTAMP)),
       ('애니메이션 리뷰 - 다이아몬드A!! (야구 애니)', '다이아몬드 에이스는 야구 선수들의 열정적인 경기 장면이 인상 깊었던 애니메이션입니다.', 7, 7, 'anime2.jpg', DATEADD('DAY', -5, CURRENT_TIMESTAMP)),
       ('최근 인기 있는 드라마', '최근 방영된 드라마 중 "스위트 홈"이 가장 재미있게 봤습니다. 긴장감 넘치는 스토리라인이 인상 깊었어요.', 6, 8, 'drama2.jpg', DATEADD('DAY', -4, CURRENT_TIMESTAMP)),
       ('여행 준비 팁 (다 쓸 수 있음 - 해외 여행 전용)', '여행을 준비하시는 분들을 위해 유용한 여행 준비 팁을 공유합니다.... 1. 돈!! 환전!!', 7, 1, 'travel.jpg', NOW()),
       ('IT 기술 동향 - 5G 네트워크 발전', '최근 5G 네트워크 기술의 발전 동향과 향후 전망에 대해 정리해보았습니다.', 3, 6, '5g_network.jpg', DATEADD('DAY', -2, CURRENT_TIMESTAMP));


INSERT INTO reply_tb (comment, user_id, post_id, created_at)
VALUES ('고양이 귀엽죠...ㅎ', 1, 14, NOW()),
       ('전 강아지 키우는데 ㅋㅋㅋ', 2, 14, NOW()),
       ('고양이에게 너무 좋은 사료를 하나 알고 있는데요. 추천해드려도 될까요? ssar님 어떠신가요??', 6, 14, NOW()),
       ('고양이 키우는 게 어렵지 않나요?', 1, 14, NOW()),
       ('엥ㅋㅋ 고양이 너무 귀엽네요??', 3, 13, NOW()),
       ('고양이 좋아하는데 집에서 키우기 힘들어요;', 5, 13, NOW()),
       ('멍멍이랑 냥이 둘 다 좋아요ㅠㅠㅠㅠㅠ 어케 그렇게 귀엽지...', 4, 13, NOW()),
       ('고양이 키우고 싶은데 집이 좀 작아요... 안되겠죠 역시', 6, 13, NOW()),
       ('이 고양이 이름이 뭔가요?', 4, 11, NOW()),
       ('저도 고양이 키워보고 싶어요', 4, 10, NOW()),
       ('광고사절', 1, 10, NOW()),
       ('고양이 산책은 말도 안 되는 소리입니다~~~^^', 2, 10, NOW()),
       ('강아지랑 고양이 둘 다 좋아요^^', 4, 8, NOW()),
       ('적적하다', 3, 8, NOW()),
       ('동물 좋아하는데... 저는 햄스터가 좋아여 ㅎㅎ', 2, 8, NOW());

INSERT INTO reply_tb (comment, user_id, post_id, created_at)
VALUES ('저도 여행 가고 싶어요! 너무 피곤하니까 힐링 여행~', 2, 1, NOW()),
       ('강아지, 고양이는 어쩌고 스위스 여행을 가셨나요', 3, 1, NOW()),
       ('혼자 맛있는거 드셨네요', 6, 1, NOW()),
       ('가족이랑 여행 가는 건 어떤가요?? 이번에 여행 계획중인데...', 7, 1, NOW()),
       ('저는 제주도 가고 싶어요ㅎㅎ 국내 여행 포스팅도 많이 해주세요!', 4, 1, NOW()),
       ('여행 가면 스트레스 풀리죠. 잘 보고갑니다.', 5, 1, NOW()),
       ('다음에는 어디로 여행 가고 싶으신가요?', 5, 2, NOW()),
       ('광곤가요 ㅡㅡ', 4, 2, NOW()),
       ('여행 가면 스트레스만 더 쌓여서 오던데요 ㅋㅋ 괜찮으신지? 진짜 자주 가시네.. 팁 ㄳ', 3, 2, NOW()),
       ('제주도는 혼자 여행 가는 것도 좋지요~~', 4, 3, NOW()),('흠,, 사진 많이 찍느라 바쁘신듯 ㅋ', 2, 3, NOW()),
       ('오 태국 ㅎ', 6, 4, NOW()),
       ('여행 다녀오면 힐링이 되더라고요ㅎㅎㅎ', 1, 4, NOW()),
       ('맛있는거 드셨네요', 3, 4, NOW()),
       ('여행 갈 때 뭘 먼저 준비하세요?', 2, 4, NOW()),
       ('여행 갈 때 뭘 챙겨가세요? 제가 좋은 상품 알고 있는데요, ssar님처럼 여행 자주 다니시는 분들에게 좋아요', 4, 4, NOW()),
       ('고생하셨어요~~', 1, 5, NOW()),
       ('여름에 가셔서 고생하셨겠어요 ㅋㅋㅋㅋ 일본 여름은 진짜 덥던데', 5, 6, NOW()),
       ('일본여행!!!! 가까워서 좋지여ㅎ 대만은 가보셧나요ㅋ', 6, 6, NOW());

INSERT INTO reply_tb (comment, user_id, post_id, created_at)
VALUES ('좋은 정보 감사합니다!', 3, 33, NOW()),
       ('캐나다 여행 가보고 싶어요!', 4, 5, NOW()),
       ('밴프 국립공원 정말 멋지네요.', 5, 5, NOW()),
       ('온천 가고 싶어요ㅠㅠ', 2, 7, NOW()),
       ('온천에서 피로 푸는거 최고죠.', 6, 7, NOW()),
       ('저도 고양이와 하루를 보내고 싶네요.', 5, 11, NOW()),
       ('반려동물과 운동하기 정말 좋아요. 저도 해봤거든요 ㅎㅎ', 4, 12, NOW()),
       ('홈파티 정말 즐거워 보이네요.', 6, 28, NOW()),
       ('집에서 홈파티 하면 재미있겠어요ㅠㅠ', 3, 28, NOW()),
       ('다이어트 성공 축하드립니다! 근육 증량 15kg 하신거죠? 대단하신...', 2, 25, NOW()),
       ('요즘 심심했는데... 드라마 추천 감사합니다!', 5, 32, NOW()),
       ('이 드라마 정말 재미있더라구요. 넷플릭스에서 하죠?', 7, 32, NOW()),
       ('여행 준비 팁 유용하네요. 언젠가 해외 여행 가서 써먹을 수 있기를~~', 1, 33, NOW()),
       ('좋은 포스팅 감사합니다. 5G 네트워크 발전이 기대됩니다.', 6, 34, NOW()),
       ('바람의 상처~~!! 셋쇼마루!!!', 7, 20, NOW()),
       ('할만하든가요??', 7, 21, NOW()),
       ('파스타 레시피 감사합니다! 백종원 레시피 말고 이걸로 한 번 만들어봐야겠어용 ㅋㅋ', 2, 16, NOW()),
       ('요리 포스팅 좋아요! 따라하고 싶진 않지만 맛있어보이고 좋아요!', 4, 19, NOW()),
       ('뉴질랜드 꼭 가보고 싶어요...... 제 꿈인...', 3, 17, NOW()),
       ('홈트레이닝 루틴 따라해볼게요~~~ 좋은 운동 기구 알려주실 수 있나요? 추천좀...', 5, 18, NOW()),
       ('요리 레시피 공유 감사합니다! 재료 비싼거 쓰시네요 ㅋ 못따라할듯', 6, 19, NOW()),
       ('만드느라 고생하셨겠네요 ~~~ ㅎㅎㅎ 초밥 정말 맛있어 보여요^^', 7, 19, NOW());


INSERT INTO subscribe_tb (from_user_id, to_user_id, created_at)
VALUES (2, 1, NOW()),
       (3, 1, NOW()),
       (6, 1, NOW()),
       (7, 1, NOW()),
       (1, 2, NOW()),
       (1, 4, NOW()),
       (1, 3, NOW());



