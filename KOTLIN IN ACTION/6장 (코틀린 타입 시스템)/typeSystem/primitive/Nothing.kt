package typeSystem.primitive

// 무한 루프를 도는 함수
// 테스트 라이브러리

// 함수가 정상적으로 끝나지 않는다는 사실을 알아, 그런 경우를 표현하기 위해
// 코틀린에는 "Nothing" 이라는 특별한 반환 타입이 있음

fun fail(message: String) : Nothing {
    throw IllegalStateException(message)
}

fun main() {
    fail("Error occurred")  // java.lang.IllegalStateException: Error occurred

}

// Nothing 타입은 아무 값도 포함하지 않는다.
// Nothing은 함수의 반환 타입이나 반환 타입으로 쓰일 타입 파라미터로만 쓸 수 있다.

// 그 외 다른 용도로 사용하는 경우, 변수를 선언하더라도 값을 저장할 수 없으므로 아무 의미도 없다.

// Nothing 을 반환하는 함수를 엘비스 연산자의 우항에 사용해서 전제 조건을(precondition) 을 검사할 수 있다.
// val address = company.address ?: fail ("No address")
// println(address.city)

// 컴파일러는 Nothing이 반환 타입인 함수가 결코 정상 종료되지 않음을 알고, 그 함수를 호출하는 코드를 분석할 때 사용
// 컴파일러가 company.address 가 널인 경우 엘비스 연산자의 우항에서 예외가 발생한다는 사실을 파악하고 address의 값이 널이 아님을 추론할 수 있다.