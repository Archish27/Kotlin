
import java.util.*

/**
 * Created by Archish on 6/30/2017.
 */

fun main(args: Array<String>) {
    println("Hello World")
    val name = "Archish"
    var myAge = 20
    val bigInt: Int = Int.MAX_VALUE
    val smallInt: Int = Int.MIN_VALUE
    println(name + " $myAge $bigInt" + " $smallInt")

    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE
    println("Biggest Long $bigLong")
    println("Smallest Long $smallLong")

    var bigShort: Short = Short.MAX_VALUE
    var smallShort: Short = Short.MIN_VALUE
    println("Biggest Short $bigShort")
    println("Smallest Short $smallShort")
    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE
    println("Biggest Double $bigDouble")
    println("Smallest Double $smallDouble")
    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE
    println("Biggest Float $bigFloat")
    println("Smallest Float $smallFloat")

    var doubleVal: Double = 1.1111111111111111
    var doubleVal1: Double = 1.1111111111111111
    println("Sum: " + (doubleVal + doubleVal1))

    if (true is Boolean) {
        print("True is boolean\n")
    }

    var charLetter: Char = 'A'
    print("$charLetter is Letter ${charLetter is Char}\n ")

    //Casting
    println("3.14 to Int: " + 3.14.toInt())
    println("A to Int: " + charLetter.toInt())
    println("65: " + 65.toChar())


    //Strings
    val myName = "Archish"
    val longStr = """This is
is Archis Thakkar"""

    var fName: String = "Archis"
    var lname: String = "Thakkar"
    fName = "Archish"
    var fullName = "$fName $lname"
    println("Name: $fullName")
    println("Length: ${longStr.length}")
    println("Strings equal : ${fName.equals(lname)}")
    println("Compare A & B : ${fName.compareTo(lname)}")
    println("2nd Index : ${fName.get(2)}")
    println("3nd Index : ${fName[3]}")
    println("Substring : ${fName.subSequence(2, 5)}")
    println("Contains Random : ${longStr.contains("Thakkar")}")

    //Arrays
    var myArray = arrayOf(1, 1.23, "Archis")
    println(myArray[2])
    myArray[1] = 9.4

    println("Array Length: ${myArray.size}")
    println("Archis in Array: ${myArray.contains("Archis")}")

    var partArray = myArray.copyOfRange(0, 3)
    println("First: ${partArray.first()} & Last : ${partArray.last()}")

    var squareArray = Array(5, { c -> c * c })
    println(squareArray[3])

    var arr2: Array<Int> = arrayOf(1, 2, 4)

    //Ranges to define starting & ending
    val oneTo10 = 1..10
    val alpha = "A".."Z"
    println("R in alpha:${"R" in alpha}")

    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneTo10.step(3)
    for (x in rng3)
        println("rng3 :$x")
    for (x in tenTo1.reversed())
        println("Reverse: $x")
    for (x in twoTo20)
        println("TwoTo20 :$x")

    //Conditional Operator < > >= <= == !=
    //Logical Operator
    val age = 8
    if (age <= 5)
        println("Go to Preschool")
    else if (age == 5)
        println("Go to kindergarden")
    else if (age in 6..17) //age>5 && age<=17
    {
        val grade = age - 5
        println("Go to Grade $grade")
    } else
        println("Go To College")

    when (age) {
        0, 1, 2, 3, 4 -> println("Go to Preschool")
        5 -> println("Go To Kindergarden")
        in 6..17 -> {
            val grade = age - 5
            println("Go to Grade $grade")
        }
        else -> println("Go to College")

    }

    //For Loops
    for (x in 1..10) {
        println("Loop : $x")
    }
    val rand = Random()
    val magicNum = rand.nextInt(50) + 1
    var guess = 0
    while (magicNum != guess)
        guess += 1
    println("Magic Num was $guess")

    for (x in 1..20) {
        if (x % 2 == 0)
            continue
        println("Odd :$x")
        if (x == 15)
            break
    }
    var arr3: Array<Int> = arrayOf(2, 4, 6)
    for (x in arr3.indices)
        println("Multiple of 2 :${arr3.get(x)}")

    for ((index, value) in arr3.withIndex()) {
        println("Index :$index Value: $value")
    }

    //Functions
    fun add(num1: Int, num2: Int): Int = num1 + num2 // Positional Parameter
    println("5+4 = ${add(5, 4)}")

    fun sub(num1: Int = 9, num2: Int): Int = num1 - num2 // Default Value
    println("5-4 = ${sub(5, 4)}")

    println("4-5${sub(num2 = 4, num1 = 2)}") //Named Parameter

    fun sayHello(name: String): Unit = println("Hello $name")
    sayHello("Archis")
    val (two, three) = nextTwo(1)
    println("1 $two $three")
    println("Sum= ${getSum(1, 2, 3, 4, 5, 6)}")
    val multiply = { num1: Int, num2: Int -> num1 * num2 }
    println("5*3 = ${multiply(5, 3)}")

    println("factorial: ${fact(5)}")


    //HigherOrder Functions
    val numList = 1..20
    val even = numList.filter { it % 2 == 0 }
    even.forEach { n -> println("$n") }

    //Function within Function
    val mult3 = makeMath(3)
    println("5 *3 = ${mult3(5)}")

    val mult2 = { num1: Int -> num1 * 2 }
    val numList2 = arrayOf(1, 2, 3, 4, 5)
    mathOnList(numList2, mult2)

    val listSum = oneTo10.reduce { x, y -> x + y }
    println("Reduce Sum : $listSum") // Sum all values 1 to 10

    val listSum1 = oneTo10.fold(3) { x, y -> x + y }
    println("Fold Sum : $listSum1") //Sum all values from 1 to 10 & also some initial value i.e 3

    println("Evens: ${oneTo10.any { it % 2 == 0 }}") // returns true if whether any values are even else false
    println("Evens: ${oneTo10.all { it % 2 == 0 }}") // returns true if whether all values are even else false

    val big3 = oneTo10.filter { it > 3 }
    big3.forEach { n -> println("$n") }

    val time7 = oneTo10.map { it * 7 }
    time7.forEach { n -> println("$n") }


    //Exception Handling
    val divisor = 0
    try {
        if (divisor == 0)
            throw IllegalArgumentException("Can't Divide")
        else {
            println("5/ $divisor = ${5 / divisor}")
        }
    } catch(e: IllegalArgumentException) {
        println("Zero Divide Error ${e.message}")
    }

    //Lists
    var list: MutableList<Int> = mutableListOf(1, 2, 3, 4)
    val list1: List<Int> = listOf(1, 2, 3)

    list.add(5)

    println("1st ${list.first()}")
    println("Last ${list.last()}")
    println("2nd ${list.get(2)}")

    var list3 = list.subList(0, 3)
    println("Length: ${list3.size}")

    list3.clear()
    list.remove(1)
    list.removeAt(1)

    list.forEach { n -> println("Mutable List : $n") }


    //Maps
    val map = mutableMapOf<Int, Any?>()
    val map2 = mutableMapOf(1 to "Doug", 2 to 25)

    map[1] = "Archis"
    map[2] = 42
    println("Map Size :${map.size}")
    map.remove(2)
    for ((x, y) in map) {
        println("Key: $x & Value :$y")
    }


    //Classes
    val bowser = Animal("Tiger", 12.0, 2.2)
    bowser.getInfo()

    val spot = Dog("Spot", 20.0, 12.9, "Archis Thakkar")
    spot.getInfo()

    //Interfaces
    val bird = Bird("Tweety", true)
    bird.fly(19.2)

    //NULL
    var nullVal: String? = null
    fun returnNull(): String? {
        return null
    }

    val nullVal3 = returnNull()
    if(nullVal3 !=null)
        println("null is not there")
    else
        println("Null is present")
}

open class Animal(val name: String, var height: Double, var weight: Double) {
    init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) { " Animal name can't contain numbers" }
        require(height > 0) { "Height must be greater than 0" }
        require(weight > 0) { "Weight must be greater than 0" }
    }

    open fun getInfo(): Unit {
        println("$name is $height tall & weight $weight")
    }
}

class Dog(name: String, height: Double, weight: Double, var owner: String) : Animal(name, height, weight) {
    override fun getInfo(): Unit {
        println("$name is $height tall & weight $weight & is owned ny $owner")
    }
}

interface Flyable {
    var flies: Boolean
    fun fly(distMile: Double): Unit
}

class Bird constructor(val name: String, override var flies: Boolean = true) : Flyable {
    override fun fly(distMile: Double) {
        if (flies) {
            println("$name flies $distMile miles")
        }
    }
}

fun makeMath(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }
fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
    for (num in numList) {
        println("MathOnList ${myFunc(num)}")
    }
}

fun fact(x: Int): Int {
    if (x == 0)
        return 1
    else
        return x * fact(x - 1)
}

fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { n -> sum += n }
    return sum
}

fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}
