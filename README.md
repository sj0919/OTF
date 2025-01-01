
# Off the Fence : 펜스 너머에서도 언제나, Off the Fence! ⚾
![제목 없는 디자인 (2)](https://github.com/user-attachments/assets/d9eac9a0-3e95-49ee-85e4-e3a7f1d1d7a5)

## 👨‍🏫 프로젝트 소개
직관 야구 팬들이 겪는 어려움을 해결하기 위해 프로젝트를 기획했습니다.
펜스 안 선수만이 아니라, 펜스 밖 팬들을 위한
Off the Fence!

## ⏲️ 개발 기간 
- 2024.12.26(목) ~ 2025.1.1(수)

## 🧑‍🤝‍🧑 개발자 소개 
- **이승진** : 이화여자대학교 융합콘텐츠학과 21학번
- **최주찬** : 카이스트 전산학부 22학번

## ⚙️ 기술 스택
- 개발 언어 : **Kotlin**
- IDE : **AndroidStudio**
- 디자인 : **Figma**
- 버전 및 이슈관리 : **Github**
- 협업 툴 : **Github**

## 📌 주요 기능

## Tab0 ; Login Page & Team Selection Page

- **로그인 기능 ✅**
  
    아이디, 비밀번호 입력 후 로그인 
    
    아이디:admin
    
    비밀번호:1234

- **팀 선택 기능 ✅**
  
    -응원하는 팀에 맞게 프로필 마스코트를 선택.
  
    -화면 좌우에 있는 버튼을 통해 원하는 팀 선택 가능.
  
    -선택 버튼을 누르면 메인 페이지로 이동.


## Tab1 ; Home Tab

    🛠 RecyclerView를 이용해 10개 구장의 맛집 리스트를 표시합니다.

    🛠 각 맛집에는 가게 사진, 가게 이름, 영업시간, 전화 아이콘, 전화번호, 찜 아이콘을 표시합니다.

    🛠 하단 바의 홈 아이콘을 누르면 홈 탭으로 이동할 수 있습니다.

- **전화 연결 기능 ✅**
    
    ➡ 전화 아이콘을 누르면 가게 전화번호 데이터를 통해 전화로 연결됩니다.
    
- **가게 찜 기능 ✅**
    
    ➡ 하트 모양의 찜 아이콘을 누르면 Tab4의 찜 목록에 해당 가게가 추가됩니다.

- **상세 정보 기능 ✅**
    
    ➡ 이외의 부분을 누르면 가게의 상세 정보를 확인할 수 있다. 상세 정보 화면에는 가게 사진, 가게 이름, 추천 메뉴를 표시합니다.

 - **드롭 다운 기능 ✅**
    
    ➡ 또한 탭 상단의 드롭다운을 클릭하면 원하는 구장으로 이동할 수 있습니다.
   
    ➡ 드롭다운 기능을 적용함으로써 사용자 입장에서 보다 편리한 사용자 경험을 제공합니다.

 - **상단 배너 기능 ✅**

   ➡ 드롭다운 바로 아래에 배너를 표시합니다. 좌우 스와이프 이전/다음 배너를 확인할 수 있습니다.

## Tab 2 ; Ticket Tab

    🛠 사용자가 직접 관람한 야구 경기에서의 시간을 보다 오래 간직할 수 있도록 도와줍니다.

    🛠 아래 하단 바의 티켓 아이콘을 누르면 티켓 탭으로 이동할 수 있습니다.

- **티켓 View 기능 ✅**
    
    ➡ 티켓 탭에 처음 들어가면 여러 장의 티켓과 각 티켓의 이미지의 확인할 수 있습니다.
  
    ➡ Tab1과 동일하게 RecyclerView를 사용하여 티켓을 표시합니다.
    
- **티켓 수 표시 기능 ✅**
    
    ➡ 화면 상단에 ‘My Ticket’ 텍스트와 ‘티켓 수: #’의 정보를 확인할 수 있습니다.
    
- **티켓 추가 기능 ✅**
    
    ➡ 화면 아래쪽에는 ‘Select Photo’의 버튼을 통해 원하는 이미지를 관람한 티켓에 붙여서 앱에서 확인할 수 있습니다.

  ➡ 티켓을 추가 후 상단의 티켓 수의 정보가 변경된 것을 확인할 수 있습니다
  
## Tab 3 ; Calendar Tab

    🛠 Tab1에서 볼 수 있었던 가게들의 위치와 혼잡도를 지도에서 표시합니다.

    🛠 아래 하단바의 지도 아이콘을 누르면 지도 탭으로 이동할 수 있습니다.

- **지도 구현 ✅**
- 
    ➡ Google Map API를 사용하여 지도를 구현했고, 관련 부가 기능 또한 Google Map의 기능을 활용했습니다.
    
- **지도 마커 기능 ✅**
    
    ➡ 가게 위치의 위도 경도 데이터를 이용해 지도 위에 마커를 표시합니다.

    ➡ 마커의 색으로 가게의 혼잡도를 표시합니다. 
    
    ➡ 매우 혼잡(Red), 혼잡(Rose), 보통..?(Orange), 보통...(Yellow)

    ➡ 마커를 클릭하면 가게 이름과 혼잡도를 표시합니다.

    ➡ 각 구장의 위치는 파란색 마커로 표시합니다. 각 구장의 마커를 클릭하면 구장 굿즈샵의 혼잡도를 표시합니다.
    
## Tab 4 ; My page Tab

    🛠 사용자의 기본 프로필과 찜 목록을 표시합니다.

    🛠 아래 하단 바의 프로필 아이콘을 누르면 마이 페이지 탭으로 이동할 수 있습니다.

- **프로필 표시 ✅**
    
    ➡ 사용자의 이름과 선택한 팀의 마스코트를 표시합니다.

    ➡ 처음에 팀을 선택할 때의 정보를 바탕으로 마이 페이지의 마스코트 이미지를 결정합니다.
    
- **찜 개수 표시 ✅**

    ➡ 사용자 이름 아래에 찜 개수를 실시간으로 반영하여 표시합니다.

- **찜 목록 기능 ✅**

    ➡ Tab1에서 사용자가 찜한 가게들의 목록을 화면에 표시합니다.
  
    ➡ 다른 목록들과 같이 RecyclerView를 이용하여 찜 목록을 표시합니다.

- **찜 목록 기능 ✅**

    ➡ Tab4에서 하트 아이콘을 눌러 찜을 해제할 수 있습니다. 이 동작은 Tab1에 바로 적용됩니다


<table>
  <tr>
    <th width="350px" align="center">1.로그인</th>
    <th width="350px" align="center">2.팀선택</th>
  </tr>
  <tr>
    <td valign="top">
      <img src="[https://github.com/user-attachments/assets/4875d8de-9804-4f45-89b1-7c75fb680ba6](https://github.com/user-attachments/assets/acea1b08-2b57-4308-898e-8f8eecfd34aa)" />

    </td>
    <td valign="top">
      <img src="https://github.com/user-attachments/assets/3c4f93b2-47eb-4bf4-b564-dfd59849581a" />
    </td>
  </tr>
</table>
