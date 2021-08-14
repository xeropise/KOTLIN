// 코틀린의 컬렉션
// 컬렉션 안의 데이터에 접근하는 인터페이스와 컬렉션 안의 데이터를 변경하는 인터페이스를 분리

// kotlin.collections.Collection 에는 원소를 추가하거나 제거하는 메소드가 없다.
// kotlin.collections.MutableCollection 를 사용하여, 컬렉션의 데이터를 수정하자.

// 이렇게 구별한 이유는 프로그램에서 데이터에 어떤 일이 벌어지는지 더 쉽게 파악하기 위함임

// 읽기 전용과 변경 가능한 컬렉션 인터페이스
fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main() {
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)

    copyElements(source, target)

    println(target) // [1, 3, 5, 7]

    // 선언된 타입이 읽기 전용인데 변경 가능한 컬렉션을 넘길 수 없다. 넘기는 경우 컴파일 오류가 난다.
    //copyElements(target, source)

    // 읽기 전용 컬렉션이 항상 스레드 안전하지는 않다.
    // 같은 컬렉션 객체에 대해서 다른 타입의 참조(읽기 전용, 변경 가능)를 할수 있기 때문이다.
}

// 컬렉션 타입
/*
    List               listOf                   mutableListOf, arrayListOf
    Set         =>     setOf         =>         multableSetOf, hashSetOf, linkedSetOf, sortedSetof
    Map     (읽기전용)   mapOf     (변경 가능)     multableMapOf, hashMapOf, linkedMapOf, sortedMapOf

 */

// 컬렉션을 변경하는 자마 메소드에 읽기 전용 Collection을 넘겨도 코틀린 컴파일러가 이를 막을 수 없다.