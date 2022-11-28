object Calculator {
    fun add(x: Int, y: Int) = x+y
    fun divide(x:Int, y: Int) = x/y
}

class World(val people: MutableList<Person>){
    companion object{
        val gravity = 9.81
        fun computeForce(x:Int, y: Int)  = x*y* gravity
    }


    fun addPerson(person: Person){
        people.add(person)
    }
}

fun main() {


    val result = Calculator.add(1,2)
    val result2 = Calculator.divide(20, 10)

    val world = World(mutableListOf<Person>())
    world.addPerson(Person("Matthias", "Druwé", 32))

    val gravity = World.gravity

}