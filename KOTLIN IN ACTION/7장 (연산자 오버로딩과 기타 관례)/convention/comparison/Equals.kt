package convention.comparison

// 코틀린이 == 연산자를 equals 메소드 호출로 컴파일

// != 연산자도 equals 를 사용, 결과를 뒤집은 값

// ==, != 는 내부에서 인자가 널인지 검사하므로 다른 연산과 달리 널이 될 수 있는 값에도 적용 가능

// Point 클래스의 경우, 앞에서 data 키워드를 사용했으므로, equals를 재정의 해주지만, 직접 구현한다면 다음과 비슷하다.

// === 를 오버로딩할 수는 없다. 자바의 주소 값 비교인 == 를 대신해서 사용할 수 있다.

// equals 함수에는 override가 붙어있다. 다른 연산자 오버로딩 관례와 달리 equals는 Any에 정의된 메소드이므로 override 가 필요하다.

// Any의 equals 에는 operator가 붙어있지만 그 메소드를 오버라이드하는 메소드(하위 클래스) 앞에는 operator 변경자를 붙이지 않아도 된다.
// 자동으로 상위 클래스의 operator 지정이 적용된다.

// Any에서 상속받은 equals가 확장 함수보다 우선순위가 높기 때문에, equals 를 확장 함수로 정의할 수는 없다는 사실에 유의하자.

class Point(val x: Int, val y: Int) {
    override fun equals(obj: Any?): Boolean {
        if (obj == this) return true    // 파라미터가 this와 같은 객체인지 살펴본다.
        if (obj !is Point) return false // 파라미터 타입을 검사한다.
        return obj.x == x && obj.y == y // Point로 스마트 캐스트해서 x와 y 프로퍼티에 접근
    }
}

fun main() {

    println(Point(10, 20) == Point(10, 20)) // true
    println(Point(10, 20) != Point(5, 5)) // true
    println(null == Point(1,2)) // false
}