package typeSystem

// 널이 될 수 있는 타입 파라미터 다루기
fun <T> printHashCode(t:T) {
    println(t?.hashCode()) // "t"가 null이 될 수 있으므로, 안전한 호출을 써야 한다.
}

// 타입 파라미터에 대해 널이 될 수 없는 상한을 지정하면, 널이 될 수 있는 값을 거부 한다.
fun <T: Any> printHashCode2(t: T) {
    println(t.hashCode())
}
fun main() {
    printHashCode(null)  // "T"의 타입은 "Any"로 추론된다.
    //printHashCode2(null) // 이 코드는 컴파일 되지 않는다, null 이 될 수 없는 타입의 파라미터에 널을 넘길 수 없다.
}