
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

- 위이 경우 분기 방식으로 차례대로 동등성 검사를 한다.

- 위의 when 의 경우 인자가 있는 방식인데 분기 조건에 다른 두색과 같은지 비교하기 위해 여러 Set 인스턴스를 생성한다.  비효율성이 크게 문제되지는 않으나 이 함수가 자주 호출되는 경우, 불필요한 가비지 객체가 늘어나게 되므로 함수를 고치는 것이 낫다.

<br>

- 인자가 없는 when 식을 사용하면 불필요한 객체 생성을 막을 수 있다. 읽기 어려워지지만 성능을 더 향상시키기 위해 비용을 감수해야 하는 경우도 자주 있다. 

- 인자가 없는 when 을 사용하려면 각 분기의 조건이 불리언 결과를 계산하는 식이어야 한다. 추가 객체를 만들지 않는다는 장점이 있지만 가독성이 떨어진다.

```kotlin
fun mixOptimized(c1: Color,c2: Color) = 
	when {
		(c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
		(c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
		(c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
		else -> throw Exception("Dirty Color")
	     }
	     
```

<br>

- if, when 모두 분기에 블록을 사용할 수 있다. 블록의 마지막 문장이 블록 전체의 결과가 된다.

```kotlin
fun evalWithLogging(e: Expr): Int =
    when(e) {
        is Num -> {
            println("num: ${e.value}")
            e.value	// 블록의 마지막 식이 반환된다.
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right;
        }
        else throw IllegalArgumentException("Unknown expression")
    }
    
fun main() {
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}
```
