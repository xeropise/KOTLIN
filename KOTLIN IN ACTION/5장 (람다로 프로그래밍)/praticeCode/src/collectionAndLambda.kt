import java.io.File

data class Person(val name: String, val age: Int)

class Book(val title: String, val authors: List<String>)

fun main() {
    val numbers = mapOf(0 to "zero", 1 to "one")
    numbers.mapValues { it.value.toUpperCase()}

    val people = listOf(Person("조규비",29), Person("차소영", 32))
    val canBeInClub27 = { p: Person -> p.age <= 27 }

    people.all{ it.age <= 27 }
    people.any(canBeInClub27)

    // filter를 이용한 size를 가져오는 경우, 컬렉션을 하나더 만드므로 효율적이지 않다.
    people.count(canBeInClub27)
    people.filter(canBeInClub27).size

    people.firstOrNull()

    people.groupBy {it.age}

    ////////////////////////

    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
                       Book("Mort", listOf("Terry Pratchett")),
                       Book("Good Omens", listOf("Terry Pratchett", "Neil Gailman")))

    books.flatMap { it.authors }.toSet()

    // Sequence
    people.map(Person::name).filter { it.startsWith("A")} // list를 2개 만드므로 비효율적
    people.asSequence().map { it.name }.filter { it.startsWith("A") }.toList()

    // 중간 연산은 항상 지연 계산
    // 최종 연산을 호출해야 연기되었던 모든 계산이 수행된다.
    /*
    listOf(1, 2, 3, 4).asSequence()
        .map { print ("map ($it"); it * it }
        .filter { print ("filter($it)"); it % 2 == 0}
        .toList()
    */

    listOf(1,2,3,4).asSequence().map { it * it }.find { it > 3}

    // Sequence 만들기
    val naturlaNumbers = generateSequence(0) { it + 1 }
    val numberTo100 = naturlaNumbers.takeWhile { it <= 100 }
    println(numberTo100.sum())
}

fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile}.any { it.isHidden }