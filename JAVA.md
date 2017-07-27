### JAVA



#### 동등성(equals) 동일성(==)

```java
String temp = "hello";

String str = "hello";
String str1 = new String("hello");

System.out.println(str == temp);  // true  
System.out.println(str1 == temp);  // false
```

자바에서는 기본자료형과 참조형이 존재함.

기본자료형 같은 경우에는 실제 값을 저장 하는 반면에 참조형은 실제 객체가 가르키는 주소이다.

**동일성**

 동일하다! 두 개의 오브젝트가 완전히 같을 경우를 의미//  두 변수가 힙 메모리 상에 동일한 주소를 가르키고 있는지를 확인한다. 그래서 같은 내용을 가진 객체라도 힙 메모리 상에 각자 올라가 있는 상태라면 == 연산자 비교시 false 값을 가지게 됩니다.



**동등성**: 동등하다! 두 오브젝트가 같은 정보(내용)를 갖고 있을 경우를 의미합니다. 
[출처](http://blog.naver.com/PostView.nhn?blogId=zxcvb4825&logNo=220826548072&redirect=Dlog&widgetTypeCall=true)





#### String 

![자바 스트링](http://cdn.journaldev.com/wp-content/uploads/2012/11/String-Pool-Java1.png)

```java
public class StringPool {

    /**
     * Java String Pool example
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        
        System.out.println("s1 == s2 :"+(s1==s2));   //true
        System.out.println("s1 == s3 :"+(s1==s3));   //false
    }

}
```

s1은 string constant pool에 객체가 만들어짐, s2은 이 string pool에 존재하는 Cat를 참조함.

s3은 heap 메모리에 개별 객체가 만들어짐





#### String, StringBuffer, StringBuilder의 차이점

   ① String         클래스 : 상수 문자열, 한번 생성한 후 변하지 않는 문자열 용도. // 불가변

   ② StringBuffer  클래스 : 프로그램 내에서 계속 변하는 문자열 용도.

   ③ StringBuilder 클래스 : Java5에 추가된 클래스로 StringBuffer와 기능이 같다.

​    * 차이점 : StringBuffer는 동기화(synchronized)되지만 StringBuilder는 그렇지 않다.

​                즉, StringBuilder는 다중 thread에서는 안전하지 않으므로 동기화가 필요한 경우는

​                StringBuffer를 사용하는 것이 좋다.

​                StringBuilder에서 동기화 하려면 synchronized블록으로 감싸야 한다.



#### 자바 특징

   ① 캡슐화(Encapsulation): 하나의 문제 해결을 위한 data와 method를 한 단위로 묶는 것으로서, 클래스 내부 정의에 대해 외부에서 볼 수 없도록 함이 특징(은닉화)

   ② 추상화(Abstraction)  : 객체(Object)의 자세한 성질을 무시하고(숨기고) 그들의 일반적인 성질을 나타낸다는 것. 일반적으로 클래스는 클래스로 표현할 서브클래스(또는 객체)의 공통적인 성질과 행위를 일반화해 디자인되며 그로부터 생성된 객체는 자신의 고유한 성질을 갖게 됨.

   ③ 다형성(Polymorphism) : 다형성이란 같은 메시지에 대해 클래스에 따라 다른 행위를 하는 특성.

​                            일반적으로 같은 이름을 갖는 method에 대해 인자(Argument) 개수와 Data Type에 따라 수행되는 행위가 달라짐을 의미. 다형성을 통해 사용자는 약속된 인터페이스를 따르는 서로 다른 객체들를 같은 방식으로 사용할 수 있게 됨.

   ④ 상속(inheritance)   : 기존에 있던 클래스(즉, 기존의 클래스로부터 상속받은)를 바탕으로 다른 특성을 추가해 새로운 클래스를 만들 수 있음.

   ⑤ 인스턴스(Instance)  : 인스턴스는 추상화 개념 또는 클래스 객체, 컴퓨터 프로세스 등과 같은 템플릿(무엇인가를 만들 때 안내 역할 하는 데 사용되는 형식, 꼴, 틀 또는 모형 등을 의미)이 실제로 구현된 것





#### OverIoading , Overriding

   ① OverIoading (method 중복정의)

- 기존의 method 인자를 이용하여 하나의 함수에 여러 가지 기능을 만드는 것.오버로딩이란 함수명은 같지만 매개변수의 타입 혹은 개수가 다른 메소드들의 정의로 리턴값만 다른경우 오버로딩이 성립되지 않으며 한 클래스에 여러 개의 메소드를 정의할 수 있다. 



   ② Overriding (method 재정의)

- ​상위 클래스에 있는 method와 똑같은 method를하위 클래스에 다시 만들기.

​        즉 하위 클래스에서 method를 재정의하는 것.

​        주로 생성자 method를 정의할 때 많이 사용.





#### Garbage collection

시스템에서 더 이상 사용하지 않는 동적 할당된 메모리 블럭 혹은 개체를 찾아 자동적으로 다시 사용 가능한 자원으로 회수하는 것을 말한다.	

Young과 Old영역 존재

- Young 영역(Yong Generation 영역): 새롭게 생성한 객체의 대부분이 여기에 위치한다. 대부분의 객체가 금방 접근 불가능 상태가 되기 때문에 매우 많은 객체가 Young 영역에 생성되었다가 사라진다. 이 영역에서 객체가 사라질때 Minor GC가 발생한다고 말한다.
- Old 영역(Old Generation 영역): 접근 불가능 상태로 되지 않아 Young 영역에서 살아남은 객체가 여기로 복사된다. 대부분 Young 영역보다 크게 할당하며, 크기가 큰 만큼 Young 영역보다 GC는 적게 발생한다. 이 영역에서 객체가 사라질 때 Major GC(혹은 Full GC)가 발생한다고 말한다.

![GC 데이터 흐름도](http://d2.naver.com/content/images/2015/06/helloworld-1329-1.png)

[참고](http://d2.naver.com/helloworld/1329)

[더보기](http://itmining.tistory.com/24)





#### 자바 Collection과 Map

- Collection

  - List :  순서가 있는 저장공간
    - LinkedList
    - Stack
    - Vector
    - ArrayList
  - Set : 순서가 없는 저장공간
    - HashSet
    - SortedSet

- Map

  - Hashtable

  - HashMap

  - SortedHash

    ​

[더보기 ](http://withwani.tistory.com/150)



#### 제네릭스(Generics)란?

 클래스 내부에서 사용할 데이터 타입을 나중에 인스턴스를 생성할 때 확정하는 것을 제네릭이라 한다.

```java
class Person<T>{
    public T info;// p1 일시 데이터 타입은 String이된다.(인스턴스 생성시 String 제네릭 생성)
		// p2 일시 데이터 타입은 StringBuilder이 된다.
}
public class GenericDemo {
    public static void main(String[] args) {
        Person<String> p1 = new Person<String>();
        Person<StringBuilder> p2 = new Person<StringBuilder>();
    }
}
```





#### Thread

1. Thread 클래스 상속

```java
public class Test extends Thread {
    int seq;
    public Test(int seq) {
        this.seq = seq;
    }
    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {

        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            Thread t = new Test(i);
            t.start();
        }
        System.out.println("main end.");
    }
}

```

위와 같이 실행시 메인이 먼저 종료 될 수 있다. 

모든 쓰레드가 종료된 후에 main 메소드를 종료시키고 싶은 경우에는 어떻게 해야 할까? = >  *join* 사용하여 해결

```java
public static void main(String[] args) {
    ArrayList<Thread> threads = new ArrayList<Thread>(); //생성되는 쓰레드를 담기 위해서 ArrayList 객체인 threads를 만든 후 쓰레드 생성시 생성된 객체를 threads에 저장한다.
    for(int i=0; i<10; i++) {
        Thread t = new Test(i);
        t.start();
        threads.add(t);
    }

    for(int i=0; i<threads.size(); i++) {
        Thread t = threads.get(i);
        try {
            t.join(); //main 메소드가 종료되기 전에 threads 에 담긴 각각의 thread에 join 메소드를 호출하여 쓰레드가 종료될 때까지 대기하도록 변경하였다.
        }catch(Exception e) {
        }
    }
    System.out.println("main end.");
}
```



1. Runnable

보통 쓰레드 객체를 만들 때 위의 예처럼 Thread를 상속하여 만들기도 하지만 보통 Runnable 인터페이스를 구현하도록 하는 방법을 많이 사용한다.

```java
import java.util.ArrayList;

public class Test implements Runnable {
    int seq;
    public Test(int seq) {
        this.seq = seq;
    }
    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new Test(i));
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }
}
```

Runnable 인터페이스는 run 메소드를 구현하도록 강제한다.

[더보기](https://wikidocs.net/230)





#### final VS  finalize VS  finally

- **final**: 
  -  **변수 선언시**, 선언된 변수는 초기화만 가능하고, 변경 및 새로운 할당 불가능 / 일반적으로 상수 변수 선언시 static과 같이 사용함
  -  **클래스** , 상속 불가 클래스  / final 접근제한자 클래스명 
  -  **메소드**, 상속 받은 클래스에서 오버라이딩을 통해 재정의가 불가능 


- **finalize()**: java garbage collector가 더 이상의 참조가 존재하지 않는 객체를 발견한 순간 호출하는 메서드

- **finally**: 

  - try-catch-finally / \- 예외의 발생여부와 관계없이 실행되어야 하는 코드를 넣는다.
  - try 또는 catch 블럭에서 return문을 만나도 finally 블럭은 수행된다.

   

  [더어어](http://gangzzang.tistory.com/entry/Java-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%ACexception-handling)

  [더보기](http://wjheo.tistory.com/entry/final-finally-finalize-%EC%B0%A8%EC%9D%B4%EC%A0%90)
