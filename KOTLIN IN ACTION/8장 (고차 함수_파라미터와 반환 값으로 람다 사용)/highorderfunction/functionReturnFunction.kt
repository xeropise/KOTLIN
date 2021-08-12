package highorderfunction

// 함수를 반환하는 함수를 정의할수도 있다.

// 사용자가 선택한 배송 수단에 따라 배송비를 계산하는 방법이 달라지는 함수를 보자.
enum class Delivery { STANDARD, EXPEDITED }

class Order (val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {

    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

// GUI 연락처 관리 앱을 만드는 데 UI 상태에 따라 어떤 연락처 정볼르 표시할지 결정해야 할 필요가 있다고 가정하자.
// 사용자가 UI의 입력 창에 입력한 문자열과 매치되는 연락처만 화면에 표시하되 설정에 따라 전화번호가 없는 연락처를 제외시킬 수도 있고, 포함시킬수도 있어야 한다.

// 함수를 반환하는 함수를 한번 더 보자.
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate() : (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return {
            startsWithPrefix(it) && it.phoneNumber != null
        }
    }
}


fun main() {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")  // <-- 반환받은 함수를 호출한다.


    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"),
                          Person("Svetlana", "Isakova", null))
    val contactListFilters = ContactListFilters()

    with (contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }

    println(contacts.filter(contactListFilters.getPredicate()))
}


