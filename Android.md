# 안드로이드

[참고](https://kairo96.gitbooks.io/android/content/ch2.1.html)

#### 안드로이드 생명주기

[참고](https://developer.android.com/guide/components/activities/activity-lifecycle.html)



#### View

뷰:  사용자의 눈에 보이는 화면의 구성 요소들

뷰그룹 : 뷰들을 여러개 포함하고 있는 것 

뷰 그룹이 뷰를 상속

<br/>

- Visible :  This view is visible and it takes up space for layout
- Invisible :  This view is invisible, but it still takes up space for layout purposes.
- Gone  : This view is invisible, and it doesn't take any space for layout purposes.

[참고](https://stackoverflow.com/questions/11556607/android-difference-between-invisible-and-gone)



[view 클릭이벤트](http://jizard.tistory.com/9)

<br/><br/>

####  

layout_gravity : 부모 컨테이너의 여유 공간에 뷰가 모두 채워지지 않아 여유 공간 안에서 뷰를 정렬할 때

gravity : 뷰에서 화면에 표시하는 내용물을 정렬할 때 사용

<br/><br/>





#### Task

태스크란 관련된 실행 액티비티들을 순서대로 묶어 관리하는 것

<br/><br/>



### 안드로이드 구성요소

- Activity  : 사용자 인터페이스 화면을 구성하는 컴포넌트
- Service  : 백그라운드에서 실행되는 컴포넌트. 시각적인 사용자 인터페이스를 가지지 않음
- Broadcast receiver : 배터리 부족, 언어 설정 변경 등의 특정 브로드캐스트를 수신하거나 반응하는 컴포넌트. 시각적인 사용자 인터페이스를 가지지 않음
- Content provider : 애플리케이션 간의 데이터 공유를 위해 표준화된 인터페이스를 제공하는 컴포넌트

<br/><br/>



#### 인텐트

- **명시적 인텐트**는 시작할 구성 요소를 이름으로 지정합니다(완전히 정규화된 클래스 이름). 명시적 인텐트는 일반적으로 본인의 앱 안에서 구성 요소를 시작할 때 씁니다. 시작하고자 하는 액티비티 또는 서비스의 클래스 이름을 알고 있기 때문입니다. 예를 들어, 사용자 작업에 응답하여 새 액티비티를 시작하거나 백그라운드에서 파일을 다운로드하기 위해 서비스를 시작하는 것 등이 여기에 해당됩니다.
- **암시적 인텐트**는 특정 구성 요소의 이름을 대지 않지만, 그 대신 수행할 일반적일 작업을 선언하여 또 다른 앱의 구성 요소가 이를 처리할 수 있도록 해줍니다. 예를 들어, 사용자에게 지도에 있는 한 위치를 표시해주고자 하는 경우, 암시적 인텐트를 사용하여 다른, 해당 기능을 갖춘 앱이 지정된 위치를 지도에 표시하도록 요청할 수 있습니다.

<br/><br/>



#### Thread

- UI Thread

사용자 인터페이스 조작 작업은 모두 UI 스레드에서 해야만 합니다. 결론적으로, Android의 단일 스레드 모델에는 두 가지 단순한 규칙이 있습니다.

1. UI 스레드를 차단하지 마세요.
2. Ui 스레드 외부에서 Android UI 도구 키트에 액세스하지 마세요

- worker thread 와 ui thread 차이 

The Ui thread is the thread that makes any changes required for the ui.

A worker thread is just another thread where you can do processing that you dont want to interupt any changes happening on the ui thread



worker thread가 UI 에 직접 접근 하면 안됨. ->  작업후 결과를 UI에 반영(즉 UI 쓰레드와 통신)해야 한다면 Handler 등을 이용해야 한다.

<br/><br/>



#### SharedPreference

```java
// 값을 꺼낼 때
/*
 SharedPreferences 인스턴스의 getInt(), getString() 메서드를 사용하여 데이터를 불러옵니다. 데이터를 불러오는 메서드에는 총 두 개의 인자를 넣어주며, 첫 번째에는 불러올 데이터의 키(Key) 값, 두 번째에는 해당 키에 해당하는 값이 없을 경우 반환할 값을 넣어줍니다.
*/
@Override
protected void onCreate(Bundle savedInstanceState) {        			  
  	super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
	SharedPreferences sf = getSharedPreferences(sfName, 0);        // 지난번 저장해놨던 사용자 입력값을 꺼내서 보여주기
    String tmp = sf.getString("count","0"); // 키값으로 꺼냄
}

// 값을 저장할 때
/*
SharedPreferences에 데이터를 기록하려면 SharedPreferences.Editor 인스턴스를 받아야 합니다. Editor 인스턴스를 받은 후에는 저장하고 싶은 데이터의 형태에 따라 putInt(KEY, VALUE), putFloat(KEY, VALUE), putString(KEY, VALUE) 등의 메서드를 사용하여 데이터를 저장합니다. 데이터 기록을 마친 후에는 commit() 메서드를 호출해야만 변경 사항이 저장됩니다.
*/
@Override
protected void onStop() {
    super.onStop();
    // Activity 가 종료되기 전에 저장한다
    // SharedPreferences 에 설정값(특별히 기억해야할 사용자 값)을 저장하기
    SharedPreferences sf = getSharedPreferences(sfName, 0);
    SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
    String tmp = result.getText().toString();
    editor.putString("count", tmp); // 입력
    editor.commit(); // 파일에 최종 반영함
    Toast.makeText(this, "saved " + tmp,Toast.LENGTH_LONG).show();
}
```

[참고](http://j07051.tistory.com/entry/SharedPreferences)

<br/><br/>





#### Bundle





<br/><br/>



#### Content provider

- content provider :  앱내의 데이터를 외부 앱에 공개하는 목적으로 사용, 여기서 데이터라함은 DB,파일, 메모리 등이 될 수 있다.

  안드로이드의 프로바이더를 포함한 모든 컴포넌트를 사용하기 위해서는 AndroidManifest.xml에 컴포넌트를 등록해줘야함. 

  프로바이더는 다른 컴포넌트와는 다리 외부에서 인텐트를 통해 접근하지 않고 별도의 Uri사용

  ```xml
  <application>

    ...
    
    <provider android:name = ".StudentsProviders"
              android:authorities ="com.siperdroid.StudentsProvider"
              android:exported="true"/>  <!-- false가 디폴트, false면 외부 앱에서 접근 못함 -->
    
    
  </application>
  ```

  ​

- content resolver : 외부 앱에서 프로바이더를 사용하기 위해 사용


- content observer : 리졸버 앱에서 등록, 프로바이더는 데이터 변경 시 등록된 콘텐트 관찰자에게 알려준다. 

#### Content Resolver 이용하여 앨범에 있는 이미지 파일 읽기

```java
                String[] projection = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID };
                Cursor imageCursor =managedQuery(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, // 이미지 컨텐트 테이블
                            projection, // DATA, _ID를 출력
                            null,       // 모든 개체 출력
                            null,
                            null);      // 정렬 안 함


			   String result =" ";
                String last =" ";
                int dataColumnIndex = imageCursor.getColumnIndex(projection[0]);
                int idColumnIndex = imageCursor.getColumnIndex(projection[1]);
                if (imageCursor == null) {
                    // Error 발생
                    // 적절하게 handling 해주세요
                } else if (imageCursor.moveToFirst()) {
                    do {
                        String filePath = imageCursor.getString(dataColumnIndex);
                        String imageId = imageCursor.getString(idColumnIndex);
                        result = result + filePath + "\n";
                        last = filePath;

                    } while(imageCursor.moveToNext());
                } else {
                    // imageCursor가 비었습니다.
                }

                txt.setText(result);
                File imgFile = new  File(last);


                Glide.with(ctx)
                        .load(imgFile)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imgV);
```





최신순으로 썸네일 가져오기(썸네일의 Image_ID와 원본 Image_ID는 같으므로 이미지 아이디를 통해 원본을 가져올 수 있다)

```java
   String[] projection = {MediaStore.Images.Thumbnails.DATA,  MediaStore.Images.ImageColumns.DATE_TAKEN};
   String orderBy = MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC";

   Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
   ContentResolver cr = getContentResolver();
   Cursor cur = cr.query(images,
            projection, // Which columns to return
            "",         // Which rows to return (all rows)
            null,       // Selection arguments (none)
            orderBy      // Ordering
    );
```



- managedQuery() : **managedQuery() = ContentResolver.query() + startManagingCursor( Cursor )** 입니다.
- query() : 



managedQuery()  vs query() ](http://aroundck.tistory.com/126)





#### Image

- 이미지 비율 유지 하기 

  ```xml
      <uk.co.senab.photoview.PhotoView
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:scaleType="fitXY"
          android:adjustViewBounds="true"
          android:layout_centerInParent="true"
          android:id="@+id/detailImgID"/>
  ```

  xml에서 adjustViewBounds 속성을 true로 주면 비율에 맞게 확대되어서 나옴.





<br/><br/>

#### DDD(Domain-Driven Design)

 aggregate roots are the only objects your client code loads from the repository.
