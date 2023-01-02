# STARTERS 취업부트캠프 최종평가(Java)

### 평가 안내 ([노션 링크](https://www.notion.so/flearnerhq/STARTERS-Java-8b1d1e267df64ff6921e24f966e2ea0e))

---

- 아래의 정보를 참고하여 지원서 접수 서비스를 제작합니다.
- 평가일정
    - 시험 시작 ~ 오후 6시 (점심시간인 오후 12시 30분 ~ 2시에는 반드시 퇴실)
- 평가방법
    - 평가배점표에 따라 기본점수에서 가감하여 총합된 점수로 평가
- 제출방법
    - 제출은 Github Repository로 제출하고, 시간 내에 Pull Request를 진행합니다.
        - API 명세서는 README 파일에 작성합니다. (프로젝트 폴더 내 새로 생성하여 구성)
    - [구글폼](https://forms.gle/quAHq1QUvnHubZHw5)을 통해 이미지 파일, AWS EC2 인스턴스의 퍼블릭 IP 및 Github 아이디를 제출합니다.
        - Class Diagram, E-R Diagram은 이미지 파일로 제출합니다.
    - 본 README파일을 활용하여 본인이 구현한 사항에 대해 진행 여부를 표기하여 제출합니다.

### 평가 전 주의사항

---

- 스택 별로 권장되는 코딩 표준 스타일을 활용합니다.
    - [JavaScript 코딩 표준](https://www.notion.so/JavaScript-4931f74d49054eaa9a574a230946fecb)
- 인터넷 상에서 구현에 필요한 사항을 검색/활용할 수 있습니다.
- 기타 부정행위로 간주될만한 사항이 적발될 경우 강제퇴실 처리

### 평가배점

---

| 구분 | 내용 |
| --- | --- |
| 기본점수 | 200점 |
| 코딩 표준 스타일 | 미준수 시 건당 -1점 |
| 전제사항 | 충족 시 +20점, 미 충족시 -10점 |
| 기능 요구사항  | 구현 시 +20점, 미 구현시 -20점
| | 단, 추가점수에 해당하는 항목은 미 구현 감점없음 |
| 부분 점수 | 작성 및 구현된 내용에 따라 부분 점수 가감 |

### 전제사항

---

- 로그인/회원가입은 따로 구현하지 않으며, 이미 확보된 회원데이터가 존재하는 것을 가정하고 구현합니다.
    - [x]  스프링 프로젝트 실행 시 프로젝트에서 기본적으로 참조하고 있는 데이터베이스 생성 혹은 제공하여야합니다.
    - [x]  데이터베이스는 내/외장 데이터베이스를 활용합니다.
    - [x]  회원은 교수자와 학생으로 구분합니다.
    - [x]  회원 정보는 아래의 표와 같이구성하며, 추가데이터 및 항목 별 변수타입은 올바른 값으로 자율 구성하여도 무관합니다.
      (단, 회원 데이터 구성은 최소 10개 이상 구성)


        | 회원정보 | 아이디 (이메일) | 비밀번호 | 회원 이름 | 회원 구분 | 학번 (사번) |
        | --- | --- | --- | --- | --- | --- |
- 강의 생성은 따로 구현하지 않으며, 이미 확보된 데이터가 존재하는 것을 가정하고 구현합니다.
    - [x]  스프링 프로젝트 실행 시 프로젝트에서 기본적으로 참조하고 있는 데이터베이스 생성 혹은 제공하여야합니다.
    - [x]  데이터베이스는 내장 데이터베이스인 H2를 활용합니다.
    - [x]  강의 정보는 아래의 표와 같이구성하며, 추가데이터 및 항목 별 변수타입은 올바른 값으로 자율 구성하여도 무관합니다.
      (단, 강의 당 정원은 5명, 최대 학점은 3점으로 한정하며 데이터 구성은 최소 10개 이상 구성)


        | 강의정보 | 강의명 | 담당교수 | 강의요일 | 강의시간 | 정원 | 학점 |
        | --- | --- | --- | --- | --- | --- | --- |
- [x]  강의 장바구니 기간은 2023년 1월 9일 오후 2시부터 1월 10일 오후 6시까지이며,
  강의 신청 가능 기간은 2023년 1월 11일 오후 2시부터 오후 6시까지로 설정합니다.

### 기능 요구사항

---

- **공통**
    - [x]  Class Diagram 작성
    - [x]  E-R Diagram 작성
    - [ ]  API 명세서 작성
- **사전 수강 신청 (장바구니 기능)**
    - [x]  장바구니 기능을 활용하여 강의를 사전 신청할 수 있습니다.
        - [x]  사전 신청자가 강의의 정원을 넘지 않은 경우 강의 신청이 자동으로 이루어집니다.
        - [x]  사전 신청자가 강의의 정원을 넘은 경우 강의 신청이 이루어지지 않습니다.
    - [x]  사전 수강 신청이 이루어지지 않은 경우 찜 상태로 상태값을 변환합니다.
    - [x]  신청한 강의는 요일/시간이 겹치도록 신청할 수 없습니다.
- **본 수강 신청**
    - [x]  회원은 최대 21학점까지 강의를 신청할 수 있습니다.
    - [x]  강의 신청 기간에 정원이내의 인원은 선착순으로 신청이 가능합니다.
    - [x]  신청한 강의는 요일/시간이 겹치도록 신청할 수 없습니다. (장바구니로 기 신청된 강의가 있을 경우 모두 포함)
- **수강 신청 상태 관리**
    - [x]  강의 신청의 상태는 장바구니, 신청완료, 찜 총 3가지 상태로 관리합니다.
    - [x]  수강 신청에 실패하거나 취소할 경우 별도의 데이터를 생성 및 저장하지 않고 삭제합니다.
- 교수자
    - [x]  교수자가 담당하고 있는 강의의 신청 현황을 조회할 수 있습니다.
- 배포 (추가점수)
    - [ ]  AWS 개인 계정을 활용하여 EC2 인스턴스(t2.micro)에 배포를 진행합니다.
        - 인스턴스명은 본인영문이름_final-test로 구성 (예 woosublee_final-test)
    - [ ]  배포된 EC2 인스턴스에 RDS를 연결합니다.

---
# 조형래
## Class Diagram
<img width="1293" alt="class-diagram" src="https://user-images.githubusercontent.com/76774733/210210972-5b88d60f-812f-4bd4-8354-c5b460520dea.png">

## E-R Diagram
<img width="1059" alt="e-r diagram" src="https://user-images.githubusercontent.com/76774733/210210980-7e9720fc-2e09-4f53-b631-786cbb5a1cfc.png">

## API 명세서
1. 사전 수강신청</br>
    **설명**: 사전 수강신청 api 입니다.</br>　　　신청을 원하는 학생 번호와 강의 번호를 JSON 형태로 넣습니다.</br>
    **URL**: localhost:8080/api/v1/enrolment/pre</br>
    **METHOD**: POST</br>
    **REQUEST**: </br>
    <img width="245" alt="request1" src="https://user-images.githubusercontent.com/76774733/210210994-261b5230-c362-43c9-bcc2-d467ecf1e0f8.png">

    **RESPONSE**: </br>
    <img width="481" alt="response1" src="https://user-images.githubusercontent.com/76774733/210211019-601d8765-f8ef-4c76-92fc-9af40c9cdbdf.png">


2. 사전 수강신청 취소</br>
   **설명**: 사전 수강신청 취소 API 입니다.</br>　　　취소를 원하는 학생번호와 강의 번호를 JSON 형태로 넣습니다.</br>
   **URL**: localhost:8080/api/v1/enrolment/pre</br>
   **METHOD**: DELETE</br>
   **REQUEST**: </br>
   <img width="245" alt="request1" src="https://user-images.githubusercontent.com/76774733/210210994-261b5230-c362-43c9-bcc2-d467ecf1e0f8.png">
   **RESPONSE**: </br>
    <img width="479" alt="response2" src="https://user-images.githubusercontent.com/76774733/210211027-95ac1af3-0d72-48b8-936c-86a71a029f6d.png">

3. 본 수강신청</br>
   **설명**: 본 수강신청 API 입니다.</br>　　　신청을 원하는 학생 번호와 강의 번호를 JSON 형태로 넣습니다.</br>
   **URL**: localhost:8080/api/v1/enrolment/real</br>
   **METHOD**: POST</br>
   **REQUEST**: </br>
   **RESPONSE**: </br>
    ![response3.png](..%2F..%2F..%2F..%2FUsers%2Fppirae%2FDesktop%2Fresponse3.png)</br></br>
    

4. 본 수강신청 취소</br>
   **설명**: 본 수강신청 취소 API 입니다.</br>　　　취소를 원하는 학생번호와 강의 번호를 JSON 형태로 넣습니다.</br>
   **URL**: localhost:8080/api/v1/enrolment/real</br>
   **METHOD**: DELETE</br>
   **REQUEST**: </br>
   <img width="245" alt="request1" src="https://user-images.githubusercontent.com/76774733/210210994-261b5230-c362-43c9-bcc2-d467ecf1e0f8.png">
   **RESPONSE**: </br>
    <img width="477" alt="response4" src="https://user-images.githubusercontent.com/76774733/210211047-5a9a0f12-5891-4513-913d-b9dff08f9acb.png">


5. 강의 리스트 보기</br>
   **설명**: 강의 리스트를 볼 수 있는 API 입니다.</br>
   **URL**: localhost:8080/api/v1/lecture</br>
   **METHOD**: GET</br>
   **REQUEST**: X</br>
   **RESPONSE**: </br>
    <img width="259" alt="response5" src="https://user-images.githubusercontent.com/76774733/210211050-dce95d28-3640-4186-812f-1aef413e03e5.png">


6. 본 수강신청 취소</br>
   **설명**: 교수별 강의 신청 현황을 볼 수 있는 API 입니다.</br>　　　교수의 identificationNum을 /뒤에 붙여주세요.</br>
   **URL**: localhost:8080/api/v1/lecture/{identificationId}</br>
   **METHOD**: GET</br>
   **REQUEST**: X</br>
   **RESPONSE**: </br>
    <img width="301" alt="response6" src="https://user-images.githubusercontent.com/76774733/210211056-3790b4a3-4655-430c-8f97-b920037034f0.png">


## 사전 수강 신청 기간이 지날때</br>
EnrolmentService의 AfterBasketPeriod 메서드에서</br>
Java의 Timer를 이용하여 사전 수강 신청 기간이 지나면 </br>
endBasketPeriod 메서드를 실행하여 기능 구현하도록 만들었습니다.</br>
AfterBasketPeriod 메서드는 initDb 클래스에서 실행하여</br>
서버가 구현될때 반드시 한번 실행하도록 만들었습니다.

## 배포랑 RDS
시간이 부족해서 못했습니다.