package convention.compoundAssignmentOperator

import convention.arithmeticOperator.Point

// 복합 대입 연산자 오버로딩
// plus와 같은 연산자를 오버로딩하면, 코틀린은 그와 관련있는 +=도 자동으로 함께 지원한다.
// += , -= 등의 연산자를 복합 대입 연산자라고 부른다.
// 물론 변수가 변경 가능해야 한다. (var)

// plus 와 plusAssign 연산을 동시에 정의하면 안된다.
// 어떤 클래스가 이 두함수를 모두 정의하고 둘다 += 에 사용 가능한 경우 컴파일러가 오류를 보고한다.

fun main() {
    var point = Point(1,2)
    point += Point(3, 4)
    println(point) // Point(x=4, y=6)

    // 경우에 따라 += 연산이 객체에 대한 참조를 다른 참조로 바꾸기보다는, 원래 객체의 내부 상태를 변경하게 만들고 싶을 때가 있다.
    val numbers = ArrayList<Int>()
    numbers += 42  // plusAssign 함수
    println(numbers[0]) //42

    val list = arrayListOf(1,2)
    list += 3     // += 는 list를 변경
    val newList = list + listOf(4,5) // + 는 두 리스트의 모든 원소를 포함하는 새로운 리스트를 반환
    println(list) // [1, 2, 3]
    println(newList) // [1, 2, 3, 4, 5]
}