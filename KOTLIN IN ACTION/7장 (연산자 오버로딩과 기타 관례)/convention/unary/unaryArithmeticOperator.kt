package convention.unary

import convention.arithmeticOperator.Point
import java.math.BigDecimal

// -a 와 같이 한 값에만 작용하는 연산자를 단항(unary) 연산자라고 부른다.

// 단항 연산자를 오버로딩하는 절차도 이항 연산자와 마찬가지다.
operator fun Point.unaryMinus(): Point {    // 단항 minus(음수) 함수는 파라미터가 없다.
    return Point(-x, -y)  // 각 성분의 음수를 취한 새 Point를 반환
}

// 단항 연산자를 오버로딩 하기 위해 사용하는 함수는 인자를 취하지 않는다.

/*
    unaryPlus               +a
    unaryMinus              -a
    not             =>      !a
    inc                     ++a, a++
    dec                     --a, a--
 */

// 증가 연산자 정의
operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main() {
    val p = Point(10, 20)
    println(-p) // Point(x = -10, y = -20)

    var bd = BigDecimal.ZERO
    println(bd++)  // 0 , 실행 후 증가

    println(++bd)  // 2 , 증가 후 실행
}

