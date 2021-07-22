```kotlin

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'  // 'a' <= c && c <= 'z'

fun isNotDigit(c: Char) = c !in '0'..'9' // !( '0' <= a && a <= '9')

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

// 객체 비교의 경우, 구현된 Comparable 을 기준으로 작동한다.
// Comparable은 Iterable하지 못한 반면에 in 을 사용하여 Iterable 하게 체크함
// String의 경우, 두 문자열의 알파벳 순서로 비교
fun stringBetweenJavaAndScala(c: String) = c in "Java".."Scala"

// Collection 에도 사용 가능
fun inOperatorCollection(s: String, list : Collection<String>) = s in list
    
fun main() {
   println(isLetter('q'))
   
   println(isNotDigit('x'))
   
   println(recognize('8'))
   
   println(stringBetweenJavaAndScala("Kotlin"))
   
   println(inOperatorCollection("Kotlin", setOf("Java", "Scala")))
}

```
