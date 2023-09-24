package lectures.part1basics
import scala.annotation.tailrec

/*
1. Đầu tiên hàm này sẽ kiểm tra n có bằng 1 hay không
2. Nếu có thì trả lại 1
3. Nếu không nó trả lại n * Kết quả của đệ quy khác
- Đệ quy đầu là một hàm sẽ gọi đệ quy rồi mới thực hiện các
  phép tính khác trong hàm, có thể sử dụng kết quả của phép đệ quy trước đó.
  Đệ quy đuôi là tất cả phép tính được thực hiện trước rồi mới gọi đệ quy sau cùng.
  -> Đệ quy là tốt khi bạn biết chắc là nó sẽ không lặp lại không quá vài chục lần.
    Nhưng nếu đệ quy xảy ra quá nhiều tầng thì sẽ không còn đủ stack cho chúng và xảy ra StackOverFlow.
*/

object Recursion extends App{
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else { // code block
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result // or we just can write return result - as final as returned value
    }
  }

  println(factorial(10))

  println(factorial(5000)) // => StackOverFlow

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // chú thích annotation
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1)
        accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursion call as the LAST expression

    factorialHelper(n, 1)
  }
  /*
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1)
    = factorialHelper(8, 9 * 10 * 1)
    = factorialHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factorialHelper(2, 3 * 4 * ... * 8 * 9 * 10 * 1)
    = factorialHelper(1, 2 * 3 * ... * 8 * 9 * 10 * 1)
    = return accumulator = 1 * 2 * 3 * ... * 8 * 9 * 10
   */
  // When you need loops, use Tail Recursion
  println(anotherFactorial(10))

  println(anotherFactorial(1000)) // need to assign type BigInt

}


