fun alphabet (): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabetUsingWith() : String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) { // 수신 객체 지정  , 사실 인자가 2개인 함수 with, 람다를 {}로 빼냄
        for (letter in 'A'..'Z') {
            this.append(letter) // this를 명시해서 앞에서 지정한 수싱 객체의 메소드 호출
        }
        append("\nNow I know the alphabet!") // this를 생략하고 메소드를 호출
        this.toString() // 람다에서 값 반환
    }
}

fun alphabetUsingWithAsExpression() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun alphabetUsingApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()