package convention.comparison

// 코틀린도 똑같은 Comparable 인터페이스 지원
// Comparable 인터페이스 안에 있는 compareTo 메소드를 호출하느 ㄴ관례를 제공
// 비교 연산자(<, >, <=, >=) 는 compareTo 호출로 컴파일된다.

// compareTo 가 반환하는 값은 Int다.
// p1 < p2 는 p1.compareTo(p2) < 0
// a >= b 는 a.compareTo(b) >= 0

// Comparable의 compareTo 에도 operator 변경자가 붙어있으므로 하위 클래스 오버라이딩 함수에 operator 를 붙일 필요가 없다.

// compareTo 메소드 구현하기
class Person(
    val firstName: String, val lastName: String
) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName) // 인자로 받은 함수를 차례로 호출하면서 값을 비교

        // 첫 번째 비교 함수에 두 객체를 넘겨 두 객체가 같지 않다는 결과 (0이 아닌결과) 가 나오면 그 결과를 즉시 반환
        // 두 객체가 같다는 결과(0) 이 나오면 두 번쨰 비교 함수를 통해 두 객체를 비교
    }
}

fun main() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Jonhson")

    println ( p1 < p2) // false
}