# JStory-Project (Blog Web Project)

### [ 개인 프로젝트 ]
|                                                         이름                                                        |                     프로필 사진                     |       GitHub 주소        |
|:---------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------:|:--------------------------:|
|                                                        송채현                                                          | <img src="https://avatars.githubusercontent.com/u/148741097?v=4" alt="profile" width="100" height="100"> | [@codingbb](https://github.com/codingbb) |


### 1. PPT


### 1. 의존성
- devtools
- spring web (mvc)
- mustache
- lombok
- jpa
- mariadb
- validation

### 2. DB설정


### 3. 에디터
- https://quilljs.com/


### 6. 모델링
![image](https://github.com/user-attachments/assets/eaf40983-3b1d-4ea9-9aec-834378111c6d)

```sql
Visit
id
userId
totalCount
createDate
updateDate

User
id
username
password
createDate
updateDate

Post
id
title
content
thumnail
userId
categoryId
createDate
updateDate

Like
id
postId
userId
createDate
updateDate

Category
id
title
userId
createDate
updateDate
```

### 7. 기능정리
- 단위테스트 - API 문서 자동생성
- AOP 처리
- 배포
- firebase fcm

