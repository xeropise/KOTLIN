package convention.collection

import convention.arithmeticOperator.Point
import java.lang.IndexOutOfBoundsException

// 코틀린에서는 인덱스 연산자가 관례로 컬렉션에 이미 추가되어 있다.

// get 관례 구현하기, map 에 get을 생각해보자.
operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

// x[a,b]  => x.get(a,b)
// 파라미터는 Int 가 아닌 타입도 사용 가능하다.

// set 관례 구현하기
data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

// x[a, b] = c  => x.set(a,b,c)

fun main() {
    val p = Point(10, 20)
    println(p[1])

    var p2 = MutablePoint(10,20)
    p2[1] = 42
    println(p) // MutablePoint(x=10, y=42)
}