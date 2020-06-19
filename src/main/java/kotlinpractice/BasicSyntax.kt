package kotlinpractice

class BasicSyntax {

    fun main() {
        println("hello world!")
    }

    fun sum(a: Int, b: Int) : Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int) : Unit {
        println("sum of $a and $b is ${a + b}")
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    fun describe(obj: Any) : String =
        when (obj) {
            1       -> "one"
            "Hello" -> "Greeting"
            is Long -> "long"
            !is String -> "Not a String"
            else    -> "Unknown"
        }

    fun makeDrink() {
        val items = setOf("apple", "banana", "orange")
        when {
            "orange" in items    -> println("juicy")
            "apple" in items     -> println("apple is fine too")
        }
    }
}