package highorderfunction

// 람다를 로컬 변수에 대입 하는 경우를 보자
val sum = { x: Int, y: Int -> x + y }
val action = { println(42) }

// 코틀린의 타입 추론으로 인해 변수 타입을 지정하지 않아도 람다를 변수에 대입할 수 있다.

// 이번엔 함수 타입 선언을 추가해 보자.
val sum2: (Int, Int) -> Int = { x, y -> x + y}  // Int 파라미터를 2개 받아서 Int를 반환
val action2: () -> Unit = { println(42) }        // 아무 인자도 받지 않고, 아무 값도 반환하지 않음

// 그냥 함수를 정의한다면 함수의 파라미터 목록 뒤에 반환 타입 지정을 생략해도 되지만,
// 함수 타입을 선언할 때는 반환 타입을 반드시 명시해야 한다.

// 함수 타입에서도 반환 타입을 널이 될 수 있는 타입으로 지정할 수 있다.
var canReturnNull: (Int, Int) -> Int? = {x,y -> null}

// 널이 될 수 있는 함수 타입 변수를 정의할 수도 있다.
// 단, 함수 타입 전체가 널이 될 수 있는 타입임을 선언하기 위해, 함수 타입을 괄호로 감싸고 그 뒤에 물음표를 붙여야 한다.
var funOrnull: ((Int, Int) -> Int)? = null

fun performRequest(
    callback: (code: Int, content: String) -> Unit // 함수 타입의 각 파라미터에 이름을 붙일수도 있다.
) { }

