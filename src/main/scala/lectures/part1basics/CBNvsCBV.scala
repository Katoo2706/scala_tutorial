package lectures.part1basics

object CBNvsCBV extends App {
  def callByValue (x: Long): Unit = {
    // The computer evaluates system nano time, call the value x, which is 370788074367541
    // The expression is evaluated first time when call the value of params.
    // println (370788074367541)

    println("by value: " + x)
    println("by value: " + x)
  }

  def callByName (x: => Long): Unit = {
    // The expression is evaluated every time.
    // println (System.nanoTime())
    println("by name: " + x)
    println("by name: " + x)
  }

  // callByValue (370788074367541)
  callByValue(System.nanoTime())

  // as other language
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

  // The function never call the name of y => infinite() will never be called
//  printFirst(infinite(), 34) => Stackoverflow (Call infinite function)

  // The function never call the name of y => infinite() will never be called
  printFirst(34, infinite())
}
