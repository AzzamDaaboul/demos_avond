package dataklasses

open class Person (firstName: String, lastName: String, age: Int) {
    var myFirstName: String = ""
    var myLastName: String = ""
    open var myAge: Int = 0

    var fullName : String
        get() {
            return "$myFirstName $myLastName"
        }
        set(value) {
            val components = value.split(" ")
            myFirstName = components[0]
            myLastName = components[1] // Bevat logische fout bij familienamen met spatie!
        }

    // public Person(firstName: String, lastName: String, age: Int){
    //
    //}
    init {
       walk()
    }

    init {
        println("properties are set!")
        this.myFirstName = firstName
        this.myLastName = lastName
        this.myAge = age
    }


    open fun walk() {
        println("Walking!")
    }
}

class Student(firstName: String, lastName: String, age: Int) : Person(firstName, lastName, age)
{
    override var myAge=20

    override fun walk(){
        println("Student is walking!")
    }
}

class Course(val name: String = "Application Development"){
    var credits : Int = 0

    constructor(name: String, credits: Int):this(name){
        this.credits = credits
    }
}


fun main() {
    val persoon =  Person("Matthias", "Druwé", 32)
    persoon.fullName = "John Doe"
    val cursus = Course("Mobile development")
    val cursus2 = Course()
    val cursus3 = Course("Database essentials", 4)

    cursus.credits = 8

    println("persoon: ${persoon.myFirstName} ${persoon.myLastName} ${persoon.myAge}")
    println("persoon: ${persoon.fullName}")
    println("Cursus: ${cursus.name}")
    println("Cursus2: ${cursus2.name}")
    println("Cursus3: ${cursus3.name} ${cursus3.credits}")

    persoon.walk()
}