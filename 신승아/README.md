<details>
<summary>
  2025-01-13 
</summary>

## 1. 개인 아이디어 제시

## 1) 문제 상황

→ 해외 여행을 처음 가는 사람

→ 여행 계획을 짜는 데 어려움이 있는 사람

→ 혼자 여행을 가기 싫은 사람

등등..

예시로 든 위에 사람들 외에도 많은 사람들은 여행사의 **‘패키지’** 상품을 이용한다.

하지만 패키지 상품을 사용해봤을 때 단점은 ‘빡빡한 스케줄, 원치 않는 루트,  같은 패키지를 이용하는 일행’ 등이 있다.

그래서 여행을 가고 싶지만 가기 쉽지 않은 사람들을 위해 생각한 서비스이다.

## 2) 주요 기능

### **1️⃣ 매칭**

사용자가 원하는 여행 스타일을 입력 받아 니즈가 비슷한 회원끼리 매칭. 매칭된 사용자들끼리 실시간 채팅/화상 통화를 통해 정해진 양식(여행 계획 템플릿)에 맞춰 여행 계획을 세워 글 등록.여행사 쪽에서 글을 보고 추진할 수 있는 여행 계획을 채택하는 방식

**사용자가 이 서비스를 사용하기 위해 입력해야 할 정보 (예상)** 

- 음주 유/무/상관없음
- 디저트 선호도
- 숙박 중요도
- 일정 기간 동안 많은 장소 방문을 희망 VS 여유로운 여행을 희망하는지 등등의 활동 스타일
- 원하는 여행 주제 작성 (EX 디저트 여행, 그 나라의 문화를 알기, 식도락 여행 등등)
- 동행자의 선호 사항

등등

여행 계획 템플릿

⇒ 사용자들이 쉽게 여행 계획을 만들 수 있도록, 다양한 여행지와 활동을 카테고리 별로 나누어 제공 

### 2️⃣**기존 패키지 비교 (고려)**

여행사 API(하나투어, 모두투어, 노란풍선등등,,)를 활용하여 여행사 측

에서 제공하는 패키지 비교 기능 ⇒ 선택 시 해당 사이트로 이동

❗여행사 API를 쓸 수 있는지 확인해야 함(문의 필수)/ 불가능 시 웹 크롤링.. 또는 사용X

### 3️⃣커뮤니티 / 피드백

실제 이 사이트를 이용했을 때 후기를 공유할 수 있는 커뮤니티

### 4️⃣ 현지 여행사 승인 시스템

⇒ 사용자들의 여행 계획을 보고 여행을 채택할 경우 사용자들과의 실시간 채팅으로 연결되어 여행 계획 조정

→ 실시간 커뮤니케이션 시스템

→ 예약 및 일정을 관리할 수 있는 기능

※ 예를 들어, 사용자가 작성한 일정이 현지 여행사의 서비스 제공 범위 내에 있는 지 확인하고, 필요한 경우 여행 일정을 조정/보완해야 하기 때문

또한, 반대로 여행사 측에서 맞춤형 패키지를 제공하는 페이지도 있으면 괜찮을 듯

### 5️⃣ 알림 시스템

⇒ 진행 상황에 대해 알림

## 3) 추가할 수 있는 기능

### **1️⃣ 다국적 언어 지원**

⇒ 다양한 국가에서 여행하는 사람들과 매칭 될 수 있는 방향을 고려해 보는 것도 나쁘지 않을 듯

⇒ 각국의 문화, 예절, 여행지 팁, 주의 사항을 제공

## 4) 서비스 이점

### **1️⃣ 비용 절감**

⇒ 기존 여행사의 패키지 여행은 때때로 너무 비싸거나, 사용자가 원하지 않는 부분이 포함되어 있을 

수 있다. 그러나 이 서비스는 사용자가 선택한 여행 일정 만으로 패키지를 구성할 수 있어 더 저렴한 여행을 즐길 수 있다. 자신의 예산에 맞는 여행 계획을 설정하여 비용 효율적인 여행을 만들 수 있다는 것이다.

