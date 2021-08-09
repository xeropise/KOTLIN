package typeSystem

// let 함수를 안전한 호출 연산자와 함께 사용하면, 원하는 식을 평가해서 결과가 널인지 검사한 다음
// 그 결과를 변수에 넣는 작업을 간단한 식을 사용해 한꺼번에 처리할 수 있다.

// let 을 사용하는 가장 흔한 용례

// 널이 될 수 있는 값을 널이 아닌 값만 인자로 받는 함수에 넘기는 경우
fun sendMailTo(email: String) {
    println("Sending mail to $email")
}



fun main() {
    val email: String? = "xeropise1@hanmail.net"
    // sendMailTo(email)    <-- 이 함수에게 null이 될 수 있는 타입을 넘길 수 없다.

    // 인자를 넘기기 전에 주어진 값이 널인지 검사해야 함.

    // 널인 값을 널이 아닌 값으로 바꿔줌
    email?.let { email -> sendMailTo(email) }
    email?.let { sendMailTo(it)}

    /*
        // let을 쓰면 긴 식의 결과를 저장하는 변수를 따로 만들 필요가 없다.

        val person: Person? = getTheBestPersonInTheWorld(
        if (person != null) sendMailTo(person.email

        // 긴 식의 결과를 저장하는 변수를 따로 만들 필요가 없다.
        getTheBestPersonInTheWorld()?.let { sendEmailTo (it.email) }

        // 다음의 getTheBestPersonInTheWorld() 함수는 null을 반환하므로 위의 람다식은 결코 실행되지 않는다.
        fun getTheBestPersonInTheWorld() : Person? = null
     */
}