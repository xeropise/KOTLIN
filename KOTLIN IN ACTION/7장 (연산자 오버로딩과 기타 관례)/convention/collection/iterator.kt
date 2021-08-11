package convention.collection

import java.time.LocalDate

// 코틀린의 for 루프는 범위 검사와 똑같이 in 연산자를 사용하지만, 이 경우 in의 의미는 다르다.

/*
    for (x in list) { ... }
*/

// 위와 같은 문장은 list.iterator() 를 호출해서 이터레이터를 얻고, 이터레이터에 대해 hasNext와 next 호출을 반복하는 식으로 변환된다.

// iterator 메소들르 확장 함수로 정의할 수 있고, 이런 성질들로 인해 일반 자바 문자열에 대한 for 루프가 가능하다.

// 코틀린 표준 라이브러리는 String의 상위 클래스인 CharSequence에 대한 iterator 확장 함수를 제공한다.

// operator fun CharSequence.iterator(): CharIterator

// for (c in "abc") { }

// 클래스 안에 직접 iterator 메소드를 구현할 수도 있다.

// 날짜 범위에 대한 이터레이터 구현하기
operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
        object : Iterator<LocalDate> {      // 이 객체는 LocalDate 원소에 대한 iterator 를 구현한다.

            var current = start

            override fun hasNext() =
                current <= endInclusive     // compareTo 관례를 사용해 날짜를 비교한다.

            override fun next() = current.apply {       // 현재 날짜를 저장한 다음에 날짜를 변경한다. 그 후 저장해둔 날짜를 반환한다.
                current = plusDays(1)          // 현재 날짜를 1일 뒤로 변경 한다.
            }
}

fun main() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) { println(dayOff) }
}