### 2️⃣ 만족도 향상

⇒ 사용자가 직접 만든 여행 계획을 채택하는 서비스 이기에 차별화된 서비스를 제공하고

이를 통해 독창적이고 창의적인 상품을 원하는 고객 유치 가능

⇒ 자신이 만든 계획이 실제 여행으로 이어질 경우, 그 여행사에 대한 만족감을 느끼고 재이용성이 높다

## 5) 기존 서비스와의 차별점

### **1️⃣ 실행 방식**

⇒ 대형 여행사(EX 하나투어, 모두투어 등등)가 아닌 현지 여행사와의 직접적인 협력을 통해 사용자의 여행 계획을 실행 가능 하도록 예약하고 실행하는 방식

### 2️⃣ 패키지 여행의 개인화

⇒ 사용자가 **전체 여행 계획**을 **자유롭게 설정**하고, 자신만의 여행 스타일에 맞춘 일정, 활동, 숙박 등을 완전히 개인화할 수 있습니다. 

## 💻백(GPT)

1. 매칭 시스템
    
    → 사용자들의 여행 취향 및 스타일을 기반으로 매칭 알고리즘
    
    → 매칭된 사용자들의 정보를 저장, 비교, 연결할 수 있는 데이터 처리
    
    → 매칭된 사용자들 간의 메시지 기록 저장 및 관리
    
2. 여행 계획 관리 및 템플릿 처리
    
    → 사용자가 작성항 여행 계획을 서버에서 저장, 업데이트, 삭제할 수 있는 기능
    
    → 다양한 여행 계획 템플릿을 미리 제공하고 이를 수정할 수 있도록 지원
    
3. 알림 시스템
    
    → 여행 계획 진행 상황에 대해 사용자에게 알림을 전송(예: 여행사 승인, 매칭된 사용자와의 소통알림 등등)
    
4. 예약 및 일정 관리
    
    → 동기화된 데이터 관리로 실시간으로 일정 변경 및 업데이트 반영
    

## 💻프론트(GPT)

1. 사용자 인터페이스 디자인
    
    → 뭐,,실시간 소통 인터페이스, 반응형 웹/앱 디자인 등등
    
2. 사용자 입력 및 정보 처리
3. 여행 계획 템플릿
4. 매칭 및 사용자 간 소통
    
    → 사용자 간 매칭 결과를 명확히 보여주는 화면
    
    1. 알림 기능
        
        → UI
        
    
    → 실시간 채팅 및 화상 통화 기능을 위한 인터페이스
    
5. 예약 일정
    
    → 일정 관리 화면에서 여행 계획 변경 및 상세 일정 확인

## 2. 아이디어 회의

회의를 통해 나온 아이디어 중 구현가능성, 참신성 등 기준을 놓고 아이디어회의를 진행하였다.

피그마를 활용하여 아이디어 시나리오를 작성과 미팅을 통해 주제 선정과 아이디어 구체화 방향을 잡았다.

