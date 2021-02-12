# Pharmacy Kiosk Project(졸업작품)
## 제작 인원, 기간
* 3인
* 20.01 ~ 20.06

## 담당 부분
* 전체 GUI 제작
* 키오스크와 약사  소켓 프로그래밍


## 프로젝트 제작 배경
> 전 세계적으로 COVID-19 바이러스가 확산되고 있다.이에 따라 한국은 사회적 거리두기(전염병의 확산을 막기 위해 사람들 간의 거리를 유지하는 캠페인)라는 제도도 시행되어, 
 사람들과 직접적으로 대면하는 것을 최소화 하고 있다. 그로 인해 직접적인 접촉을 하지 않는 키오스크(kiosk; 무인정보단말기)의중요성이 늘어나고 있다. 
> 
> 약국에 키오스크를 도입하게 되면 약국을 이용할 손님들의 접수시간을 단축시킬 뿐만 아니라 처방전의 QR코드를 인식하여 약사에게 출력함으로써 해당 처방전의 위치를 알려줘 제조하는 시간도 단축시킬 수 있다. 또 재고 현황을 데이터화 하여 재고 파악 시 약사에게 편리함을 줄 수 있다. 이러한 안전과 편의성들을 고려하여 키오스크를 이용한 약국 시스템을 제작하였다. 

## 시스템 구성도
 <img width="700" height = "370" alt="PK 시스템 구성도" src="https://user-images.githubusercontent.com/78644129/107510816-f1022880-6be7-11eb-90a5-fb30d107a494.PNG"><br/>
 1. 환자가 키오스크를 통해 처방전 접수를 함<br/>
 2. 키오스크는 무선 스캐너에게 스캔신호를 전달함<br/>
 3. 환자는 처방전 QR코드를 스캔함<br/>
 4. 스캔을 마치면 무선 스캐너는 처방전 정보를 키오스크에게 전달함<br/> 
 5. 처방전 정보를 받은 키오스크는 약사컴퓨터에게 정보를 전달함<br/>
 6. 약사는 약사컴퓨터에 출력된 정보를 이용하여 약을 제조하고 제조가 완료되면 키오스크에게 제조완료 알림을 줌<br/>
 7. 환자는 해당 알림을 보고 약을 수령함<br/>

