package convention.destructuringDeclaration.loop

// 함수 본문 내의 선언문뿐만 아니라 변수 선언이 들어갈 수 있는 장소라면 어디든 구조 분해 선언을 사용할 수 있다.

// 구조 분해 선언을 사용해 맵 이터레이션하기
// 맵에 대한 확장함수로 iterator가 들어있고, Map.Entry에 대한 확장 함수로 component1, component2 를 제공한다.
fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

fun main() {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "kotlin")
    printEntries(map)
}