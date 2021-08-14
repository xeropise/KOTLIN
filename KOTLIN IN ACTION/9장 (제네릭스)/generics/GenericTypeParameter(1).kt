package generics

/*
    타입 파라미터를 널이 될 수 없는 타입으로 한정
 */

// 제네릭 클래스나 함수를 정의하고, 그 타입을 인스턴스화할 때는 널이 될 수 있는 타입을
// 포함하는 어떤 타입으로 타입 인자를 지정해도 타입 파라미터를 치환할 수 있다.

// 아무런 상한을 정하지 않은 타입 파라미터는 결과적으로 Any? 를 상한으로 정한 파라미터와 같다.
class Processor<T> {
    fun process(value: T) {
        value?.hashCode() // value 가 널이 될 수 있으므로, 안전한 호출을 사용해야 한다.
    }
}

// 항상 널이 될 수 없는 타입만 인자로 받게 만들려면 타입 파라미터에 제약을 가해야 한다.
// 널 가능성을 제외한 아무런 제약도 필요 없다면 Any? 대신 Any를 상한으로 사용해야 한다.
class ProcessorNotNull<T : Any> {   // 널이 될 수 없는 타입 상한을 지정
    fun process(value: T) {
        value.hashCode()
    }
}




fun main() {
    val nullableStringProcessor = Processor<String?>() // 널이 될 수 있는 String? 이 T를 대신한다.
    nullableStringProcessor.process(null)

    // 컴파일러는 타입 인자인 String? 가 Any의 자손 타입이 아니므로 ProcessorNotNull<String?> 같은 코드를 거부한다.
    // val cantnotNullableStringProcessor = ProcessorNotNull<String?>()  오류가 발생.. String? 은 Any의 자손 타입이 아니다.
}