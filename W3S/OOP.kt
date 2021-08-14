<<<<<<< HEAD
//class Car {
//    var brand = ""
//    var model = ""
//    var year = 0
//}

//class Car(var brand: String, var model: String, var year: Int)

class Car(var brand: String, var model: String, var year: Int) {

    // Class function
    fun drive() {
        println("Wrooom!")
    }

    // Class function with parameters
    fun speed(maxSpeed: Int) {
        println("Max speed is: " +  maxSpeed)
    }
}

// Superclass
open class MyParentClass {
    val x = 5
}

// Subclass
class MyChildClass: MyParentClass() {
    fun myFunction() {
        println(x)
    }
}

fun main() {
    val myObj = MyChildClass()

    myObj.myFunction()

=======
//class Car {
//    var brand = ""
//    var model = ""
//    var year = 0
//}

//class Car(var brand: String, var model: String, var year: Int)

class Car(var brand: String, var model: String, var year: Int) {

    // Class function
    fun drive() {
        println("Wrooom!")
    }

    // Class function with parameters
    fun speed(maxSpeed: Int) {
        println("Max speed is: " +  maxSpeed)
    }
}

// Superclass
open class MyParentClass {
    val x = 5
}

// Subclass
class MyChildClass: MyParentClass() {
    fun myFunction() {
        println(x)
    }
}

fun main() {
    val myObj = MyChildClass()

    myObj.myFunction()

>>>>>>> 4119729b631b1a5b4d915f3bc3969f31856aab28
}