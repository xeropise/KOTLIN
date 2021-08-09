package typeSystem.primitive

// 코틀린은 원시 타입과 래퍼타입을 구분하지 않고, 항상 같은 타입을 사용한다.

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100) // 원시 타입의 값에 대해서도 메소드를 호출 가능
    println("We're ${percent}% done!")
}

fun main() {
    showProgress(146)
}

// 실행시점에는 자바의 int 타입으로 컴파일하다가, 제네릭 클래스를 사용하는 등의 경우에는 래퍼타입으로 변환한다.

// 널이 될 수 있는 코틀린 타입은 자바의 원시 타입으로 표현 불가능하다.
// 코틀린에서 널이 될 수 있는 원시타입을 사용하면, 그 타입은 자바의 래퍼 타입으로 컴파일 된다.

// 널이 될 수 있는 원시 타입
data class Person(val name: String, val age: Int? = null) {

    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null)   // 널이 될 가능성이 있으므로 Int? 값을 직접 비교하게 하지 않는다. 두 값이 모두 널이 아닌지 검사후에야 다루게 허용함
            return null
        return age > other.age
    }
}