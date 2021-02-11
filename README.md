# Pharmacy Kiosk Project
## 프로젝트 제작 배경
> 전 세계적으로 COVID-19 바이러스가 확산되고 있다.이에 따라 한국은 사회적 거리두기(전염병의 확산을 막기 위해 사람들 간의 거리를 유지하는 캠페인)라는 제도도 시행되어, 
 사람들과 직접적으로 대면하는 것을 최소화 하고 있다. 그로 인해 직접적인 접촉을 하지 않는 키오스크(kiosk; 무인정보단말기)의중요성이 늘어나고 있다. 
> 
> 약국에 키오스크를 도입하게 되면 약국을 이용할 손님들의 접수시간을 단축시킬 뿐만 아니라 처방전의 QR코드를 인식하여 약사에게 출력함으로써 해당 처방전의 위치를 알려줘 제조하는 시간도 단축시킬 수 있다. 또 재고 현황을 데이터화 하여 재고 파악 시 약사에게 편리함을 줄 수 있다. 이러한 안전과 편의성들을 고려하여 키오스크를 이용한 약국 시스템을 제작하였다. 

## 시스템 구성도
<img width="700" height = "370" alt="PK 시스템 구성도" src="https://user-images.githubusercontent.com/78644129/107510816-f1022880-6be7-11eb-90a5-fb30d107a494.PNG">
1. 환자가 키오스크를 통해 처방전 접수를 함<br/>
2. 키오스크는 무선 스캐너에게 스캔신호를 전달함<br/>
3. 환자는 처방전 QR코드를 스캔함<br/>
4. 스캔을 마치면 무선 스캐너는 처방전 정보를 키오스크에게 전달함<br/> 
5. 처방전 정보를 받은 키오스크는 약사컴퓨터에게 정보를 전달함<br/>
6. 약사는 약사컴퓨터에 출력된 정보를 이용하여 약을 제조하고 제조가 완료되면 키오스크에게 제조완료 알림을 줌<br/>
7. 환자는 해당 알림을 보고 약을 수령함<br/>

## 시스템 동작
### 메인 화면
<img width="700" height = "370" alt="PK 메인화면" src="https://user-images.githubusercontent.com/78644129/107513537-b4383080-6beb-11eb-9f9d-ddbe1265f242.PNG">
* 이용하기위한 '입장' 버튼<br/>
* 약품 제조 완료를 알리는 알림창<br/>

### 접수 화면
<img width="700" height = "370" alt="PK 접수화면" src="https://user-images.githubusercontent.com/78644129/107513799-1abd4e80-6bec-11eb-8284-0d8af154b9bf.PNG">
* 약국약 구매를 위한 '약국약 구매' 버튼 클릭시
> <img width="700" height = "370" alt="PK 번호표 출력" src="https://user-images.githubusercontent.com/78644129/107515116-f19dbd80-6bed-11eb-9a93-03c7273e03e4.PNG">
> 순서에 맞게 번호표 출력
* 처방전 접수를 위한 'QR코드 스캔' 버튼

### 호출 화면


## 제작 기간, 본인 구현 부분

