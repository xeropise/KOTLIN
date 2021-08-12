package highorderfunction

// 람다를 사용할 수 없는 환경에서는 아주 복잡한 구조를 만들어야만 피할 수 있는 코드 중복도
// 람다를 활용하면 간결하고 쉽게 제거할 수 있다.

// 사이트 방문 데이터를 정의하자.
data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)

)

// 사이트 방문 데이터를 하드 코딩한 필터를 사용해 분석하자.
val averageWindowsDuration = log
    .filter { it.os == OS.WINDOWS}
    .map(SiteVisit::duration)
    .average()

// 일반 함수를 통해 중복을 제거하자.
fun List<SiteVisit>.averageDurationFor(os: OS) =
        filter { it.os == os }.map(SiteVisit::duration).average()

// 복잡하게 하드코딩한 필터를 사용해 방문 데이터를 분석할 수 있다.
val averageMobileDuration = log
    .filter { it.os in setOf(OS.IOS, OS.ANDROID)}
    .map (SiteVisit::duration)
    .average()

// 고차 함수를 사용해 중복을 제거할 수 있다.
fun List<SiteVisit>.averageDurationFor2(predicate: (SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()

fun main() {
    println(averageWindowsDuration) // 23.0

    println(log.averageDurationFor(OS.WINDOWS)) // 23.0
    println(log.averageDurationFor(OS.MAC)) // 22.0

    println(averageMobileDuration)  // 12.15

    println(log.averageDurationFor2 { it.os in setOf(OS.ANDROID, OS.IOS) }) // 12.15
    println(log.averageDurationFor2 { it.os == OS.IOS && it.path == "/signup"}) // 8.0

}