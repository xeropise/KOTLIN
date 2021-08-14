package typeSystem.`null`

// null이 될 수 있는 수신 객체에 대해, 확장 함수 호출하기
fun verifyUserInput (input: String?) {
    if (input.isNullOrBlank()) {        // 안전한 호출을 하지 않아도 된다.
        println("Please fill in the required fields")
    }
}

fun String?.isNullOrBlank (): Boolean = // 널이 될 수 있는 String의 확장
    this == null || this.isBlank()  // 두 번째 "this" 에는 스마트 캐스트가 적용된다.

fun main() {

    verifyUserInput(" ")
    verifyUserInput(null)  // <-- isNullOrBlank에 null 을 수신 객체로 전달해도 아무런 예외가 발생하지 않는다.
}