package convention.arithmeticOperator

// 관례(convention) 이란?
// => 어떤 언어 기능과 미리 정해진 이름의 함수를 연결해주는 기법

// 코틀린에서 관례를 사용하는 가장 단순한 예는 산술 연산자
// 자바에서는 원시 타입에 대해서만 산술 연산자를 사용할 수 있고, + 연산자를 사용할 수 있지만, BigInteger에서는 불가.. add 메소드 이용해야함
// 코틀린에서도 그런 일이 가능하다면?

// 이항 산술 연산 오버로딩

// plus 연산자 구하기
// 연산자를 오버로딩하는 함수 앞에는 꼭 operator 가 있어야 한다.
// operator 키워드를 붙여, 어떤 함수가 관례를 따르는 함수임을 명확히 해야 한다.
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

}


// 연산자를 멤버 함수로 만드는 대신, 확장 함수로 정의할 수도 있다.
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}


// 오버로딩 가능한 이항 산술 연산자

/*
    times               => a * b
    div                 => a / b
    mod(1.1부터 rem)     => a % b
    plus                => a + b
    minus               => a - b
 */

// 직접 정의한 함수를 통해 구현하더라도 연산자 우선순위는 언제나 표준 숫자 타입에 대한 연산자 우선순위와 같다.
// a + b * c 라면 곱셈이 항상 먼저 수행

// 연산자를 정의할 때 두 피연산자가 같은 타입일 필요는 없다.
// 교환 법칙은 성립하지 않아 Double * Point 는 성립하지 않으므로, 따로 정의해야 한다.
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

// 연산자 함수의 반환 타입이 꼭 두 피연산자 중 하나와 일치해야만 하는 것은 아니다.
// 결과 타입이 피연산자 타입과 다른 연산자 정의하기
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

// 일반 함수와 마찬가지로 operator 함수도 오버로딩할 수 있다.
// 따라서 이름은 같지만 파라미터 타입이 서로 다른 연산자 함수를 여럿 만들 수 있다.

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1+p2) // + 로 계산하면 plus 함수가 호출된다.

    val p = Point(10, 20)
    println(p * 1.5) // Point(x=15, y=30)

    println('a' * 3)  // aaa
}