package convention.delegatedProperty

// 코틀린이 제공하는 관례에 의존하는 특성 중에 독특하면서 강력한 기능
//  위임 프로퍼티(delegated property)

// 위임 프로퍼티를 사용하면 값을 뒷받침하는 필드에 단순히 저장하는 것보다
// 더 복잡한 방식으로 작동하는 프로퍼티를 쉽게 구현할 수 있다.

// 접근자 로직을 매번 재구현할 필요도 없다.
// 프로퍼티는 위임을 사용해 자신의 값을 필드가 아니라 데이터베이스 테이블이나 브라우저 세션, 맵 등에 저장할 수 있다.

// 위임이란?
// 객체가 직접 작업을 수행하지 않고 다른 도우미 객체가 그 작업을 처리하게 맡기는 디자인 패턴
// 이때 작업을 처리하는 도우미 객체를 위임 객체(delegate) 라고 부른다.

// 일반적인 문법은 다음과 같다.

/*
    class Foo {
        var p: Type by Delegate()
    }
 */

// p 프로퍼티는 접근자 로직을 다른 객체에게 위임한다.
// Delegate 클래스의 인스턴스를 위임 객체로 사용한다.
// by 뒤에 있는 식을 계산해서 위임에 쓰일 객체를 얻는다.
// 프로퍼티 위임 객체가 따라야 하는 관례를 따르는 모든 객체를 위임에 사용할 수 있다.

// 컴파일러는 숨겨진 도우미 프로퍼티를 만들고, 그 프로퍼티를 위임 객체의 인스턴스로 초기화한다.

/*
    class Foo {
        private val delegate = Delegate() // 컴파일러가 생성한 도우미 프로퍼티다.
        var p: Type // "p" 프로퍼티를 위해 컴파일러가 생성한 접근자는 "delegate"의 getValue와 setValue 메소드를 호출한다.
        set(value: Type) = delegate.setValue(..., value)
        get() = delegate.getValue(...
    }
 */

/*
    class Delegate {
        operator fun getValue(...) { ... }
        operator fun setValue(..., value: Type) { ... }
    }

    class Foo {
        var p: Type by Delegate()
    }
 */

fun main() {
    // val foo = Foo()
    // val oldValue = foo.p   // foo.p 프로퍼티 호출은 내부에서 delegate.getValue() 을 호출한다.
    // foo.p = newValue       // 내부에서 delegate.setValue(..., newValue) 를 호출한다.
}