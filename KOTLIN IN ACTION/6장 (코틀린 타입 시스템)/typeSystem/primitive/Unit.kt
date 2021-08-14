package typeSystem.primitive

// 코틀린의 Unit 타입은 자바의 void 타입과 같은 기능을 한다.

fun f(): Unit { }

fun f2() {   //반환 타입을 명시하지 않음

}

// Unit과 자바 void 의 차이점

/*
    1. Unit은 모든 기능을 갖는 일반적인 타입이며, void 와 달리 Unit을 타입인자로 쓸 수 있다.
    2. Unit 타입에 속한 값은 단 하나뿐이며, 그 이름도 Unit 이다.
    3. Unit 타입의 함수는 Unit 값을 묵시적으로 반환하며, 이 두 특성은 제네릭 파라미터를 반환하는 함수를 오버라이드하면서 반환 타입으로 Unit을 쓸때 유리하다.

 */

interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {    // Unit을 반환하지만, 타입을 지정할 필요는 없다.
    override fun process() {        // 컴파일러가 묵시적으로 return Unit을 넣어 준다.
        // 업무 처리 코드    return을 명시할 필요가 없다.
    }
}