- 코틀린에서 for loop는 초깃값, 증가 값, 최종 값을 사용한 루프를 대신하기 위해 범위(range)를 사용한다. 

- for <아이템> in <원소들> 형태로 루프를 취한다.

```kotlin
val oneToTen = 1..10
    
fun fizzBuzz(i: Int) = when{
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}
fun main() {
    for (i in oneToTen) {
		println(fizzBuzz(i))        
    }
}
```

<br>

- while은 자바하고 똑같다.

```kotlin
while (조건) {

}

do {

} while (조건)
```
