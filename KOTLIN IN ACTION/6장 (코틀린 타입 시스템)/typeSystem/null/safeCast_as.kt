package typeSystem.`null`

class PersonTwo(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
       val otherPerson = other as? PersonTwo ?: return false // 타입이 서로 일치하지 않으면 false 를 반환

       return otherPerson.firstName == firstName &&
              otherPerson.lastName == lastName
    }
}

fun main() {
    val p1 = PersonTwo("Dmitry", "Jemerov")
    val p2 = PersonTwo("Dmitry", "Jemerov")

    println(p1==p2) // true    , == 연산자는 equals와 같다 (코틀린)
    println(p1.equals(42)) // false
}