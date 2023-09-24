package lectures.part1basics

object Function_questions extends App{
  /*
      1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
      2. Factorial function 1 * 2 * 3 * ... * n
      3. A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n-1) + f(n-2)
      4. Test ff a number is prime
    */

  private def greetingFunction(name: String, age: Int): String = {
    f"Hi, my name is $name and I am $age years old"
//    println("Hi, my name is " + name + " and I am " + age + " years old") and type Unit
  }
  println(greetingFunction(name = "John", age = 25))

  private def FactorialFunction(n: Int): Int = {
    if (n <= 0)
      1
    else n*FactorialFunction(n-1)
  }
  println(FactorialFunction(3))

  private def FibonacciFunction(n: Int): Int = {
    if (n <= 1)
      1
    else FibonacciFunction(n-1) + FibonacciFunction(n-2)
  }

  // 1 1 2 3 5 8 13 21
  println(FibonacciFunction(6 ))

  // Test a number is Prime
  private def isPrime(n: Int): Boolean = {
    def isPrimeUtil(t: Int): Boolean =
      if (t <=1)
        true
      else n % t != 0 && isPrimeUtil(t-1)

    isPrimeUtil(n/2) // require boolean
  }
  println(isPrime(1))

}
