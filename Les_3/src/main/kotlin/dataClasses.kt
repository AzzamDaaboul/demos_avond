import java.util.Date

data class Book(val title: String, val author: String, val isbn: String, val publishDate: Date)

fun main(){
    val currentDate = Date()
    val book1 = Book("Harry Potter", "J.K. Rowling", "isbn1234567", currentDate)
    val book2 = Book("Harry Potter", "J.K. Rowling", "isbn1234567", currentDate)
    val book3 = book2.copy();
    println(book1)
    println(book2)
    println(book1 == book2)
}

