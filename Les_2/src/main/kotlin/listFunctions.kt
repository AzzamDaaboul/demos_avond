fun main() {
    val numbers =  listOf(1,2,3,4,5,6,287,34)
    val evenNumbers = numbers.filter{number -> number%2==0}

    val oddNumber = numbers.filter {
        println("it =  $it")
        it % 2 == 1
    }
    println(evenNumbers)
    println(oddNumber)

    val isEven = numbers.map { it%2==0 }

    println(isEven)

    val nestedList = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
    println(nestedList)
    println(nestedList.flatten())
}