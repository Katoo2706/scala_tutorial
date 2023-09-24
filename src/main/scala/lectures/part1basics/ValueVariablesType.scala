package lectures.part1basics


// Defines a Scala singleton object named "ValueVariablesType" that extends the "App" trait.
object ValueVariablesType extends App {
  /*
    Code for your Scala application can be written here.
    No need to define a specific "main" method with extends App
    private val x:  Accessible only within the same object
  */

  // value - constant are immutable
  val x: Int = 42 // Accessible from anywhere

  val aString: String = "hello"

  val anotherString = "goodbye"

  val aBoolean: Boolean = false

  var aChar: Char = 'a' // must use '' because "" is for string

  val anInt: Int = x // assign from other val

  val aShort: Short = 4432 // 16-bit signed integer

  val aLong: Long = 5435433423434323L // 64-bit signed integer // The 'L' suffix specifies that it's a Long

  val aFloat: Float = 2.0F

  val aDouble: Double = 3.14D

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects

  val aInteger = 2 // String
  val aStringfromInteger = aInteger + " items" // String - compiler with auto define as string
//  println(String(aStringfromInteger))

  // The compiler infers the return type from implementation

  def addOne(x: Int) = x + 1 // integer
  println(addOne(1) + 4)
}


// COMPARE public val & private val
object ExampleObject {
  val publicValue: Int = 42  // This is a public val
  private val privateValue: Int = 24  // This is a private val

  def printValues(): Unit = {
    println(s"Public Value: $publicValue")
    println(s"Private Value: $privateValue")
  }
}

object Main extends App {
  ExampleObject.printValues()
  // Accessing publicValue is allowed from anywhere
  println(s"Accessing Public Value from Main: ${ExampleObject.publicValue}")

  // Attempting to access privateValue from outside the object will result in a compilation error
  // println(s"Accessing Private Value from Main: ${ExampleObject.privateValue}")
}
