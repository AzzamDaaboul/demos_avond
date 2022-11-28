
fun Int.isEven() : Boolean {
    return this%2== 0
}

fun Int.isPrime(): Boolean {

    if (this==1){
        return false
    }
    for( i in 2..this-1){
        if(this%i==0){
            return false
        }
    }

    return true
}

fun String.StartsWithA(): Boolean{
    return this[0]=='A'
}

fun main() {
    val numbers = listOf(1,2,3,4,5,6,7,8,9,10)

    numbers.forEach {number ->
        if(number.isEven() ){
            println("$number is even")
        }
        else {
            println("$number is odd")
        }
    }

    numbers.forEach {
        if(it.isPrime()){
            println(it)
        }
    }
}