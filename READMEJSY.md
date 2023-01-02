 수강신청을 위해 로그인 된 상태를 전제.

 ```
사전 수강 신청 API
 ```
 
 1. 사전 수강 신청 (POST- /api/members/applications/reserve/{memberId})
 
 Request - Body에 lectureName을 Json 형식으로 넣어줍니다.
 (캡쳐 사진과 달리, 로그인 된 상태이므로 리퀘스트에 memberName을 받지 않는 것으로 변경했습니다.)

 Response

 - 수강 신청 성공
 <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210203918-fd8a1cd1-5c1d-461e-adf4-b7a73bf3cb4c.PNG">
 - 수강 신청 실패(사전 신청 기간 이전)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210203263-7df44a90-37e6-4d4a-8be5-898542fd3b90.PNG">
- 수강 신청 실패(수강 신청 인원 초과, 찜으로 이동)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210203952-fa5f7ee5-79ce-4c6e-82db-bf5c27b9198d.PNG">

- 수강 신청 실패(중복된 요일/시간)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210203729-83869f82-d1eb-43fd-a006-eb968d400262.PNG">
- 수강 신청 실패(이미 수강 신청한 강의)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210204005-49f7847c-eb36-46cc-9bb9-504f4dfb7e82.PNG">

```
본 수강 신청
```

1. 본 수강 신청  (POST- /api/members/applications/{memberId})

 Request
 
 Body에 lectureName을 Json 형식으로 넣어줍니다.
 (캡쳐 사진과 달리, 로그인 된 상태이므로 리퀘스트에 memberName을 받지 않는 것으로 변경했습니다.)

 Response

- 수강 신청 성공
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210204170-733ada28-f4a4-4626-bf5e-424e59797c7e.png">


- 수강 신청 실패 (수강 신청 기간 이전)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210204740-2d4a4faa-ea09-4d34-9bd2-b335c382841a.png">

- 수강 신청 실패 (수강 신청 실패, 최대학점 초과)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210204849-faffab1f-5883-4760-b506-45902f45e91d.PNG">

- 수강 신청 실패(최대 인원 수 초과)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210204849-faffab1f-5883-4760-b506-45902f45e91d.PNG">

- 수강 신청 실패(중복된 강의/요일, 장바구니 기간 포함)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210203729-83869f82-d1eb-43fd-a006-eb968d400262.PNG">

- 수강 신청 실패(이미 신청 완료 된 강의)
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210204005-49f7847c-eb36-46cc-9bb9-504f4dfb7e82.PNG">

```
수강 신청 삭제
```

1. 수강신청삭제 (DELETE - /api/members/applications/{applicationId})

request - PathVariable로 삭제하고 자 하는 지원서의 id 입력

response
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210205315-00dbbf74-e6df-47e7-9ffe-b64069985f66.png">


```
교수자가 담당하고 있는 강의의 신청 현황을 조회할 수 있습니다.
```

1. 조회 API /api/members/applications/lecture/teacher?lectureName=

request 쿼리 파라미터로, 자신의 강의하는 과목의 이름을 입력합니다.

response

<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210205890-5f8b1cfb-7a5a-4844-9f17-bd9018f6d2ce.PNG">


```
수강 신청 상태 관리
```

- Spring 스케줄러를 통해, 지원서의 상태가 장바구니, 찜 상태인 지원서 중 지원 종료 기간이 지난 신청서를 DB에서 삭제합니다.

<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210206196-44bc0bb1-38ca-4f07-b74c-f677c5973505.png">

<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/210206259-1beaf56b-9bc9-4f24-b867-b59c18e573c5.png">


