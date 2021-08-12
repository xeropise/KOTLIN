package highorderfunction

// 인자로 받은 함수 호출 해 보자.

// 간단한 고차 함수를 정의해보겠다.
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2,3)
    println("The result is $result")
}

// 표준 라이브러리 함수인 filter 를 다시 구현해 보자.
fun String.filter (predicate: (Char) -> Boolean) : String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element))  sb.append(element)
    }
    return sb.toString()
}

// 파라미터를 함수 타입으로 선언할 때도, 디폴트 값을 정할 수 있다.
fun <T> Collection<T>.joinToString(
    sepeartor: String =", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }    // 함수 타입 파라미터를 선언하여, 람다를 디폴트 값으로 선언한다.
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0 ) result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

// 널이 될 수 있는 함수 타입 파라미터를 사용할 수도 있다.
fun <T> Collection<T>.joinToString2(
    seperator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
) : String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(seperator)
        val str = transform?.invoke(element)    // 안전 호출을 사용해 함수를 호출
            ?: element.toString()       // 엘비스 연산자를 사용해 람다를 인자로 받지 않은 경우 호출
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}



fun main() {
    twoAndThree { a,b -> a+b }
    twoAndThree { a,b -> a*b }

    println("ab1c".filter { it in 'a'..'z' })

    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString()) // Alpha, Beta
    println(letters.joinToString { it.toLowerCase() }) // alpha, beta     , 람다를 인자로 전달하였다.


}
