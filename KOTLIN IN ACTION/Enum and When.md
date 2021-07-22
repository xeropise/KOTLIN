
- Enum 은 자바와 달리 클래스 앞에 enum 이라는 '소프트 키워드' 를 선언하여 사용한다. 

```kotlin
enum class Color ( val r: Int, val g: Int, val b: Int) {
    
    RED(255, 0, 0)
    , ORANGE(255, 165, 0)
    , YELLOW(255, 255, 0)
    , GREEN(0, 255, 0)
    , BLUE(0, 0, 255)
    , INDIGO(75,0,130);  // 예외적으로 세미콜론으로 끝나야 한다.
    
    fun rgb() = (r + 256 + g) * 256 + b
}

fun getMnemonic(color: Color) = 
    
    when (color) {
    	Color.RED, Color.ORANGE, Color.YELLOW -> "warm"   // , 를 통해 여러값을 매치 패턴으로 사용할 수 있다. 
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO -> "cold"
         // 자바와 달리 break 를 걸지 않아도 된다.
    }

fun main() {
    println(getMnemonic(Color.BLUE))
}
```

<br>

- when 은 자바의 switch 를 대체하는 데 분기 조건에 상수(enum 상수나 숫자 리터럴)만을 사용할 수 있는 자바 switch와 달리 코틀린 when의 분기 조건은 임의의 객체를 허용한다.

```kotlin
enum class Color ( val r: Int, val g: Int, val b: Int) {
    
    RED(255, 0, 0)
	, ORANGE(255, 165, 0)
    , YELLOW(255, 255, 0)
    , GREEN(0, 255, 0)
    , BLUE(0, 0, 255)
    , INDIGO(75,0,130);
    
    fun rgb() = (r + 256 + g) * 256 + b
}

fun getMnemonic(color: Color) = 
    
    when (color) {
    	Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO -> "cold"
        
    }
    
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.INDIGO) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(mix(Color.BLUE, Color.YELLOW))
}
```