- [2x2 Matrix Template on Figma](https://www.figma.com/board/FNf9cPH8OR9HqrHQLJR7Ay/2x2-Matrix-Template-(Community)?node-id=0-1&p=f&t=jCfOiUcPCLiMWiKo-0)

- [Notion Document](https://www.notion.so/8153d7cd54614cdda84829a6e8053bf5?d=ba4b5ba17b4a42bba6dc405f5e521412#e0ca957de0774eec8b13335365780fe7)

## 3. webRTC
= 브라우저 간 실시간 통신을 가능하게 하는 기술

1. navigator.mediaDevices.getUserMedia()

    => 사용자 장치의 카메라와 마이크에서 미디어 스트림을 가져오는 API

```
ex) 
navigator.mediaDevices.getUserMedia({ video: true, audio: true })
  .then((stream) => {
  })
  .catch((error) => {
    console.error("Error accessing media devices", error);
  });
```

2. RTCPeerConnection

    => 오디오 및 비디오 스트림을 교환하는데 사용

```
const peerConnection = new RTCPeerConnection();

stream.getTracks().forEach(track => {
  peerConnection.addTrack(track, stream);
}); // 로컬 미디어 스트림 추가

// ICE 후보 처리
peerConnection.onicecandidate = (event) => {
  if (event.candidate) {
  } // 시그널링 서버로 보내기
};

peerConnection.ontrack = (event) => {
  const remoteStream = event.streams[0];
  const remoteVideo = document.querySelector('#remote-video');
  remoteVideo.srcObject = remoteStream;
};// 원격 스트림 처리
```

... 추후 더 공부 예정

## 4. 느낀점점
=> webRTC를 사용하기 위해서 API를 연결하는 과정을 알아보았다. 아이디어 구체화를 하는 과정에서 AI를 사용하면 더 좋을 거 같다는 의견에 이 부분을 어떻게 연결해야할 지 좀 더 알아봐야 할 것 같다.

</details>

<details>
<summary>
  2025-01-14 
</summary>

  # 아이디어 기획

  - [아이디어 고도화](https://www.figma.com/board/2zJB2KigZgpFTxEPSVnbUj/%EA%B8%B0%EB%8A%A5-%EA%B3%A0%EB%8F%84%ED%99%94?node-id=0-1&p=f&t=KL81nPwpbUIYEwFs-0)

  ## 2차 미팅 진행
  - Q) 가고자 하는 곳에 비행기가 없을 경우?
    => [스카이스캐너API](https://developers.skyscanner.net/docs/flights-live-prices/overview)
      를 통해 출발지-도착지 검색 후만 검색을 입력했을 때 결과값을 활용
  - Q) 공동 작업 필수로 넣기
    => getDisplayMedia API 활용 예상

# git 공부 및 정리
```jsx
git init
```

⇒ 새로운 Git 저장소(repository)를 생성할 때 사용

## staging area

⇒ commit을 하기 전에 commit할 파일을 골라 놓는 곳

- staging
    
    = staging area에 파일 넣는 행위
    
    → **git add  명령어로 넣음**
    

## repository

⇒ commit된 파일의 버전들을 모아 놓는 곳

# git add

1.

```jsx
git add 파일명1, 파일명2 
=> 여러 파일 스테이징
```

2.

```jsx
git add .
=> 모든 파일을 전부 스테이징
```

1. 상태 확인

```jsx
git stateus
=> 지금 변경된 파일, 스테이징된 파일을 알려줌
```

1. 스테이징 취소

```jsx
git restore --staged 파일명
```

# git commit

1. commit

```jsx
git commit -m '메세지'
```

1. 상태 확인

```jsx
git log --all --oneline 
git log -=all --oneline --graph //그래프로 그려줌
=> commit 기록을 한 눈에 파악하기
	입력 후엔 Vim 에디터가 켜져서 j,k 키로 위아래 스크롤이 가능, q키로 종료
```

VScode 에디터에서 

➕ 누르면 git add

✔️ 누르면 git commit 

# diff

1. 과거 특정 파일과 현재 파일 비교

```jsx
git diff(tool) 커밋id
```

1. 과거 특정 commit 2개 간의 차이점 비교

```jsx
git diff(tool) 커밋id1 커밋id2
```

Vim 에디터가 켜질 경우

hjkl 로 움직일 수 있고 :q 여러번 또는 :qa 임

근데 **git graph**

# git branch

⇒ 프로젝트의 복사본을 만드는 것과 같음

```jsx
git branch 브랜치이름
```

⇒ 브랜치’만’ 생성

```jsx
git switch 브랜치이름
//전에는 git checkout 브랜치명 을 사용
```

⇒ 브랜치 이동

```jsx
git status
```

⇒ 현재 위치 확인

# git merge

⇒ 브랜치에서 작업한 코드를 main브랜치에 합하는 것

1. push하려는 브랜치로 이동 (ex git switch main)
2. 합치려는 브랜치 입력

```jsx
git switch main
git merge 브랜치명
```

※ 합칠 때 주의사항

⇒ master와 banch에서 같은 파일, 같은 줄 CONFLICT 발생

<<<< / >>>> / ==== 쓸데없는 것을 지우고 원하는 코드만 남기기

그 후

```jsx
git add 파일명
git commit -m '메세지'
```

## 요약

```jsx
브랜치 생성 => git branch 브랜치명
브랜치 이동 => git switch 브랜치명
브랜치 합치기 main/master 브랜치로 이동한 뒤=>  git merge 브랜치명
브랜치마다 commit 내역을 그래프로 보고 싶을 경우 => git log--graph--online--all
브랜치 합칠 때 conflict발생 시 파일열어서 수정 후 => git add, commit

```

# git restore

⇒ 최근 commit된 상태로 현재 파일의 수정 내역을 되돌릴 수 있음

```jsx
git restore 파일명
git restore --source 커밋아이디 파일명 //입력한 파일이 특정 커밋 아이디 시점으로 복귀
```

# git revert
⇒ 3개의 commit 중 2번째 파일이 문제가 많아서 commit을 취소하고 싶다?

실은 없애는 건 아니고 commit하나를 취소한 commit이 생성되는 것

```jsx
git revert 커밋아이디
```

→ 입력하면 에디터가 뜨는데 커밋메세지 수정하고 닫기

→ 만약 Vim에디터가 뜰 경우? 이 또한 커밋메세지 수정하라는 건데 수정하려면 i눌러서 수정

아닐 경우 esc 누른 후 :wq

# git reset

⇒ 걍 최대한 최대한도 아니고 사용하지 않는다 생각
</details>


<details>
<summary>
  2025-01-15 
</summary>
  
  # Jira

  = 프로젝트 관리 및 이슈 추적 시스템

→ 비슷한 서비스:  Github, Trello 등

- 장점
    - 애자일 한 프로젝트 관리 도구 제공
        
        → 칸반, 스크럼 등의 개발 방식간략한 UI/UX, 타앱과의 연동성(Gihub, Slack 등)
        
    - 이슈 관리
        
        → 이슈를 세분화하여 다양한 업무를 계층화 할 수 있음
        
- 특징
    1. 이슈 및 작업 관리 
        1. 이슈 트래킹 (이슈 추적)
        2. 이슈 워크플로우 ⇒ 이슈의 진행 상황을 시각적으로 추적
    2. 프로젝트 관리
    3. 팀 협업
        1. 사용자 및 역할 관리 ⇒ 각 팀원의 역할과 권한을 부여할 수 있고, 관리자는 팀원들이 어떤 작업을 할 수 있을지 세부적으로 조정 가능
    4. 자동화
        1. 반복적인 작업을 자동화할 수 있는 기능 
        2. 특정 작업에 대해 알림을 설정하여 팀 내의 중요 변경 사항이나 이벤트에 대해 알릴 수 있음
    

## EPIC

= 제일 큰 기능 단위나 프로젝트의 주요 영역을 나타냄

→ 여러 개의 작은 작업으로 분해해야할 큰 목표 또는 기능으로 표

- 주로 Major Feature들을 중심으로 정의
- 해당 이슈의 출처와 목적을 분명하게 하기 위해 ~~으로서, ~이 필요하다는 식으로 작성하는 것을 추천
- 장기적인 목표로, 한 번에 완료될 수 없는 큰 작업

## 태스크(Task)

= 실제로 수행해야 할 구체적인 작업이나 활동

→ 구체적인 작업 단위

## 하위 작업(Sub Task)

= 위의 이슈들의 하위 작업

- commit이라고 생각하면 좋다

-----
# 개인 공부
- vue를 공부할 떈 axios 라이브러리를 사용하여 서버에 데이터 요청하였다. 검색 또는 gpt를 통해 서버 요청 관련 질문을 하였을 때 fetch()를 사용하는 결과가 많이 나와서 fetch에 대한 공부를 진행했다.

## fetch

```jsx
fetch().then().then()
```

- fetch() : 요청지 주소, method headers 등 요청정보, 데이터 정보(body)
- then():  첫번째 then. 받을 데이터 형태의 빈깡통으로 세팅 →나머지 랜더링 계속
- then() : 두번째 then. 실제 데이터가 담기는 곳 → 랜더링 완료 후 두번째 then 에 데이터가 있으면 다시 랜더링

### fetch의 사용: GET 방식으로 서버에 데이터 요청

```jsx
fetch('요청지 주소', { method : "GET" })       //메소드 방식 지정
        .then(res => res.json())              //json으로 받을 것을 명시
        .then(res => {                        //실제 데이터를 상태변수에 업데이트
            console.log(1, res);
            setValue(res);
		}); 
```

### fetch의 사용: POST 방식으로 서버에 데이터 요청

```jsx
fetch("요청지 주소", {
            method : "POST",          //메소드 지정
            headers : {               //데이터 타입 지정
                "Content-Type":"application/json; charset=utf-8"
            },
            body: JSON.stringify(data)   //실제 데이터 파싱하여 body에 저장
        }).then(res=>res.json())        // 리턴값이 있으면 리턴값에 맞는 req 지정
          .then(res=> {
            console.log(res);          // 리턴값에 대한 처리
          });
```

### 로그인 로직(fetch 사용)

```jsx
const response = await fetch(
      "요청지 주소",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: email,
          password: password,
        }),
      }
    );
    const result = await response.json();
```

- const response = await fetch(URL, options):
    - 첫 번째 인수 ⇒ 요청을 보낼 URL
    - 두 번째 인수 ⇒ 요청 옵션(메소드, 헤더, 바디 등)을 객체 형태로 전달
    - await ⇒ Promise가 완료될 때까지 기다린 후, 그 결과를 result에 저장

위 코드는 비동기식으로 작동하므로, await키워드를 사용하는 부분은 반드시 asyn 함수 내부에서 호출하기

### 회원가입 구현

```jsx
//서버 통신
try {
      const response = await fetch(
        " https://port-0-gateway-12fhqa2llofoaeip.sel5.cloudtype.app/auth/signup",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(payload),
        }
      );

      const data = await response.json();

      if (response.status === 201) {
        // Redirect to login.html
        console.log("성공! 이메일주소: " + data.email);
        navigate("/login"); // 로그인 성공시 홈으로 이동합니다.
      } else if (response.status === 400) {
        // Handle error
        alert(`회원가입 실패: ${data.email}`);
      }
    } catch (error) {
      console.error("오류 발생:", error);
    }
```

### 로그아웃

```jsx
sessionStorage.removeItem("token");
sessionStorage.removeItem("email");
sessionStorage.removeItem("role");
sessionStorage.removeItem("storeid");
```

⇒ sessionStorage에 갖고 있던 로그인 정보를 모두 버리기
</details>

<details>
<summary>
  2025-01-16 
</summary>

  # 📊[플로우 차트](https://www.figma.com/board/2zJB2KigZgpFTxEPSVnbUj/%EA%B8%B0%EB%8A%A5-%EA%B3%A0%EB%8F%84%ED%99%94?node-id=0-1&p=f&t=mGwDoWI0u6nyt1Ye-0)

  - 전체적인 프로젝트 흐름을 사용자와 여행사를 나눠 완성

  # 📜[기능명세서](https://www.notion.so/17c8b1bba83d806eaa23c10a39ce9ccd)

  - 페이지를 큰 틀로 잡고 사용자, 여행사 입장에서 각각의 상세 기능을 작성성

  # PWA

Progressive Web App

= 웹 사이트를 안드로이드/ios 모바일 앱처럼 사용할 수 있게 만드는 일종의 웹개발 기술

 

## 웹사이트를 PWA화 시키면 좋은 점

1. **스마트폰, 태블릿 바탕화면에 웹사이트를 설치 가능**
    
    ⇒ 설치된 앱을 구르면 상단 URL바가 제거된 크롬 브라우저가 뜸
    
2. **오프라인에서도 동작 가능**
    
    ⇒ service-worker.js라는 파일과 브라우저의 Cache storage  덕분
    
    (js로 게임 만들 때 유용)
    
3. **설치 유도 비용이 매우 적음**
    
    ⇒ 앱 설치를 유도하는 마케팅 비용이 적게 들어 좋음
    
    (웹사이트 방문자들에게 간단한 팝업을 띄워서 설치 유도 할 수 있음)
    

## 방법

⇒ manifest.json과 service-worker.js 라는 파일 2개만 사이트 로컬 경로에 있으면 브라우저가 PWA로 인식

**※ 프로젝트 생성 시!!**

```jsx
npx create-react-app 프로젝트명 --template cra-template-pwa
```

/index.js 로 간 후 

```jsx
serviceWorkerRegistraion.unregister();
// ↑ 이 부분을
serviceWorkerRegistraion.register();
// 변경
```

그 후 

```jsx
yarn build / npm run build 
```

를 진행하게 되면 위에 말한 두 파일이 자동으로 생성

여기까지 PWA 발행

---

## manifest.json / service-worker.js 파일 살펴보기

- manifest.json ⇒ 웹앱의 아이콘, 이름, 테마색 이런 부분을 결정
    
    ```jsx
    {
      "version" : "사용하고 있는앱의 버전.. 예를 들면 1.12 이런거",
      "short_name" : "설치 후 앱런처나 바탕화면에 표시할 짧은 12자 이름",
      "name" : "기본이름",
      "icons" : { 여러가지 사이즈별 아이콘 이미지 경로 },
      "start_url" : "앱아이콘 눌렀을 시 보여줄 메인페이지 경로",
      "display" : "standalone 아니면 fullscreen",
      "background_color" : "앱 처음 실행시 잠깐 뜨는 splashscreen의 배경색",
      "theme_color" : "상단 탭색상 등 원하는 테마색상",
    }
    ```
    
    등등 집어 넣을 수 있음
    
    ➕ version, scope 항목은 추가로 검색해보기
    
    ```jsx
    <link rel="manifest" href="/manifest.webmanifest">
    ```
    
    ⇒ 웹앱에서 사용하는 모든 html 
    
- service-worker.js
    
    ⇒ 기존의 앱 같은 건 설치할 때 스토어 가서 설치하면 앱 구동에 필요한 이미지, 데이터들이 전부 하드에 설치
    
    그 후 앱을 실행하면 앱 구성에 필요한 데이터를 서버에 요청하는 것이 아니라 하드에 이미 설치되어 있는 걸 그대로 가져와 씀
    
    이러한 것을 흉내내도록 도와주는 파일
    
    [참고 url]
    
    (공식 튜토리얼) https://developers.google.com/web/fundamentals/primers/service-workers
    
    (샘플) https://googlechrome.github.io/samples/service-worker/basic/
    
    ⇒ service worker 파일을 내가 만들고 싶다? 그때 참고
    

## PWA 커스터마이징

1. **하드에 설치할 파일 중 HTML을 제외하기**
    
    node_modules/react-scripts/config/webpack.config.js 
    
    ```jsx
    new WorkboxWebpackPlugin.InjectManifest({
        swSrc,
        dontCacheBustURLsMatching: /\.[0-9a-f]{8}\./,
        exclude: [/\.map$/, /asset-manifest\.json$/, /LICENSE/], 
    ```
    
    - exclude ⇒ 어떤 파일을 캐싱하지 않을 건지 결정하는 부분
        
        정규식으로 작성하는데 정규식과 일치하는 파일명을 제외합니다.
        
        그래서 원하는 HTML 파일을 여기 등록하시면 끝입니다.
</details>
