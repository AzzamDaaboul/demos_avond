package dataklasses
import java.util.StringJoiner

//interface Shape {
//    fun calculateArea(): Double
//    fun print()
//}

abstract class Shape{
    abstract fun calculateArea(): Double
    abstract val type: String

    fun print(){
        println("I'm a $type with area of ${calculateArea()}")
    }
}

class Circle(val radius: Double): Shape() {
    override fun calculateArea(): Double {
        return Math.PI*radius*radius
    }
    override val type: String = "circle"
}

class Rectangle(val width: Double, val height: Double): Shape() {
    override fun calculateArea(): Double {
        return width*height
    }
    override val type: String = "rectangle"
}

fun main() {
    val shapes: List<Shape> = listOf(Rectangle(10.0,20.0), Circle(10.0))

    shapes.forEach {
        it.print()
    }
}