fun main() {
    //val x = 5
    //val y = 6
    //println(x + y) // Print the value of x + y

    // Kotlin Data Types

    //val myNum = 5               // Int
    val myNum: Int = 5

    //val myDoubleNum = 5.99      // Double
    val myDoubleNum: Double = 5.99

    //val myLetter = 'D'          // Char
    val myLetter: Char = 'D'

    //val myBoolean = true        // Boolean
    val myBoolean: Boolean = true

    //val myText = "Hello"        // String
    //val myText: String = "Hello"

    ////////////////////////////////////////////////////////

    // Integers

    val byteNum: Byte = 100
    //println(byteNum)

    val shortNum: Short = 5000
    //println(shortNum)

    val intNum: Int = 1000000
    //println(intNum)

    val longNum: Long = 15000000000L
    //println(longNum)

    ////////////////////////////////////////////////////////

    // Floats
    val floatNum: Float = 5.75F
    //println(floatNum);

    val doubleNum: Double = 19.99

    val myNum1: Float = 35E3F  // 35 x 10의 3승
    val myNum2: Double = 12E4  // 12 x 10의 4승

    //println(myNum1) // 35000.0
    //println(myNum2) // 120000.0

    ////////////////////////////////////////////////////////

    // Booleans
    val isKotlinFunc : Boolean = true
    val isFishTasty: Boolean = false

    //println(isKotlinFunc)
    //println(isFishTasty)

    ////////////////////////////////////////////////////////

    // Characters
    val myGrade: Char = 'B'
    //println(myGrade)

    //val myLetter: Char = 66
    //println(myLetter) // Error, 자바 처럼 아스키 코드를 Char에 할당 불가

    ////////////////////////////////////////////////////////

    /// Strings
    val myText: String = "Hello World"
    //println(myText)

    ////////////////////////////////////////////////////////

    // Type Conversion

    //val x : Int = 5
    //val y : Long = x
    //println(y) // Error : Type mismatch =

    val x: Int = 5
    val y: Long = x.toLong()
    println(y)

    // toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble() or toChar()  사이법버 범죄
}
