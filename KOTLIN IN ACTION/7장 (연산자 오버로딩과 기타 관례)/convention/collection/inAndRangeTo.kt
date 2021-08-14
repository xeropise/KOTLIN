package convention.collection

import convention.arithmeticOperator.Point
import java.time.LocalDate

// in 은 객체가 컬렉션에 들어있느지 검사한다.
// in 연산자와 대응하는 함수는 contains 이다.

// a in c => c.contains(a)

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x && // 범위를 만들고 'x' 좌표가 그 범위 안에 있는지 검사
           p.y in upperLeft.y until lowerRight.y    // until 함수를 사용해 열린 범위를 만든다. ( y-1 까지 검사 )  1 until 20 은 1 ~ 19 이다.
}

// rangeTo 로 범위를 만들려면 .. 구문을 사용해야 한다.
// 1..10 은 1부터 10까지 모든수가 들어있는 범위를 가리킨다.
// .. 연산자는 rangeTo 함수를 간략하게 표현하는 방법이다.

// start..end => start.rangeTo(end)
// rangeTo 함수는 범위를 반환하고, 이 연산자를 아무 클래스에나 정의할 수 있다.
// 어떤 클래스가 Comparable 인터페이스를 구현하면 rangeTo 를 정의할 필요가 없다.
// 코틀린 표준 라이브러리르 통해 비교 가능한 원소로 이뤄진 범위를 쉽게 만들 수 있다.
// 코틀린 표준 라이브러리에는 모든 Comparable 객체에 대해 적용 가능한 rangeTo 함수가 들어 있다.

/*
    operator fun <T: Comparable<T>> T.rangeTo(that: T): CloseRange<T>
 */

// in 과 함께 사용하여 범위 값을 기준으로 값이 존재하는지 검사할 수 있다.

// rangeTo 함수는 LocalDate의 멤버는 아니고, Comparable 에 대한 확장 함수다.

// rangeTo 연산자는 다른 산술 연산자보다 우선순위가 낮다. 혼동을 피하기 위해 괄호로 인자를 감싸주면 좋다.

/*
    val n = 9
    println(0..(n + 1))   // 0..n + 1 이라고 써도 되지만, 괄호를 써서 의미가 분명해 졌다.
 */

// 범위의 메소드를 호출하려면 범위를 괄호로 둘러싸야 한다.
/*
    (0..n).forEach { print(it) }   // 0123456789
 */

fun main() {
    val rect = Rectangle(Point(10, 20), Point(50, 50))

    println(Point(20, 30) in rect) // true

    println(Point(5, 5) in rect) // false

    // 날짜의 범위 다루기
    val now = LocalDate.now()

    val vacation = now..now.plusDays(10) // 오늘부터 시작해 10일짜리 범위를 만든다.
                    // now.rangeTo(now.plusDays(10))

    println(now.plusWeeks(1) in vacation) // 특정 날짜가 날짜 범위 안에 들어가는지 검사한다.
}
