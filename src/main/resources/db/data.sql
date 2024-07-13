-- 유저 더미
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('ssar', '1234', 'ssar@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('cos', '1234', 'cos@nate.com', now());
INSERT INTO user_tb (username, password, email, created_at)
VALUES ('love', '1234', 'love@nate.com', now());
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
-- 카테고리 더미 끝

-- 게시글(포스트) 더미
INSERT INTO post_tb (title, content, user_id, category_id, thumbnail_file, created_at)
VALUES ('스위스 13박 14일 여행 후기❤',
        '안녕하세요, 여러분! 오늘은 제가 지난 여름에 다녀온 스위스 여행에 대한 후기를 들려드리려 합니다.
        저는 13박 14일 동안 스위스 곳곳을 둘러보며 아름다운 자연 경관과 맛있는 음식들을 즐길 수 있었습니다.
        첫 번째로 취리히에서 시작한 여행은 눈부신 알프스 산맥의 풍경에 매료되었습니다.
        호수 위로 반사되는 아름다운 풍경은 마치 그림 속에 들어와 있는 듯한 느낌이었죠.
        또한 베른에서는 중세 시대의 모습이 잘 보존된 아름다운 도시 풍경을 감상할 수 있었습니다.', 1, 1, 'swiss.jpg', NOW()),

       ('여름에 일본 빨리 갔다오기 (자유 여행)',
        '안녕하세요~ 오늘은 일본 여행에 대한 포스팅을 해보려고 해요!! 이번 여름에 일본을 갔다왔는데, 덥더라구요~~~
        덥고 습한 날씨 때문에 걱정도 되었지만, 첫 번째로 도쿄에 도착했을 때엔 도쿄 스카이트리 등
        유명 관광지들을 둘러보면서 날씨 걱정이 잊혀졌어요!', 1, 1, 'japan.jpg', NOW()),

       ('강아지와의 만남', '산책 나갔을 때 보았던 강아지! 산책로를 걷고 있는데 갑자기 작은 강아지가 저를 향해 다가왔어요.
         강아지의 주인분도 함께 계셨는데, 강아지와 대화를 나누며 재미있는 시간을 보냈습니다.', 1, 2, 'dog2.jpg', NOW()),

       ('고양이 집사의 하루 (네로와 함께)', '우리 집 고양이 네로와 함께하는 하루 이야기를 들려드립니다.
         아침 일찍 일어나면 네로가 침대에 와서 깨워줍니다. 그리고 저와 함께 아침 식사를 합니다.
         식사 후에는 네로가 창가에 앉아 새들을 바라보며 한숨 자곤 합니다.
        저는 그 모습을 보며 네로가 참 평화로워 보인다고 생각합니다.', 1, 2, 'cat.jpg', NOW()),
--     여기까지 1번 유저 ssar

       ('요리 레시피 - 마르게리타 피자', '간단하지만 맛있는 마르게리타 피자 만들기! 레시피를 공유합니다~ 아이들 점심 식사나 간식으로 좋아요^^', 2, 4, 'pizza.jpg', NOW()),
       ('맛있는 파스타 만들기', '집에서 직접 만든 맛있는 파스타 레시피를 공유합니다.', 2, 4, 'pasta.jpg', NOW()),
       ('뉴질랜드 가보신분? (저요! 🙋‍♀️)', '뉴질랜드의 아름다운 바다 풍경을 담은 사진입니다 ^^', 2, 3, 'newZealand.jpg', NOW()),

       ('홈트레이닝 다이어트 루틴', '집에서 운동하는 분들을 위한 효과적인 홈트레이닝 루틴을 소개합니다.', 3, 5, 'exercise.jpg', NOW());
--        ('IT 기술 동향 - 5G 네트워크 발전', '최근 5G 네트워크 기술의 발전 동향과 향후 전망에 대해 정리해보았습니다.', 5, 2, '5g_network.jpg', NOW()),


