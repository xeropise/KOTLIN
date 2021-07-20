fun main() {

    if (20 > 18) {
        println("20 is grater than 18")
    }

    val x = 20
    val y = 18

    if (x > y) {
        println("x is greater than y")
    }

    val time = 20
    if (time < 18) {
        println("Good day.")
    } else {
        println("Good evening.")
    }
    // Outputs "Good evening"

    val time2 = 20

    val greeting = if(time < 18) { "Good day." } else { "Good evening" }

    println(greeting)


    val time3 = 20
    val greeting2 = if (time < 18) "Good day." else "Good evening"
    println(greeting2)
}