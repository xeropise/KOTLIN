package typeSystem

// 널 아님 단언을 사용해 널이 될 수 있는 프로퍼티 접근하기
class MyService {
    fun perfromAction() : String = "foo"
}

// 보기가 매우 나쁘다
class MyTest {
    // private var myService: MyService? = null // null로 초기화하기 위해 널이 될 수 있는 타입인 프로퍼티 선언

    // 나중에 초기화하므로 항상 var 여야 한다. 생성자 밖에서 초기화해야 한다.
    // val 프로퍼티는 final 필드로 컴파일되고, 생성자 안에서 반드시 초기화해야 한다.
    // 프로퍼티를 초기화기전에 접근하면 lateinit property myService has not been initilizaed 라는 예외가 발생한다
    private lateinit var myService: MyService // 초기화하지 않고, 널이 될 수 없는 프로퍼티를 선언

    /*
    @Before fun setUp() {
        myService = MyService() // setUp 메소드 안에서 진짜 초기값을 지정
    }

    @Teset fun testAction() {
        Assert.assertEquals("foo", myService!!.perfromAction())  // 반드시 널 가능성에 신경 써야 한다. !!나 ?을 꼭 써야 한다.
        Assert.assertEquals("foo", myService.perfromAction()) // 나중에 초기화하는 키워드를 사용하여, 널 검사를 수행하지 않고, 프로퍼티를 사용
    }
     */
}