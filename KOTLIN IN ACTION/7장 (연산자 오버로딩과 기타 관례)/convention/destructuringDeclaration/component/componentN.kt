package convention.destructuringDeclaration.component

import convention.arithmeticOperator.Point

// 구조 분해를 사용하면 복합적인 값을 분해해서 여러 다른 변수를 한꺼번에 초기화할 수 있다.

// 내부에서 구조 분해 선언은 다시 관례를 사용한다. 구조 분해 선언의 각 변수를 초기화하기 위해 componentN 이라는 함수를 호출한다.
// 여기서 N은 구조 분해 선언에 있는 변수 위치에 따라 붙는 번호다.

/*
    val (a,b) = p       ->       val a = p.component1()
                                 val b = p.component2()
*/

// data 클래스의 주 생성자에 들어있는 프로퍼티에 대해서는 컴파일러가 자동으로 componentN 함수를 만들어 준다.

/*
    class Point(val x: Int, val y: Int) {
        operator fun component1() = x
        operator fun component2() = y
    }
 */

// 구조 분해 선언 구문을 사용하면 이런 함수가 반환하는 값을 쉽게 풀어서 여러 변수에 넣을 수 있다.

// 구조 분해 선언을 사용해 여러 값 반환하기
data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String) : NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

// 컬렉션에 대해 구조 분해 선언 사용하기
fun splitFilename2(fullName: String) : NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

// 코틀린 표준 라이브러리에서는 맨 앞의 다섯 원소에 대한 componentN 을 제공한다.
// 표준 라이브러리의 Pair 나 Triple 클래스를 사용하면 함수에서 여러 값을 더 간단하게 반환할 수 있다.
// Pair 나 Triple 은 그 안에 담겨있는 원소의 의미를 말해주지 않으므로 경우에 따라 가독성이 떨어질 수 있는 반면,
// 직접 클래스를 작성할 필요가 없으므로 코드는 더 단순해진다.

fun main() {
    val p = Point(10, 20)
    val (x, y) = p

    println(x) // 10
    println(y) // 20

    val (name, ext) = splitFilename("example.kt")
    println(name) // example
    println(ext)  // kt
}