package lectures.part1basics

object Expression extends App {
  val x: Int = 1 + 2 // EXPRESSION HAVE TYPE
  println(x)

  println(2 + 3 + 4)
  // MATH EXPRESSION + - * / & | ^ << >> >>> (Right shift with zero extension)

  println(1 == x) // return false
  // == != > < >= <=

  println(!(1 == x))
  // ! && || (not and or)

  var aVariable: Int = 2
  aVariable += 3 // also work with -= += /= ..... side effects.
  // These changes can be outside the intended or expected behavior of the code and may impact other parts of the program

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  private val aCondition = true
  private val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  println(aVariable)
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN -> Do while will cause side effect

  // EVERYTHING in Scala is an Expression -> return Unit

  private val aWeirdValue: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  private val aWeirdValue2: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue2)
  // Side effects: println(), whiles, reassigning

  // Code blocks - is also Expression
  val aCodeBlock = {
    val y = 2
    val z = y +1

    if (z > 2) "hello" else "goodbye"
  } // The value of Code blocks is the value of Expression

  //  val anotherValue = z + 1  => z was defined inside a Code Block

}
