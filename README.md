# 🎈 TripJava

구글 지도 API를 활용하여 여행 경로를 저장하고 세부 일정 등 여행 스케줄을 편리하게 작성할 수 있는 웹사이트

✅ **[header]** 유저 상태에 따른 로그인/로그아웃 문구, 홈/로그인 기능

✅ **[메인페이지]** 여행지 입력

✅ **[지도]** 여행 경로 생성

✅ **[마이 페이지]** 여행 경로 열람 

✅ **[여행 플래너]** 여행 일정, 금액, 메모 등 여행 전체 일정 작성

✅ **한국관광공사 오픈 API**를 받아와 MySql 데이터 베이스에 저장

- **개발 기간** : 2024년 2월 13일 ~ 2024년 2월 29일
- **배포 주소** : http://101.101.218.151:8000
<br />

## 👨‍👩‍👧‍👦 팀 구성

|역할|이름|담당|✍️|
|------|---|---|---|
|Back-end(조장)|[권소희]()|ERD, DB제작, 회원 CRUD, 여행 경로 저장 API|[회고록]()
|Back-end|[정세은]()|ERD, DB제작, 서버 배포, Checklist CRUD|[회고록]
|Back-end|[황주리]()|ERD, DB제작, 회원 CRUD, 서버 배포, Itinerary CRUD |[회고록]
|Back-end|[구은현](https://github.com/EunnyKoo)|ERD, DB제작, Checklist CRUD, Itinerary CRUD|[회고록](https://velog.io/@eunkoo/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%97%AC%ED%96%89-%ED%94%8C%EB%9E%98%EB%84%88-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%8A%B8%EB%A6%BD%EC%9E%90%EB%B0%94-%ED%9A%8C%EA%B3%A0%EB%A1%9D)|
|Front-end|[나영혜]()|여행 경로 지도|[회고록]
|Front-end|[이도준준]()|회원가입, 로그인, 마이페이지, 일정표, 여행지 목록|[회고록]

<br />

# 🔧 개발환경
## Front
JavaScript, SCSS, Figma, Google Map

## Back
Spring Boot, Java, MySQL, Postman

## Environment
Git, Github, Visual Studio

## Communication & Tool
GIT, Github, Slack, Notion, Google Sheets

## Distribution
Naver Cloud Platform

## API
**[한국관광공사] https://www.data.go.kr/data/15101578/openapi.do

<br />

## 🗂️ 디렉토리 구조
```
trip=java/  
├── controller/  
│ ├── Checklist
│ ├── Destination  
│ ├── Itinerary 
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── TripRoute  
│ ├── User  
├── dto/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Plan  
│ ├── Planner  
│ ├── Todayplan  
│ ├── Tourist  
│ ├── TripRoute  
│ └── User  
├── entity/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── User   
├── repository/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── User   
├── service/  
│ ├── Checklist  
│ ├── Itinerary  
│ ├── Planner  
│ ├── TodayPlan  
│ ├── Tourist  
│ ├── User   
├── resources/  
│ └── application.properties  
```

<br />

## 📃 API 명세서
<img width="776" alt="API명세서" src="https://github.com/EunnyKoo/tripjava_backend/assets/139302489/724657e0-4282-4f42-b322-10994c5ddfbb">

<br />

## 📋 ERD 다이어그램
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/b9c60088-bdf1-4838-9fe6-beb1ae4edab8)


<br />

# 🖥️ 화면 구성 및 주요 기능
## 메인 페이지
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/59bfe6b8-062f-47f7-9a72-4457ef0ccc15)
<br />

## 여행 일자
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/b7e3eb81-e668-44a9-a94c-f95bb119d4b5)
<br />

## 지도
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/f37a6f54-8ad0-4ba4-88aa-d735d28d2fbf)
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/b0c142d3-0cce-4277-abc7-f436c690785d)

<br />

## 회원가입, 로그인, 회원정보 수정, 회원 탈퇴
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/11ce8325-6c14-43d2-9563-b4337a0d4512)
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/1038e1d8-00ff-462b-bd7e-b807a3306bb0)

<br />

## 마이페이지
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/5b966f04-d441-4eac-b36d-d839695040b1)

<br />

## 여행플래너
![image](https://github.com/EunnyKoo/tripjava_backend/assets/139302489/4671d5d9-82b4-437e-875e-42c85c26ea80)

<br />
