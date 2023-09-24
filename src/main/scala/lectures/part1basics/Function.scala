package lectures.part1basics

object Function extends App {
  // define function
  // a, b: Parameters and type for each params
  // : String: This part specifies the return type of the function.
  // It means that the function is expected to return a value of type String.
  private def aFunction(a: String, b: Int): String = {
    return a + "" + b
  }

  println(aFunction("hello", 3))


  // parse value into function
  private def aParameterlessFunction(): Int = 42

  // same as
  private def aParameterlessFunction2(): Int = {
    return 42
  }

  println(aParameterlessFunction() + aParameterlessFunction2())


  // Recursion
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1)
      aString
    // or we can write if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  // In normal programing language, you use loop

  // IN FP LIKE SCALA, WHEN YOU NEED LOOPS, USE RECURSION.
  println(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(2) // return Unit
  }

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1) // Smaller function use params of bigger function
  }

}
