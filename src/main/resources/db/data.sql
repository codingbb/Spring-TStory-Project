-- 유저 더미
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('ssar12', 'zheld8282@', 'ssar@nate.com', now());
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
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('dragon', '1234', 'dragon@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('haha', '1234', 'haha@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('soso', '1234', 'soso@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('code5', 'dirn111dnl@', 'codingstory2@gmail.com', now());

-- 댓글 달게 더 만듬 유저 더미
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('juno', '1234', 'juno@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('lucas', '1234', 'lucas@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('elena', '1234', 'elena@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('leo', '1234', 'leo@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('nina', '1234', 'nina@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('peter', '1234', 'peter@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('sara', '1234', 'sara@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('jane', '1234', 'jane@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('troy', '1234', 'troy@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('wynn', '1234', 'wynn@nate.com', now());

-- 유저 더미 끝

-- 카테고리 더미 (it도 넣기)
-- 1~4번까지 1번유저
INSERT INTO category_tb ( category_name, user_id, created_at)
VALUES ('여행', '1', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('동물', '1', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('취미', '1', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('운동', '1', now());

-- 5번까지 2번유저
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('여행', '2', now());

-- 6번~7번까지 3번유저
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('애니', '3', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('드라마', '3', now());

-- 8번~10번까지 4번유저
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('드라마', '4', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('운동', '4', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('코딩', '4', now());

-- 11번까지 5번유저
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ( '음식', '5', now());

-- 12번~13번까지 6번유저
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('취미', '6', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('다이어트', '6', now());

-- 14번~15번까지 7번유저
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('드라마', '7', now());
INSERT INTO category_tb (category_name, user_id, created_at)
VALUES ('여행', '7', now());
-- 카테고리 더미 끝

-- 게시글(포스트) 더미
INSERT INTO post_tb (title, content, user_id, category_id, thumbnail_file, created_at)
VALUES ('스위스 13박 14일 여행 후기❤',
        '여러분! 오늘은 제가 지난 여름에 다녀온 스위스 여행에 대한 후기를 들려드리려 합니다.
        저는 13박 14일 동안 스위스 곳곳을 둘러보며 아름다운 자연 경관과 맛있는 음식들을 즐길 수 있었습니다.
        첫 번째로 취리히에서 시작한 여행은 눈부신 알프스 산맥의 풍경에 매료되었습니다.
        호수 위로 반사되는 아름다운 풍경은 마치 그림 속에 들어와 있는 듯한 느낌이었죠.
        또한 베른에서는 중세 시대의 모습이 잘 보존된 아름다운 도시 풍경을 감상할 수 있었습니다.', 1, 1, 'swiss.jpg', DATEADD('DAY', -100, CURRENT_TIMESTAMP)),

       ('나만의 제주도 여행 코스',
        '제주도에 다녀온 경험을 바탕으로 나만의 여행 코스를 소개해 드릴게요~!
        첫째, 성산일출봉에서 아름다운 일출을 감상하세요. 둘째, 협재 해수욕장에서 맑고 푸른 바다를 즐기세요. 셋째, 한라산 국립공원에서 숲 속 트레킹을 해보세요.
        넷째, 용두암과 주상절리를 둘러보세요. 다섯째, 제주 민속 자연사 박물관에서 제주의 역사와 문화를 배워보세요.
        이 코스를 따라 여행하시면 제주도의 아름다운 자연과 문화를 충분히 경험할 수 있을 것입니다.', 1, 1, 'jeju.jpg', DATEADD('DAY', -95, CURRENT_TIMESTAMP)),

       ('태국 여행 후기😍',
        '태국 여행을 다녀 온 사람이 추천하는 필수 방문 코스!
        첫째, 방콕의 왕궁과 와트 아룬을 방문하세요. 둘째, 아유타야에서 역사와 문화를 경험해 보세요. 셋째, 치앙마이의 불교 사원과 야시장을 둘러보세요.
        넷째, 푸켓의 아름다운 해변과 보트 투어를 즐기세요. 다섯째, 크라비의 피피섬과 홍 섬을 방문하세요.
        이 코스를 따라 여행하시면 태국의 다양한 매력을 만끽할 수 있을 것입니다.', 1, 1, 'thailand.jpg', DATEADD('DAY', -88, CURRENT_TIMESTAMP)),

       ('캐나다 여행 후기',
        '캐나다는 아름다운 자연 풍경과 다양한 문화가 공존하는 매력적인 여행지입니다.
        특히 밴프 국립공원의 에메랄드 빛 호수와 로키 산맥의 웅장한 모습은 정말 인상 깊었습니다.
        또한 토론토의 CN 타워와 나이아가라 폭포는 필수 방문 코스였습니다.
        캐나다의 깨끗한 공기와 친절한 현지인들의 모습도 잊을 수 없는 경험이었습니다.
        다음에 기회가 된다면 다시 방문하고 싶습니다.', 1, 1, 'america.jpg', DATEADD('DAY', -77, CURRENT_TIMESTAMP)),

       ('강아지와 함께하는 여행',
        '최근 강아지와 함께 여행을 다녀왔습니다.
        강아지가 처음에는 낯선 환경에 적응하지 못했지만, 점차 재미있어 하는 모습이 보였습니다.
        특히 강아지가 바닷가에서 뛰어놀며 신나하는 모습이 정말 귀여웠어요.
        앞으로도 우리 가족은 강아지와 함께 여행을 떠날 계획입니다.', 1, 2, 'dog3.jpg', DATEADD('DAY', -73, CURRENT_TIMESTAMP)),

       ('반려동물과 산책하기',
        '반려동물과 함께 산책하는 것은 반려동물과 유대감을 높이고 운동할 수 있는 좋은 기회입니다.
        산책할 때는 반려동물의 안전을 최우선으로 생각해야 합니다.
        목줄을 착용하고 반려동물이 길을 벗어나지 않도록 주의해야 합니다.
        또한 반려동물이 싫어하는 소음이나 사람, 다른 동물들을 피해 갈 수 있는 장소를 선택하는 것이 좋습니다.', 1, 2, 'dog4.jpg', DATEADD('DAY', -68, CURRENT_TIMESTAMP)),

       ('주말 황령산 등산 후기',
        '최근 황령산에 다녀왔습니다. 오랜만에 갔는데 너무 좋았어요! 등산 초보자도 쉽게 올라갈 수 있어요. 초보자에게 완전 추천해요!', 1, 3, 'mountain.jpg', DATEADD('DAY', -64, CURRENT_TIMESTAMP)),

       ('자기 체중 운동으로 홈트 1일째',
        '스쿼트 100회 오운완!', 1, 4, 'exercise.jpg', DATEADD('DAY', -62, CURRENT_TIMESTAMP)),

       ('자기 체중 운동으로 홈트 2일째',
        '스쿼트 100회 오운완!', 1, 4, 'exercise2.jpg', DATEADD('DAY', -61, CURRENT_TIMESTAMP)),

--     여기까지 1번 유저 ssar

       ('전라도 맛집 여행: 광주 편',
        '광주로 떠난 맛집 여행! 광주는 다양한 맛집이 많기로 유명한데요, 그 중에서도 꼭 가봐야 할 곳을 소개합니다. 첫 번째는 담백한 맛이 일품인 양동시장의 양동국밥집. 두 번째는 신선한 회를 즐길 수 있는 1913송정역시장 회센터. 마지막으로는 달콤한 디저트가 가득한 펠트커피.',
        2, 5, 'gwangju_food.jpg', DATEADD('DAY', -60, CURRENT_TIMESTAMP)),

       ('전라도 맛집 여행: 전주 편',
        '전주는 한옥마을과 함께 맛있는 음식들로 유명하죠. 이번에는 전주의 대표적인 맛집들을 다녀왔습니다. 첫 번째는 전주비빔밥의 원조 집으로 유명한 전주중앙회관. 두 번째는 전주 콩나물국밥의 명가 삼백집. 마지막으로는 달콤한 전주초코파이를 맛볼 수 있는 초코파이 카페. 전주의 매력을 가득 담은 맛집들을 소개합니다.',
        2, 5, 'jeonju_food.jpg', DATEADD('DAY', -58, CURRENT_TIMESTAMP)),

       ('전라도 맛집 여행: 여수 편',
        '여수는 아름다운 바다와 함께 해산물 요리가 일품인 곳입니다. 이번 여수 여행에서는 꼭 가봐야 할 맛집들을 다녀왔습니다. 첫 번째는 신선한 해산물이 가득한 여수수산시장. 두 번째는 여수 밤바다를 보며 즐길 수 있는 여수꼬치집. 마지막으로는 여수의 특산물인 돌산갓김치가 맛있는 갓김치찌개 전문점. 여수에서의 맛집 여행기를 전합니다.',
        2, 5, 'yeosu_food.jpg', DATEADD('DAY', -57, CURRENT_TIMESTAMP)),

-- --     여기까지 2번 유저 cos

       ('"스파이 패밀리" 리뷰',
        '오늘은 2023년 최고 기대작 중 하나인 "스파이 패밀리"를 리뷰해보겠습니다. 이 애니메이션은 인기 만화 원작으로, 가족의 일상을 배경으로 한 스릴 넘치는 스파이 스토리입니다. 주인공 로이드 포저는 스파이로서 임무를 수행하며 가족을 이루게 되는데, 그의 아내와 딸도 각기 다른 비밀을 가지고 있어요. 가족이 서로를 이해하고 사랑하는 과정에서 벌어지는 재미있고 감동적인 이야기를 다루고 있습니다. 특히 애니메이션의 퀄리티와 캐릭터 디자인, 액션 신 등이 돋보여 많은 팬들의 사랑을 받고 있습니다. 이 작품을 놓치지 마세요!',
        3, 6, 'spy.jpg', DATEADD('DAY', -56, CURRENT_TIMESTAMP)),

       ('"오타쿠의 사랑" 리뷰',
        '이번에는 감동과 웃음이 가득한 애니메이션 "오타쿠의 사랑"을 소개합니다. 이 애니메이션은 오타쿠인 주인공과 그의 친구들이 겪는 일상 속에서 벌어지는 다양한 사건들을 그린 작품입니다. 주인공은 게임과 애니메이션을 좋아하는 전형적인 오타쿠로, 학교 생활과 친구들과의 관계에서 벌어지는 에피소드들이 매우 유쾌하고 공감대를 형성합니다. 특히 주인공이 자신과 다른 취향을 가진 친구들과 이해하고 소통하는 과정에서 성장해가는 모습이 인상적입니다. 감동적인 장면과 웃음을 동시에 느낄 수 있는 이 작품을 강력 추천합니다.',
        3, 6, 'olove.jpg', DATEADD('DAY', -54, CURRENT_TIMESTAMP)),

       ('요즘 인기 있는 드라마!! "굿파트너"',
        '이혼이 천직인 스타변호사 차은경과 이혼은 처음인 신입변호사 한유리의 차갑고 뜨거운 휴먼 법정 오피스 드라마입니다. 매주 금요일과 토요일 밤 10시에 방영되는 "굿파트너"를 놓치지 마세요!',
        3, 7, 'drama.png', DATEADD('DAY', -52, CURRENT_TIMESTAMP)),

--     여기까지 3번 유저 love

       ('오피스 드라마 "감사합니다"',
        '''감사의 신'' ''신하균''의 열연은 단순히 냉정하게만 보여질 수 있는 신차일을 입체적으로 그려내면서 더욱 많은 호응을 얻고 있는데요, 예측불허의 전개와 짜릿한 반전을 선사하는 재밌는 드라마인 것 같습니다.', 4, 8, 'thank.jpg', DATEADD('DAY', -51, CURRENT_TIMESTAMP)),

       ('헬스장 첫날: 입문자의 생존기',
        '안녕하세요, 오늘은 헬스장 첫날의 경험을 공유해볼까 합니다.
처음 헬스장에 들어서자마자 느낀 것은 압도적인 기구의 수와 많은 사람들의 에너지였습니다. 등록을 마치고 트레이너의 안내를 받아 가볍게 스트레칭을 시작했습니다. 초보자인 저는 기본적인 동작부터 배우는 것에 집중했습니다.
오늘의 루틴은 간단한 유산소 운동과 기초 근력 운동이었는데, 러닝머신에서 10분 걷기, 스쿼트 3세트, 플랭크 2세트로 구성되었습니다. 첫날이라 그런지 근육이 금방 피로해졌지만, 운동 후의 상쾌한 느낌은 정말 좋았습니다.
꾸준히 하다 보면 좋은 결과를 얻을 수 있겠죠?', 4, 9, 'gym.jpg', DATEADD('DAY', -50, CURRENT_TIMESTAMP)),

       ('몸의 변화를 느끼다',
        '헬스장에 다닌 지 벌써 한 달이 되었습니다. 그동안의 경험과 변화를 공유해보겠습니다.
처음에는 운동 후에 항상 근육통에 시달렸지만, 이제는 몸이 많이 적응해서 운동 후에도 비교적 상쾌한 느낌을 유지할 수 있습니다. 특히 상체와 하체의 근력이 전반적으로 향상되었음을 느낍니다. 트레이너의 지도 아래 체계적으로 운동하다 보니 자세도 많이 교정되었습니다.
가장 큰 변화는 체지방이 줄고 근육량이 늘어난 것입니다. 체중은 크게 변하지 않았지만, 몸매가 좀 더 탄탄해졌습니다. 이 변화는 매우 만족스럽고, 운동에 대한 동기부여가 되었습니다.
헬스장을 다니려는 분들께는 꾸준함과 인내심이 가장 중요하다고 말씀드리고 싶습니다. 첫 달을 잘 넘기면 그 이후부터는 운동이 더욱 즐거워질 것입니다!', 4, 9, 'gym.jpg', DATEADD('DAY', -27, CURRENT_TIMESTAMP)),

       ('헬스장에서의 체력 향상 비법',
        '안녕하세요, 오늘은 헬스장에서 체력을 향상시키기 위한 몇 가지 팁을 공유해보려고 합니다.
첫 번째로 중요한 것은 일관성입니다. 운동을 꾸준히 하는 것이 체력 향상의 핵심입니다. 매일 조금씩이라도 꾸준히 운동하는 것이 중요합니다.
두 번째는 다양한 운동을 시도해보는 것입니다. 헬스장에는 다양한 기구와 운동 방법이 있으므로, 이를 활용해 여러 부위를 골고루 운동하면 전신 체력 향상에 도움이 됩니다. 예를 들어, 러닝머신에서 유산소 운동을 한 후, 웨이트 트레이닝으로 근력 운동을 해보세요.
세 번째는 충분한 휴식과 영양 섭취입니다. 운동 후에는 충분한 휴식을 취하고, 단백질이 풍부한 식사를 통해 근육 회복을 돕는 것이 좋습니다. 또한, 물을 많이 마셔서 체내 수분을 유지하는 것도 중요합니다.
이 팁들을 참고하셔서 헬스장에서의 체력 향상에 도움이 되길 바랍니다. 모두 파이팅!', 4, 9, 'gym.jpg', DATEADD('DAY', -25, CURRENT_TIMESTAMP)),

       ('코드 리팩토링: 잘못된 코드 수정하기',
        '코드 리팩토링은 기존의 코드를 개선하여 유지보수성을 높이는 작업입니다. 예를 들어, 중복된 코드를 함수로 분리하거나 복잡한 로직을 단순화하는 것이 리팩토링입니다. 이를 통해 코드의 가독성을 높이고, 버그 발생 가능성을 줄일 수 있습니다. 리팩토링 시에는 기존 코드가 잘 작동하는지 테스트를 통해 확인하는 것이 중요합니다.', 4, 10, 'refactoring.png', DATEADD('DAY', -24, CURRENT_TIMESTAMP)),

       ('효율적인 디버깅을 위한 팁',
        '디버깅은 개발 과정에서 버그를 찾고 수정하는 과정입니다. 효율적인 디버깅을 위해 다음과 같은 팁을 기억하세요: 1) **문제를 재현**: 버그를 재현하여 원인을 정확히 파악합니다. 2) **로깅 활용**: 로그를 통해 코드의 실행 흐름을 추적합니다. 3) **단계별 디버깅**: 문제를 좁히기 위해 코드를 단계별로 디버깅합니다. 이러한 방법을 통해 디버깅을 보다 효과적으로 진행할 수 있습니다.', 4, 10, 'debugging.jpg', DATEADD('DAY', -23, CURRENT_TIMESTAMP));

--     여기까지 4번 유저 vivi

INSERT INTO post_tb (title, content, user_id, category_id, thumbnail_file, created_at)
VALUES ('탄수화물과의 전쟁',
        '우리는 왜 그토록 탄수화물을 싫어하는 가.
        요즘 탄수화물에 대해 안 좋게 말하는 의견들이 너무나 많습니다. 하지만 탄수화물이 정말로 우리 몸에 안 좋을까요?
        꼭 그렇지는 않다고 생각합니다. 적정량의 탄수화물은 우리 몸의 대사에 꼭 필요한 부분입니다.
        하지만 되도록, 건강한 탄수화물을 섭취하는 것이 중요하겠죠! 하지만 무분별한 탄수화물 중독이나 한 쪽으로 치우친 식단은 좋지 못합니다.', 5, 11, '탄수화물.jpg', DATEADD('DAY', -21, CURRENT_TIMESTAMP)),

       ('배달음식 슬기롭게 먹기',
        '혼자 사는 데 배달음식의 양은 너무 애매하게 남는 경우가 많습니다. 그럴 때에 슬기롭게 배달음식을 먹는 방법을 알려드리겠습니다.
        첫째, 최대한 음식을 소분하여 분리하여 주세요. 먹고 남은 것은 할 수 없지만, 처음부터 양이 많다면 미리 소분하여 주세요.
        둘째, 최대한 중간 조리과정은 줄여주시고 즉, 재밀봉은 안됩니다.
        셋째, 달걀, 한국인의 기초 양념, 고추장, 간장, 파, 마늘만 있다면 함께 볶아먹거나 구워먹으면 색다른 맛을 느낄 수 있어요.(국물요리는 찌개형식으로 해드셔도 좋습니다!)', 5, 11, '배달음식.jpg', DATEADD('DAY', -15, CURRENT_TIMESTAMP)),

--     --여기까지 5번 유저

       ('나의 새로운 취미, 모루 만들기',
        '원데이 클래스에 다녀온 경험을 바탕으로 나만의 모루인형만들기를 소개해 드릴게요~!
        첫째, 집과 가장 근처인 원데이 클래스를 등록합니다. 둘째, 재료들이 잘 왔는지 체크해봅니다. 취향껏 고르시면 됩니다. 셋째, 모루를 뭉쳐서 이렇게 만들면 됩니다.
        넷째, 짜잔, 아주 귀엽죠 다섯째, 가방, 파우치, 장식 등 다양한 곳에 활용해 보세요.
        간편하지만 너무나도 귀여운 인형을 나만의 색깔로 만들 수 있습니다.', 6, 12, '모루인형.jpg', DATEADD('DAY', -13, CURRENT_TIMESTAMP)),

       ('오늘부터 다이어터',
        '다이어트를 결심한 사람들이 꼭 가는 곳! 샐러드 바 저두 가봤는데요!
        집 근처에 새롭게 open한 샐러드 바가 있더라구요. 그 곳에는 싱싱하고 푸릇한 다양한 채소들이 기본값만 지불하면 무한으로 제공이 되드라구요.
        물론 채소들이라 먹는 것에 제한이 없어도 계속 먹지는 못하겠더라구요. 그리고 여기서의 특별한 포케!! 너무 맛나요!!! 여러분들도 한 번 도전해보세요
        샐러드의 다양한 매력을 만끽할 수 있을 것입니다.', 6, 13, '샐러드.jpg', DATEADD('DAY', -11, CURRENT_TIMESTAMP)),

--     --여기까지 6번 유저

       ('신라의 아름다움과 역사를 알 수 있는 드라마',
        '최근 선덕여왕 드라마를 알게되었는데요. 이 드라마 각색부터 대본 한 줄 한 줄 정말 감명 깊습니다.
        화랑에 대해 디테일하게 표현하고 구현한 것도 너무 멋있더라구요. 신라판 꽃미남들도 많이 등장합니다.
        짧은 드라마는 아니지만, 회차가 무색하게 금방 지나가는 것을 느낄 수 있을 거에요.
        혹시 신라에 대해서 혹은 이 시대의 상을 실감나게 간접경험을 해보고 싶으신 분들 바로 검색해보세요!', 7, 14, '선덕여왕.jpg', DATEADD('DAY', -10, CURRENT_TIMESTAMP)),

       ('소설의 드라마화!!!',
        '오늘은 빨간머리 앤에 대해서 소개시켜드릴게요!. 원래 소설에 대해서 잘 알지 못했지만, 이 드라마를 보고 책을 다시 찾아보게 되었어요.
        정말 대사 하나하나 감동 그 자체입니다. 소녀의 감정을 한 줄 한 줄 섬세하게 연출하고 그려낸 것이. .요거 진짜 대박입니다...
        성장 드라마로써 각 인물들의 이야기와 감정표현이 정말 잘 되어 있어요. 시즌 2가 나오기를 간절히 바래봅니다.', 7, 14, '빨간머리앤.jpg', DATEADD('DAY', -9, CURRENT_TIMESTAMP)),

       ('이집트, 무작정 떠나보자',
        '이집트... 옛날부터 고대의 거대함과 웅장함이 있었습니다. 그런데 20대 후반의 어느날... 그냥 떠나고 싶더라구요.
        그래서 그 길로 이집트 비행기 티켓을 그냥 구매했습니다. 그리고 재정이 넉넉하지 않았을 때지만, 젊은 패기라도 있었던 것인지... 아니면 어떻게든 될 것이라 생각되어
        그냥 떠났습니다. 처음 무서움과 막막함에 눈물도 보이게 되었지만 점차 돈이 없으면 없는대로, 자연이 주는 아름다움에 대해 알게되고
        그 곳에서 친구들과 사람들을 만나며, 하루하루를 알차게 살다보니 제가 여행을 하고 있더라구요?! 지금 생각하면 무슨 생각이었지라는 생각도 들지만 그때의 경험이 너무나도 큰 자산이 되었답니다', 7, 15, '이집트여행.jpg', DATEADD('DAY', -8, CURRENT_TIMESTAMP)),

       ('여수 밤바다',
        '어느샌가.. 밤이 되면 여수 밤바다가 떠오르더라구요. 하지만 저는 여수에 가보지 않았습니다. 그래서 친구들에게 바로 전화해서 그날로 날짜 정했어요!!!!
        저는 파워 j인 사람으로써, 계획을 철저히 정하지 않으면 불안하더라구요! 그래서 자유 여행이지만, 우리가 이용할 수 있는 교통편, 음식, 휴식시간 등을 미리 정하구 갔습니다.
        그렇게 안전하지만 돌발적으로 여행지를 떠났는데요. 그때 먹은 음식들이 ...진짜..... 대박.... 그리고 일상에서는 항상 다른 스케쥴에 끌려다녔는데 이번에는 저 스스로 선택하고 조절하고 주도해서 여행코스들을 따라다니니까 너무 기분이 좋더라구요.!'
           , 7, 15, '여수밤바다.jpg', DATEADD('DAY', -7, CURRENT_TIMESTAMP)),

       -- 다시 1번 유저 글
       ('자기 체중 운동으로 홈트 3일째',
        '스쿼트 100회 오운완!', 1, 4, 'exercise.jpg', DATEADD('DAY', -60, CURRENT_TIMESTAMP)),

       ('자기 체중 운동으로 홈트 4일째',
        '스쿼트 100회 오운완!', 1, 5, 'exercise.jpg', DATEADD('DAY', -59, CURRENT_TIMESTAMP)),

       ('자기 체중 운동으로 홈트 5일째',
        '스쿼트 100회 오운완!', 1, 6, 'exercise.jpg', DATEADD('DAY', -58, CURRENT_TIMESTAMP)),

       ('냥줍 했어요',
        '저 집사 됐어요!! 조만간 사진 올릴게요 ㅎㅎ', 1, 2, 'dog3.jpg', DATEADD('DAY', -50, CURRENT_TIMESTAMP)),

       ('무계획 제주살이 1일차..',
        '요즘 진로에 대해 자신도 없고 답답해져서 무작정 제주도 여행을 왔습니다. 저 잘할 수 있겠죠??', 1, 1, 'jeju.jpg', DATEADD('DAY', -30, CURRENT_TIMESTAMP)),

       ('무계획 제주살이 2일차..',
        '오늘은 정처없이 무작정 걸었어여 ㅎㅎ', 1, 1, 'jeju.jpg', DATEADD('DAY', -29, CURRENT_TIMESTAMP)),

--        ('하루가 또 지나가네요',
--         '천둥번개가 치는 날... 적적하네요.', 11, 1, 'jeju.jpg', NOW()),

       ('무계획 제주살이 3일차',
        '제주도에 온 지 벌써 3일째. 이곳에서의 삶이 점점 더 흥미로워지고 있습니다. 최근 블로그 업데이트가 적어질 것 같다는 예고를 드리면서, 그 이유를 조금 더 자세히 설명드리려고 해요.

사실, 처음 제주도로 온 이유는 일상의 번잡함에서 벗어나, 조금 더 자유롭고 여유로운 삶을 경험해보고 싶어서였습니다. 처음에는 인터넷과 연결된 생활을 계속할 계획이었지만, 이곳에서의 삶이 주는 매력에 점점 빠져들면서 ''디지털 디톡스''를 시도해보고 싶어졌어요.

제주도는 정말로 특별한 곳입니다. 자연이 주는 평온함과 바람 소리, 그리고 때로는 비 오는 날의 조용함이 주는 힐링이 상상 이상이에요. 여기에 인터넷 없는 삶을 경험하면서, 일상에 치여 놓치고 있었던 소중한 것들 자연과의 교감, 자신의 내면을 돌아볼 시간을 되찾을 수 있을 것 같아요.

물론, 블로그를 통해 소통하는 것도 좋지만, 이제는 잠시 그걸 내려놓고 나 자신과 대면하는 시간을 가지려고 해요. 이곳에서의 하루하루를 직접 경험하면서, 다양한 감정과 생각을 느끼고 그에 따라 변해가는 제 자신을 발견할 수 있기를 기대하고 있습니다.

그래서 당분간 블로그 업로드는 줄어들 것 같아요. 인터넷 없이 지내보는 경험이 제게 어떤 변화를 가져다 줄지 궁금하고, 그 과정에서 느낀 것들을 나중에 돌아보고 싶어요. 지금은 그냥 제주도의 자연과 함께하는 이 순간을 즐기려 합니다.

다시 블로그를 통해 인사드릴 때까지, 여러분도 각자의 일상 속에서 잠시 여유를 가지시길 바랄게요. 그럼 제주도에서의 새로운 소식과 경험은 다음 기회에 공유하도록 하겠습니다!

', 1, 1, 'jeju.jpg', DATEADD('DAY', -28, CURRENT_TIMESTAMP));


--여기까지 7번 유저--

-- 댓글
-- 1번 게시글 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (1, 3, NOW(), '스위스 여행을 이렇게 자세히 들려주셔서 감사합니다! 스위스는 제가 가고 싶은 여행지 중 하나인데, 실제로 어떤 경험을 하셨는지 궁금했어요. 알프스에서의 하이킹 경험도 나중에 공유해주시면 좋겠어요!'),
    (1, 4, NOW(), '스위스 여행 후기가 너무 좋습니다. 특히 알프스 산맥의 풍경이 정말 상상 이상일 것 같아요. 여행 중 가장 기억에 남는 순간이 무엇인지도 궁금해요. 다음 여행에도 좋은 정보 부탁드립니다!');

-- 2번 게시글 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (2, 5, NOW(), '제주도 여행 코스 너무 멋지네요! 성산일출봉에서의 일출은 꼭 경험해보고 싶었는데, 자세한 설명 덕분에 가고 싶어지는 곳이네요. 협재 해수욕장에서 바다를 즐기는 것도 정말 좋을 것 같아요. 나중에 더 많은 제주도 여행 팁도 공유해주시면 좋겠어요!');

-- 3번 게시글 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (3, 7, NOW(), '태국 여행 코스 추천 감사합니다! 방콕의 왕궁과 아유타야는 꼭 가보고 싶던 곳이라 더 관심이 가네요. 치앙마이의 야시장도 재미있을 것 같아요. 추천해주신 코스대로 여행 계획을 세워봐야겠어요!'),
    (3, 8, NOW(), '태국 여행 후기 정말 유용하네요! 푸켓의 해변과 보트 투어가 특히 매력적일 것 같아요. 다음 휴가에 태국을 고려해봐야겠어요. 좋은 정보 감사합니다!');

-- 4번 게시글 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (4, 9, NOW(), '캐나다 여행 정말 멋질 것 같네요! 밴프 국립공원의 호수는 사진으로도 너무 아름다웠는데, 직접 가서 보면 더 감동적일 것 같아요. 나이아가라 폭포도 꼭 가보고 싶어요.'),
    (4, 10, NOW(), '캐나다의 자연과 문화에 대한 후기 감사합니다. 다음 여행지로 캐나다를 고려해야겠어요. CN 타워와 나이아가라 폭포 방문은 필수 코스인 것 같네요.');

-- 5번 게시글 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (5, 2, NOW(), '강아지와의 여행은 정말 행복할 것 같아요! 바닷가에서 신나게 뛰어노는 강아지 모습이 상상이 가네요. 앞으로도 즐거운 여행 많이 다니세요!'),
    (5, 10, NOW(), '강아지와 함께 여행이라니 너무 귀여워요. 저도 강아지와 여행 계획을 세우고 싶어지네요. 강아지가 즐거워하는 모습을 보는 게 가장 행복한 것 같아요.');

-- 6번 게시글 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (6, 3, NOW(), '반려동물과 산책하는 건 정말 좋은 활동이죠! 안전하게 산책할 수 있는 장소를 찾는 것도 중요하죠. 좋은 팁 감사합니다!'),
    (6, 4, NOW(), '산책할 때 주의사항에 대해 잘 설명해주셨네요. 특히 목줄과 안전이 중요하다는 점을 다시 한 번 생각하게 되었어요. 감사합니다!');

-- 7번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (7, 2, NOW(), '황령산 등산 후기 잘 봤어요! 초보자도 쉽게 올라갈 수 있다니 좋네요. 주말에 도전해봐야겠어요. 감사합니다!'),
    (7, 3, NOW(), '황령산 등산 정보 감사합니다. 초보자도 올라갈 수 있다니 용기 내서 도전해볼게요!');

-- 8번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (8, 4, NOW(), '자기 체중 운동으로 홈트 1일째라니 대단해요! 스쿼트 100회 성공적으로 하셨다니 멋집니다. 계속해서 힘내세요!'),
    (8, 5, NOW(), '홈트의 시작을 이렇게 열심히 하시다니 멋지네요! 스쿼트 100회는 정말 힘들 텐데, 계속해서 응원할게요!');

-- 9번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (9, 6, NOW(), '홈트 2일째라니, 스쿼트 100회 계속해서 하시다니 대단해요! 꾸준함이 중요하니까 힘내세요!'),
    (9, 7, NOW(), '자기 체중 운동 계속 진행 중이시군요. 스쿼트 100회는 정말 힘든 목표인데, 잘 해내셨네요!');

-- 10번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (10, 8, NOW(), '광주의 맛집 정보 감사합니다! 양동국밥집과 송정역시장의 회가 특히 궁금하네요. 맛있는 음식들 많이 소개해주셔서 감사합니다!'),
    (10, 9, NOW(), '광주 맛집 탐방 정보 유용해요. 양동시장의 국밥과 송정역시장의 회는 꼭 가봐야겠어요. 좋은 추천 감사해요!');

-- 11번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (11, 10, NOW(), '전주 맛집들 소개해주셔서 감사합니다! 전주비빔밥과 콩나물국밥은 꼭 먹어봐야겠어요. 초코파이 카페도 궁금하네요!'),
    (11, 1, NOW(), '전주 맛집 정보 감사합니다. 전주중앙회관과 삼백집은 이미 가본 곳이라 다른 맛집들도 다녀와야겠어요. 초코파이 카페도 좋을 것 같아요!');

-- 12번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (12, 3, NOW(), '여수의 맛집들 정말 좋아 보여요! 여수수산시장에서 신선한 해산물을 먹어보고 싶네요. 좋은 정보 감사합니다!'),
    (12, 5, NOW(), '여수 여행 정보 감사합니다! 여수꼬치집과 돌산갓김치 맛이 궁금해요. 꼭 가봐야겠어요!');

-- 13번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (13, 6, NOW(), '스파이 패밀리 리뷰 감사합니다! 애니메이션을 정말 재밌게 봤던 기억이 나네요. 주인공의 스토리가 너무 흥미로워요.');

-- 14번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (14, 7, NOW(), '오타쿠의 사랑 리뷰 감사합니다! 전형적인 오타쿠의 일상 이야기라니 공감이 많이 되네요. 감동적이고 유쾌한 작품인 것 같습니다.'),
    (14, 9, NOW(), '오타쿠의 사랑 재미있게 보셨군요! 주인공의 성장 과정이 흥미롭죠. 리뷰 읽어보니 저도 꼭 보고 싶어지네요.');

-- 15번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (15, 10, NOW(), '굿파트너 드라마 기대되네요! 법정 드라마는 항상 재미있어서 이번에도 기대할게요. 좋은 추천 감사합니다!');

-- 16번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (16, 1, NOW(), '감사합니다 드라마 추천해주셔서 감사해요. 신하균 배우의 열연이 기대되네요. 전개가 어떻게 될지 궁금해요.');

-- 17번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (17, 4, NOW(), '헬스장 첫날의 경험 잘 봤습니다! 초보자로서의 자세한 설명이 많은 도움이 되네요. 꾸준히 하시면 좋은 결과 있을 거예요!');

-- 18번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (18, 8, NOW(), '헬스장에서의 변화가 정말 멋지네요! 체력 향상과 몸매 변화가 있으니 동기부여가 되죠. 앞으로도 힘내세요!'),
    (18, 10, NOW(), '헬스장에서의 변화가 놀랍네요! 꾸준히 운동하시면서 좋은 결과 얻으시길 바랍니다. 응원합니다!');

-- 19번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (19, 2, NOW(), '체력 향상 팁 좋네요! 일관성과 다양한 운동이 중요하다는 거 공감합니다. 감사합니다!');

-- 20번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (20, 5, NOW(), '코드 리팩토링에 대한 설명 잘 봤습니다. 중복된 코드를 함수로 분리하는 것이 중요하죠. 감사합니다!');

-- 21번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (21, 8, NOW(), '디버깅 팁 유용하네요! 문제를 재현하고 로그를 활용하는 것이 정말 중요하죠. 감사합니다.');

-- 22번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (22, 6, NOW(), '탄수화물에 대한 고민이 많았는데, 균형 잡힌 식단이 중요하다는 점을 새삼 느끼게 되네요. 유용한 정보 감사합니다!'),
    (22, 7, NOW(), '탄수화물 적정량 섭취가 중요하다는 말씀에 동감합니다. 건강한 식단을 유지해야겠어요.');

-- 23번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (23, 9, NOW(), '배달음식을 슬기롭게 먹는 팁 좋네요! 음식 소분하는 방법이 특히 유용할 것 같습니다. 감사합니다.');

-- 24번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (24, 10, NOW(), '모루 인형 만들기 재미있어 보이네요! 원데이 클래스에서 배운 방법으로 저도 도전해봐야겠어요. 좋은 정보 감사합니다.');

-- 25번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (25, 5, NOW(), '샐러드 바는 정말 좋은 선택이에요! 다양한 채소를 무한으로 제공받을 수 있다니 좋네요. 포케도 맛있겠어요.');

-- 26번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (26, 1, NOW(), '선덕여왕 드라마, 신라 시대의 디테일한 표현이 감동적이군요. 정말 재미있을 것 같아요. 추천 감사합니다!'),
    (26, 4, NOW(), '드라마 선덕여왕을 꼭 보고 싶어지네요. 신라의 역사와 문화를 잘 표현한 것 같아서 기대됩니다.');

-- 27번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (27, 2, NOW(), '빨간머리 앤 드라마, 감동적이었죠! 원작 소설도 읽어보고 싶어요. 정말 훌륭한 작품입니다.');

-- 28번 게시글에 대한 댓글
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (28, 3, NOW(), '이집트 여행기 읽으니 정말 흥미롭네요. 여행이 삶에 큰 자산이 되는 걸 느낄 수 있겠어요. 멋진 경험입니다.');

-- 댓글 페이징 보여주려고 여러개 만든거
INSERT INTO reply_tb (post_id, user_id, created_at, comment)
VALUES
    (36, 2, NOW(), '제주도에서의 디지털 디톡스 경험이 흥미롭네요! 자연 속에서의 힐링과 자아 성찰이 멋질 것 같아요. 좋은 시간 보내세요!'),
    (36, 3, NOW(), '자연과의 교감, 정말 좋은 선택이네요. 제주도의 아름다움을 만끽하시길 바랍니다!'),
    (36, 4, NOW(), '디지털 디톡스, 저도 해보고 싶은데요! 제주도에서의 여유로운 시간 잘 보내세요.'),
    (36, 5, NOW(), '블로그 업데이트는 적어도, 제주도에서의 멋진 순간을 충분히 만끽하시길 바랍니다. 응원합니다!'),
    (36, 6, NOW(), '제주도의 평온함을 잘 느끼시고, 그 과정에서 많은 것을 배우시길 바랍니다. 멋진 여행 되세요!'),
    (36, 7, NOW(), '디지털 디톡스 정말 멋진 시도인 것 같아요. 제주도에서의 여유로운 시간 잘 즐기세요!'),
    (36, 8, NOW(), '자연 속에서의 힐링이 기대됩니다. 블로그 업데이트는 잠시 내려놓고, 좋은 시간 보내세요!'),
    (36, 9, NOW(), '제주도의 자연과 함께하는 시간, 정말 소중할 것 같아요. 좋은 경험 되세요!'),
    (36, 10, NOW(), '제주도에서의 멋진 순간들을 경험하시길 바랍니다. 블로그는 천천히 올리셔도 좋습니다.'),
    (36, 11, NOW(), '디지털 디톡스와 제주도의 자연이 만나면 정말 멋진 경험이 될 것 같아요. 잘 다녀오세요!'),
    (36, 12, NOW(), '제주도의 평화로운 분위기에서 멋진 시간을 보내시길 바랍니다. 다시 블로그에서 만날 날을 기다리겠습니다.'),
    (36, 13, NOW(), '디지털 디톡스의 효과를 직접 느끼실 수 있을 거예요. 제주도에서 힐링 잘 하세요!'),
    (36, 14, NOW(), '자연과의 교감이 정말 중요한 것 같아요. 제주도에서의 여유로운 하루하루를 즐기세요!'),
    (36, 15, NOW(), '제주도에서의 시간을 통해 많은 것을 배우시길 바랍니다. 응원합니다!'),
    (36, 16, NOW(), '디지털 디톡스 후의 변화가 궁금하네요. 제주도에서의 소중한 경험 잘 누리세요!'),
    (36, 17, NOW(), '자연 속에서의 여유로운 시간, 정말 부럽습니다. 제주도에서 좋은 추억 많이 만드세요!'),
    (36, 18, NOW(), '블로그 업로드는 느긋하게 하셔도 좋습니다. 제주도에서의 힐링과 자아 발견을 응원합니다!'),
    (36, 19, NOW(), '제주도의 아름다움을 느끼며, 디지털 디톡스를 통해 새로운 시각을 얻으시길 바랍니다. 좋은 시간 보내세요!'),
    (36, 20, NOW(), '제주도에서의 여유로운 시간이 멋진 경험이 되길 바랍니다. 블로그는 천천히 업로드해도 좋으니, 많이 힐링하세요!');




-- INSERT INTO subscribe_tb (from_user_id, to_user_id, created_at)
-- VALUES (2, 1, NOW()),
--        (3, 1, NOW()),
--        (6, 1, NOW()),
--        (7, 1, NOW()),
--        (1, 2, NOW()),
--        (1, 4, NOW()),
--        (1, 3, NOW());



