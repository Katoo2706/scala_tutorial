package lectures.part1basics

object Expression_question {
  // 1. difference between "hello world" vs println("hello word")?
  // Value of type string
  // println("hello word") is Unit & have side effect, print text to console

  // 2. This
  private val someValue = {
    2 < 3
  } // return boolean

  println(someValue)
  // 3
  private val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  println(someOtherValue)
}
