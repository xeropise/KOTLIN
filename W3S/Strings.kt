<<<<<<< HEAD
fun main() {

    var greeting : String = "Hello"

    var name: String
    name = "John"

    //Error

    //var name
    //name = "John"

    println(name)

    // Access a String

    var txt = "Hello World"
    println(txt[0]) // first element (H)
    println(txt[2]) // first element (l)

    ///////////////////////////////////////////////

    // String Length

    //var txt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    //println("THe long of the txt2 String is: " + txt2.length)

    ///////////////////////////////////////////////

    // String Functions

    // function, toUpperCase, toLowerCase
    println(txt.toUpperCase());
    println(txt.toLowerCase());

    ///////////////////////////////////////////////

    // Comparing Strings
    var txt1 = "Hello World"
    var txt2 = "Hello World"
    println(txt1.compareTo(txt2)); // Output 0 ( They're Equal )

    ///////////////////////////////////////////////

    // Finding a String in a String

    var txt3 = "Please locate where 'locate' occurs!"
    println(txt3.indexOf("locate")) // Output 7

    ///////////////////////////////////////////////

    //Quotes Inside a String
    var txt4 = "It's alright"
    var txt5 = "That's great"

    ///////////////////////////////////////////////

    //String Concatenation

    var firstName = "John"
    var lastName = "Doe"
    println(firstName + " " + lastName)
    println(firstName.plus(lastName))

    ///////////////////////////////////////////////

    //String Templates/Interpolation

    println("My name is $firstName $lastName")

    


}
=======
fun main() {

    var greeting : String = "Hello"

    var name: String
    name = "John"

    //Error

    //var name
    //name = "John"

    println(name)

    // Access a String

    var txt = "Hello World"
    println(txt[0]) // first element (H)
    println(txt[2]) // first element (l)

    ///////////////////////////////////////////////

    // String Length

    //var txt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    //println("THe long of the txt2 String is: " + txt2.length)

    ///////////////////////////////////////////////

    // String Functions

    // function, toUpperCase, toLowerCase
    println(txt.toUpperCase());
    println(txt.toLowerCase());

    ///////////////////////////////////////////////

    // Comparing Strings
    var txt1 = "Hello World"
    var txt2 = "Hello World"
    println(txt1.compareTo(txt2)); // Output 0 ( They're Equal )

    ///////////////////////////////////////////////

    // Finding a String in a String

    var txt3 = "Please locate where 'locate' occurs!"
    println(txt3.indexOf("locate")) // Output 7

    ///////////////////////////////////////////////

    //Quotes Inside a String
    var txt4 = "It's alright"
    var txt5 = "That's great"

    ///////////////////////////////////////////////

    //String Concatenation

    var firstName = "John"
    var lastName = "Doe"
    println(firstName + " " + lastName)
    println(firstName.plus(lastName))

    ///////////////////////////////////////////////

    //String Templates/Interpolation

    println("My name is $firstName $lastName")

    


}
>>>>>>> 4119729b631b1a5b4d915f3bc3969f31856aab28
