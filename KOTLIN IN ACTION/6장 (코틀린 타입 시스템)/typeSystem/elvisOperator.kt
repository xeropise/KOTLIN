package typeSystem

import PersonOne

// 이항 연산자, 좌항 값이 널이 아니면 좌항값을 결과, 널이면 우항 값을 결과
fun foo (s: String?) {
    val t: String = s ?: ""
}

// 엘비스 연산자를 활용하여 널 값 다루기
fun strLenSafe(s: String?) : Int = s?.length ?: 0

fun PersonOne.countryName() = company?.address?.country ?: "Unknown"


// throw와 엘비스 연산자 함께 사용하기
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address") // 주소가 없으면 예외발생

    with(address) { // "address" 는 널이 아니다.
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}


fun main() {
    println(strLenSafe("abc")) // 3
    println(strLenSafe(null)) // 0

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)

    // Elsestr. 47
    // 80687 Munich, Germany
    printShippingLabel(person)

    // java.lang.IllegalArgumentException: No Address
    printShippingLabel(Person("Alexy", null))

}
