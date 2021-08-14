
fun main() {

    var i = 0

    // while
/*    while (i<5) {
        println(i)
        i++
    }*/

    // do - while
/*    do {
        println(i)
        i++
    }
    while (i<5)*/

    // break

/*    while(i<10) {
        println(i)
        i++
        if (i == 4) {
            break
        }
    }*/

    // continue
    while(i<10) {
        if (i==4) {
            i++
            continue
        }
        println(i)
        i++
    }

}