package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

/*
1. Concatenate a string n times
2. IsPrime Function tail recursive
3. Fibonacci function, tail recursive
*/

object RecursionQuestion extends App{
  // 1
  // Recursion
  def concatenateString(aString: String, n: Int): String = {
    println(n)
    if (n <= 1)
      aString
    else aString + concatenateString(aString, n-1)
  }

  // Tail recursion
  @tailrec
  def ConcatenateTailrec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0)
      accumulator
    else ConcatenateTailrec(aString, n-1, aString + accumulator)
  }

  // 2
  /**
    Hàm isPrime(n: Int) nhận một số nguyên n là đối số và trả về một giá trị kiểu Boolean,
    nó là kết quả của việc kiểm tra xem n có phải là số nguyên tố hay không.

    @param n Số nguyên cần kiểm tra tính số nguyên tố.
    @return `true` nếu n là số nguyên tố, `false` nếu không phải.
  */
  def isPrime(n: Int): Boolean = {
    /*
      Hàm đệ quy isPrimeHelper tương ứng với việc kiểm tra số nguyên tố.

      @param t Tham số kiểm tra, giảm dần từ n/2 đến 1.
      @param isStillPrime Biến kiểm soát xem n vẫn có thể là số nguyên tố hay không. Ban đầu, nó được thiết lập thành true.
      @return `true` nếu n là số nguyên tố, `false` nếu không phải.
    */
    @scala.annotation.tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else {
        // Bước đệ quy tiếp theo: Giảm giá trị của `t` xuống 1 để kiểm tra số nguyên tố cho số nguyên dương nhỏ hơn.
        // Nếu `n` chia hết cho `t`, thì `n` không phải là số nguyên tố.
        // Biến `isStillPrime` kiểm soát xem `n` vẫn có thể là số nguyên tố hay không.
        // Trong biểu thức n % t != 0 && isStillPrime, nếu bất kỳ một trong hai điều kiện sau đây là false, thì toàn bộ biểu thức sẽ trả về false
        isPrimeHelper(t - 1, n % t != 0 && isStillPrime)
      }
    }

    isPrimeHelper(n / 2, true)
  }

  // Sử dụng hàm để kiểm tra số nguyên tố
  val result = isPrime(7) // Thay đổi số nguyên tố cần kiểm tra ở đây
  println(result)

  /**
   * Hàm tính số Fibonacci thứ n.
   *
   * @param n Số Fibonacci cần tính (vị trí).
   * @return Số Fibonacci thứ n.
   */
  def fibonacci(n: Int): Int = {
    /*
     * Hàm đệ quy để tính số Fibonacci thứ n.
     *
     * @param i          Vị trí hiện tại trong chuỗi Fibonacci.
     * @param last       Số Fibonacci tại vị trí i - 1.
     * @param nextToLast Số Fibonacci tại vị trí i - 2.
     * @return Số Fibonacci thứ n.
     */
    @scala.annotation.tailrec
    def fiboHelper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else {
        // Cập nhật last và nextToLast dựa trên quy luật Fibonacci.
        val newLast = last + nextToLast
        val newNextToLast = last
        fiboHelper(i + 1, newLast, newNextToLast)
      }
    }

    // Xử lý các trường hợp đặc biệt.
    if (n <= 2) 1
    else fiboHelper(2, 1, 1)
  }


}
