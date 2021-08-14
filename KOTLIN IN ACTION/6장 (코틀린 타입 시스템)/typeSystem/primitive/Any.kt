package typeSystem.primitive

// 코틀린에서는 Any 타입의 모든 널이 될 수 없는 타입의 조상
// Int 등의 원시 타입을 포함한 모든 타입의 조상 타입
// Any 타입은 java.lang.Object에 대응하므로, Object를 자바메소드에서 인자로 받거나 변환하면
// 코틀린에서는 Any로 그 타입을 취급한다.

// toString, equals, hashCode 는 Any에 정의된 메소드를 상속한 것이다.
// java.lang.Object의 다른 메소드는 Any에서 사용할 수 없으므로, 호출하고 싶다면 java.lang.Object 타입으로 값을 캐스트해야 한다.
fun main() {

    val answer: Any = 42 // Any가 참조타입이기 때문에 42가 박싱된다
}