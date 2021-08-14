<<<<<<< HEAD
fun main() {

    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")


    //Access the Elements of an Array
    println(cars[0])

    //////////////////

    //Change an Array Element
    cars[0] = "Opel"

    println(cars[0])

    //////////////////

    // Array Length / Size

    println(cars.size)

    //////////////////

    if ("Volvo" in cars) {
        println("It exists!")
    } else {
        println("It does not exist.")
    }

    //////////////////
    
    for(x in cars) {
        println(x)
    }
=======
fun main() {

    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")


    //Access the Elements of an Array
    println(cars[0])

    //////////////////

    //Change an Array Element
    cars[0] = "Opel"

    println(cars[0])

    //////////////////

    // Array Length / Size

    println(cars.size)

    //////////////////

    if ("Volvo" in cars) {
        println("It exists!")
    } else {
        println("It does not exist.")
    }

    //////////////////
    
    for(x in cars) {
        println(x)
    }
>>>>>>> 4119729b631b1a5b4d915f3bc3969f31856aab28
}