fun strLenSafe(s: String?): Int {
    if (s != null) {
        return s.length
    }
    else
        return 0
}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

// 널이 될 수 있는, 프로퍼티를 다루기 위해 안전한 호출 사용
class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name


// 안전한 호출 연쇄시키기
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class PersonOne(val name: String, val company: Company?)

fun PersonOne.countryName() : String {
    val country = this.company?.address?.country
    return country ?: "Unknown"
}

fun main () {
    /*
       // can't assigned
        val x: String? = null
        val y: String = x

     */

    printAllCaps("abc") // ABC
    printAllCaps(null) // null

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)

    println(managerName(developer)) // Da Boss
    println(managerName(ceo)) // null
}
