package generics

import java.lang.Appendable

// 제네릭스를 사용하면 타입 파라미터(type parameter)를 받는 타입을 정의할 수 있다.
val authors = listOf("Dmitry", "Svetlana")

val readers: MutableList<String> = mutableListOf()
// val readers = mutableListOf<String>()


/*
    제네릭 함수와 프로퍼티
 */

// 리스트를 다루는 함수를 작성다면? 특정 타입을 저장하는 리스트 뿐만 아니라,
// 모든 리스트(제네릭 리스트)를 다룰 수 있는 함수를 원할 것이다. 이럴 때 제네릭 함수를 작성해야 한다.

// 제네릭 함수를 호출할 때는 반드시 구체적 타입으로 타입 인자를 넘겨야 한다.

// fun <T> List<T>.slice(indices: IntRange): List<T>

// 함수의 타입 파라미터가 T가 수신 객체와 반환 타입에 쓰인다.
// 함수를 구체적인 리스트에 대해 호출할 때 타입 인자를 명시적으로 지정할 수 있다.
// 실제로는 대부분 컴파일러가 타입 인자를 추론할 수 있으므로 그럴 필요가 없다.


// 확장 프로퍼티만 제네릭하게 만들 수 있고, 일반 프로퍼티는 타입 파라미터를 가질 수 없다.
// val <T> x: T = something() [ 오류 발생 ]

/*
    제네릭 클래스 선언
 */

// 자바와 마찬가지로 코틀린에서도 타입 파라미터를 넣은 꺽쇠 기호(<>)를 클래스 혹은 인터페이스 이름 뒤에 붙이면,
// 제네릭하게 만들 수 있다.
/*
 inteface List<T> { <--- List 인터페이스에 T라는 타입 파라미터를 정의한다.
    operator fun get(index: Int): T  <--- 인터페이스 안에서 T를 일반 타입처럼 사용할 수 있다.
    ...
 }
*/

// 제네릭 클래스를 확장하는 클래스를 정의하려면 기반 타입의 제네릭 파라미터에 대해 타입 인자를 지정해야 한다.
// 구체적인 타입을 넘길 수도 있고, 타입 파라미터로 받은 타입을 넘길 수도 있다.

/*
    class StringList: List<String> {
        override fun get(index: Int): String = ...
    }

    class ArrayList<T> : List<T> {
        override fun get(index: Int): T = ...
    }
*/

// 클래스가 자기 자신을 타입 인자로 참조할 수도 있다.
// Comparable 인터페이스를 구현하는 클래스가 보통 이런 패턴이다.

/*
    interface Comparable<T> {
        fun compareTo(other: T) : Int
    }

    class String : Comparable<String> {
        override fun compareTo(other: String): Int = ...
    }
 */

/*
    타입 파라미터 제약 (type parameter constraint)
 */

// 클래스나 함수에 사용할 수 있는 타입 인자를 제약하는 기능
// List에 sum 기능을 구현한다고 하면, 타입 파라미터로 숫자 타입만을 허용하게 정의할 수 있다.

// 어떤 타입을 제네릭 타입의 타입 파라미터에 대한 상한(upper bound)로 지정하면 그 제네릭 타입을
// 인스턴스화할 때 사용하는 타입 인자는 반드시 그 상한 타입이거나 그 상한 타입의 하위 타입이어야 한다.
// 제약을 가하려면 타입 파라미터 이름 뒤에 콜론(:)을 표시하고, 그 뒤에 상한 타입을 적으면 된다.

/*
    타입 파라미터 : 상한
    fun <T : Number> List<T>.sum() : T
*/

// 타입 파라미터에 T에 대한 상한을 정하고 나면 T 타입의 값을 그 상한 타입의 값으로 취급할 수 있다.

/*
    fun <T: Number> oneHalf(value: T) : Double {
        return value.toDouble() / 2.0
    }

    println(oneHalf(3))  // 1.5
 */


// 두 파라미터 사이에서 더 큰 값을 찾는 제네릭 함수를 작성해 보자.
// 서로를 비교할 수 있어야 최댓값을 찾을 수 있으므로 함수 시그니처에도 두 인자를 서로 비교할 수 있어야 한다는 사실을 지정해야 한다.

fun <T: Comparable<T>> max(first: T, second: T) : T {
    return if (first > second) first else second  // T가 Comparable 로 추론 되므로, > 가 compareTo 로 동작하였다.
}

// 아주 드물지만, 타입 파라미터에 대해 둘 이상의 제약을 가해야 하는 경우도 있다. 그런 경우, 약간 다른 구문을 사용한다.

fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable { // 타입 파라미터에 제약 목록이다.
                                             // 타입 인자가 CharSequence 와 Appendable 인터페이스를 반드시 구현해야 한다는 사실을 표현한다.
        if (!seq.endsWith('.')) {       // CharSequence 인터페이스의 확장 함수를 호출한다.
            seq.append('.')                  // Appendable 인터페이스의 메소드를 호출한다.
        }
    }

fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2)) // 타입 인자를 명시적으로 지정

    println(letters.slice(10..13)) // 컴파일러가 T가 Char라는 사실을 추론한다.

    readers.filter { it !in authors }

    println(max("kotlin", "java")) // kotlin

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}


