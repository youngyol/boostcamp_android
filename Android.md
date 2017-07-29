# 안드로이드

[참고](https://kairo96.gitbooks.io/android/content/ch2.1.html)

#### View

뷰:  사용자의 눈에 보이는 화면의 구성 요소들

뷰그룹 : 뷰들을 여러개 포함하고 있는 것 

뷰 그룹이 뷰를 상속

<br/><br/>


layout_gravity : 부모 컨테이너의 여유 공간에 뷰가 모두 채워지지 않아 여유 공간 안에서 뷰를 정렬할 때

gravity : 뷰에서 화면에 표시하는 내용물을 정렬할 때 사용

<br/><br/>






#### Task

태스크란 관련된 실행 액티비티들을 순서대로 묶어 관리하는 것
<br/><br/>





#### 안드로이드 구성요소

- Activity  : 사용자 인터페이스 화면을 구성하는 컴포넌트
- Service  : 백그라운드에서 실행되는 컴포넌트. 시각적인 사용자 인터페이스를 가지지 않음
- Broadcast receiver : 배터리 부족, 언어 설정 변경 등의 특정 브로드캐스트를 수신하거나 반응하는 컴포넌트. 시각적인 사용자 인터페이스를 가지지 않음
- Content provider : 애플리케이션 간의 데이터 공유를 위해 표준화된 인터페이스를 제공하는 컴포넌트
<br/><br/>



#### 인텐트

- **명시적 인텐트**는 시작할 구성 요소를 이름으로 지정합니다(완전히 정규화된 클래스 이름). 명시적 인텐트는 일반적으로 본인의 앱 안에서 구성 요소를 시작할 때 씁니다. 시작하고자 하는 액티비티 또는 서비스의 클래스 이름을 알고 있기 때문입니다. 예를 들어, 사용자 작업에 응답하여 새 액티비티를 시작하거나 백그라운드에서 파일을 다운로드하기 위해 서비스를 시작하는 것 등이 여기에 해당됩니다.
- **암시적 인텐트**는 특정 구성 요소의 이름을 대지 않지만, 그 대신 수행할 일반적일 작업을 선언하여 또 다른 앱의 구성 요소가 이를 처리할 수 있도록 해줍니다. 예를 들어, 사용자에게 지도에 있는 한 위치를 표시해주고자 하는 경우, 암시적 인텐트를 사용하여 다른, 해당 기능을 갖춘 앱이 지정된 위치를 지도에 표시하도록 요청할 수 있습니다.
<br/><br/>