fun main(){

//    multiply(1, 2)
//    printHelloWorld("Hello", "Jef")
//    printHelloWorld(name = "Tom", greeting = "Goeiemiddag")
//    printHelloWorld("Hello")

 //   println(sum(1,2))
    val sum : (Int, Int) -> Int = {x, y -> x+y}
    val minus = {x:Int, y: Int -> x-y}

    executeOperation(20,10, minus)
    executeOperation(20, 5, { a, b -> a/b})
    executeOperation(20, 5){ a, b ->
        a*b
    }

    myRepeat(10) { println("Hello world My repeat")}
    repeat(10){ println("Hello World built in repeat")}
}

fun printHelloWorld( greeting: String,name: String = "World") {
    println("$greeting $name!")
}

fun getPi(): Double{
    return 3.1415
}

fun multiply(x: Int, y: Int) =  x * y



fun executeOperation(x: Int, y: Int, operation: (Int, Int)-> Int){
    println( "operation ${operation(x,y)}")
}

fun myRepeat(times: Int, action: ()-> Unit){
    for( i in 1..times){
        action()
    }
}