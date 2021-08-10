// 코틀린 배열은 타입 파라미터를 받는 클래스이다. 배열의 원소 타입은 타입 파라미터에 의해 정해진다.
// 코틀린에서 배열을 만드는 방법은 다양하다.

/*
    - arrayOf 함수에 원소를 넘기면 배열을 만들 수 있다.

    - arrayOfNulls 함수에 정수 값을 인자로 넘기면, 모든 원소가 null이고, 인자로 넘긴 값과 크기가 같은 배열을 만들 수 있다.
      물론 원소 타입이 널이 될 수 있는 타입인 경우에만 이 함수를 쓸 수 있다.

    - Array 생성자는 배열 크기와 람다를 인자로 받아서 람다를 호출, 각 배열 원소를 초기화해준다.
      arrayOf 를 쓰지 않고, 각 원소가 널이 아닌 배열을 만들어야 하는 경우 이 생성자를 사용한다.
 */

// 배열 사용하기
fun main(args: Array<String>) {
    for (i in args.indices) {
        println("Arguemnt $i is: ${args[i]}")
    }

    // 알파벳으로 이뤄진 배열 만들기
    // 제네릭 타입을 쓰지 않아도 사실 컴파일러가 알아서 추론해준다.
    val letters = Array<String>(26) { i -> ('a' + i).toString()} // 인덱스가 인자
    println(letters.joinToString(""))

    // 컬렉션을 vararg 메소드에게 넘기기
    val strings = listOf("a","b","c")
    println("%s/%s/%s".format(*strings.toTypedArray())) // vararg 인자를 넘기기 위해, 스프레드 연산자(*)를 써야 한다.

    // 배열에 forEachIndexed 사용하기
    args.forEachIndexed { index, s -> println("Argument $index is: $element")  }
}

// 다른 제네릭 타입에서처럼 배열 타입의 타입 인자도 항상 객체 타입이 된다.
// Array<Int> 를 선언하면 그 배열은 박싱된 정수의 배열 java.lang.Integer[] 이다.
// 박싱하지 않은 원시 타입의 배열이 필요하다면 그런 타입을 위한 특별한 배열 클래스를 사용해야 한다.
/*
        IntArray, ByteArray, CharArray, BooleanArray
    =>  int[],    byte[],    char[]     boolean[]

    만드는 법은 다음과 같다.
    val fiveZeros = IntArray(5)  // size를 인자로 넣어 원시 타입의 디폴트 값..  Int의 경우 0으로 초기화된 배열 반환
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0) // 팩토리 함수를 사용
    val squares = IntArray(5) { i -> (i+1) * (i+1) }    // 크기와 람다를 인자로 받는 생성자 사용
 */