## 실행 동영상
### 약국 키오스크 시스템 실행 동영상
[![영상](http://img.youtube.com/vi/ei1s2swjzcE/0.jpg)](https://www.youtube.com/ei1s2swjzcE?t=0s) 

[![IU(아이유) _ Into the I-LAND](http://img.youtube.com/vi/QYNwbZHmh8g/0.jpg)](https://youtu.be/QYNwbZHmh8g?t=0s) 
### QR 코드 스캔 영상
[![영상](https://img.youtube.com/vi/-LRUgVkjgvA/0.jpg)](https://www.youtube.com/-LRUgVkjgvA) 
 
## 시스템 동작
### 키오스크
#### 1. 키오스크 메인 화면
 <img width="700" height = "370" alt="PK 메인화면" src="https://user-images.githubusercontent.com/78644129/107513537-b4383080-6beb-11eb-9f9d-ddbe1265f242.PNG"><br/>
 * 이용하기위한 '입장' 버튼<br/>
 * 약품 제조 완료를 알리는 알림창<br/>

#### 2. 접수 화면
<img width="700" height = "370" alt="PK 접수화면" src="https://user-images.githubusercontent.com/78644129/107513799-1abd4e80-6bec-11eb-8284-0d8af154b9bf.PNG"><br/>

#### 2-1. '약국약 구매' 버튼 클릭시<br/>
 <img width="700" height = "370" alt="PK 번호표 출력" src="https://user-images.githubusercontent.com/78644129/107515116-f19dbd80-6bed-11eb-9a93-03c7273e03e4.PNG"><br/>
 * 순서에 맞게 번호표 출력<br/>
 
#### 2-2. 'QR코드 스캔' 버튼 클릭시<br/>
<img width="700" height = "370" alt="PK 스캔화면" src="https://user-images.githubusercontent.com/78644129/107605676-37eb2f00-6c77-11eb-95bb-50a452dd29cf.PNG"><br/>
* 스캔 버튼을 클릭하면 스캐너가 활성 되어 QR코드를 스캔함
* 스캔을 할 수 있는 시간은 30초
  * 30초안에 스캔에 성공 -> 번호표 출력 패널로 이동
  * 실패 -> 메인화면으로 이동
  
#### 2-2-1. 스캔 성공시
<img width="400" height = "250" alt="PK 스캔성공화면" src="https://user-images.githubusercontent.com/78644129/107606139-8b11b180-6c78-11eb-9ff7-55f21bf2f7cb.PNG"><br/>
* 스캔 성공후 순서대로 번호표 출력

#### 3. 호출 화면
<img width="700" height = "370" alt="PK 호출메시지" src="https://user-images.githubusercontent.com/78644129/107606392-45091d80-6c79-11eb-8cf7-2cafb0a7347e.PNG"><br/>
* 키오스크의 호출 메시지 화면
* 약품 제조가 완료됨과 동시에 해당 접수번호 고객의 호출메시지가 출력되어 약품을 받으러 오라는 신호를 보냄
- - - - -
### 약사 화면

#### 1. 약사 메인 화면
<img width="700" height = "370" alt="PK 약사 메인화면" src="https://user-images.githubusercontent.com/78644129/107607394-78997700-6c7c-11eb-87cc-e07197d75a84.PNG"><br/>

#### 2. '시작하기' 버튼 클릭시
<img width="700" height = "370" alt="PK 약사 시작화면" src="https://user-images.githubusercontent.com/78644129/107607798-96b3a700-6c7d-11eb-9afa-91d7eeb27b3c.PNG"><br/>

#### 2-1. '처방전 대기' 버튼 클릭시

#### 2-1-1. 약국약 접수 받을시
<img width="700" height = "370" alt="PK 약국약 접수화면" src="https://user-images.githubusercontent.com/78644129/107608304-f52d5500-6c7e-11eb-9f1d-7b218905dc3e.PNG"><br/>
* 약국약 접수 받은 상태
* 약사는 리스트에서 해당 접수번호 클릭후 확인버튼 눌러 키오스크에 해당 고객을 호출함

#### 2-1-2. 처방전 접수 받을시
<img width="700" height = "370" alt="PK 처방전 약 위치" src="https://user-images.githubusercontent.com/78644129/107608383-2f96f200-6c7f-11eb-951c-8289b837b1f9.PNG"><br/>
* 처방전 정보가 들어오면 약품의 위치가 출력됨

<img width="700" height = "370" alt="PK 제조완료 메시지" src="https://user-images.githubusercontent.com/78644129/107607916-e003f680-6c7d-11eb-8fe2-cbdd5495f219.PNG"><br/>
* 제조 완료 메시지 확인 시 리스트에서 해당 접수번호의 요소가 삭제되고 키오스크에게 완료메시지를 출력함

#### 2-2. '약품상황' 버튼 클릭시
<img width="700" height = "370" alt="PK 약품 상황 화면" src="https://user-images.githubusercontent.com/78644129/107607955-f5792080-6c7d-11eb-956b-f5a016c212ad.PNG">

#### 2-2-1.약품 추가 화면
<img width="700" height = "370" alt="PK 약품 추가 화면" src="https://user-images.githubusercontent.com/78644129/107607966-fdd15b80-6c7d-11eb-87b4-51a8c74ddb05.PNG"><br/>
* 약품 선택후 수량 입력시 약품의 수량 변경 완료

#### 2-2-2. 약품 수량 확인 화면
<img width="700" height = "370" alt="PK 약품 수량 확인 화면" src="https://user-images.githubusercontent.com/78644129/107607986-04f86980-6c7e-11eb-9f62-5e109f12bf5f.PNG"><br/>
* 수량을 확인하고 싶은 약품 선택후 확인 버튼 클릭시 남은 개수가 출력됨

#### 2-2-3. 처방전 화면
<img width="700" height = "370" alt="PK 처방전 조회 화면" src="https://user-images.githubusercontent.com/78644129/107607840-bba81a00-6c7d-11eb-85de-a9af2362844b.PNG"><br/>
* 접수번호 입력후 조회버튼 클릭시 처방전 정보 

## 개선점
* 드라이브스루 형식이 비대면에 더 효과적일듯
* 약의 오남용 문제로 실제 처방전 QR코드를 스캔 못해 직접 만든 QR코드 이용한 점
* 안전성에서는 좋지만 사용자들의 만족도는..?

