import java.io.BufferedReader
import java.io.StringReader


// 널이 될 수 있는 값으로 이뤄진 컬렉션 만들기
fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()  // 제네릭 타입 값에 타입? 으로 표시함으로써 널갑을 추가할 수 있다.
    for (line in reader.lineSequence()) {
        try {
            // line.toIntOrNull() 을 사용하여 문장을 줄여버릴 수 있다.
            val number = line.toInt()
            result.add(number)
        }
        catch(e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

// 널이 될 수 있는 값으로 이뤄진 컬렉션 다루기
fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) { // 리스트에서 널이 될 수 있는 값을 얻으므로 널 검사를 해야 한다.
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

// filterNotNull을 널이 될 수 있는 값으로 이뤄진 컬렉션에 대해 사용하기
fun addValidNumbers2(numbers: List<Int?>) {
    var validNumbers = numbers.filterNotNull() // filterNotNull이 Null이 들어있지 않음을 보장해주므로 List<Int> 이다.
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}


fun main() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
}