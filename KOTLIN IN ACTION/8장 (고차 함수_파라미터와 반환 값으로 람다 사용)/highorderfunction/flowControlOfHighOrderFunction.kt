package highorderfunction

// 고차 함수 안에서 흐름 제어

// 인자로 전달하는 람다 안에서 return 을 사용하면 어떤게 벌어질까?

//forEach 에 전달된 람다에서 return 사용하기
data class _Person(val name: String, val age: Int)

val people  = listOf(_Person("Alice", 29), _Person("Bob", 31))
fun lookForAlice(people: List<_Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

// 람다 안에서 return 을 사용하면 람다로부터만 반환되는게 아니라 그 람다를 호출하는 함수가 실행을 끝내고 반환된다.
// 그렇게 자신을 둘러싸고 있는 블록보다 더 바깥에 있는 다른 블록을 반환하게 만드는 return문을 논로컬(non-local) return 이라 부른다.

// 이 역시 이해가 안간다... 중요한지도 모르겠고.. 쓰는 시점에 돌아오도록 하자.

fun main() {
    lookForAlice(people)
}