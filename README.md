# SCALA TUTORIAL

## A. Compare with Python

1. **Syntax and Data Types:**
   - Python: Dynamic typing, no type declarations required.
   - Scala: Static typing, type declarations are required.

2. **Object-Oriented and Functional Programming:**
   - Python: Supports both but often considered an object-oriented language.
   - Scala: Strongly supports both paradigms.

3. **Performance:**
   - Python: Slower due to dynamic typing and automatic memory management.
   - Scala: Typically faster due to static typing and optimization.

4. **Community and Libraries:**
   - Python: Large and extensive community with many libraries and frameworks.
   - Scala: Smaller community with a focus on high-performance and scalability.

5. **Use Cases:**
   - Python: Web development, data processing, AI, data science.
   - Scala: High-performance applications, distributed systems, enterprise applications.

6. **Development Environment:**
   - Python: Various IDEs like PyCharm, VSCode, Jupyter Notebook.
   - Scala: IDEs like IntelliJ IDEA and VSCode.

Choose between Python and Scala based on your project goals and application requirements.

```markdown
If you're working with Scala in a .scala file (as opposed to a Scala worksheet or REPL environment), 
you need to put your code inside an object and include a main method for it to be executable.
```
## B. Basic syntax
### 1. Hello World:
Đây là một ví dụ đơn giản về cách in ra chuỗi "Hello, World!" trong Scala.

```scala
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}
```

### 2. Biến và Kiểu dữ liệu:
Scala là một ngôn ngữ kiểu tĩnh, điều này có nghĩa rằng bạn cần xác định kiểu dữ liệu của biến trước khi sử dụng chúng.

```scala
val number: Int = 42
val name: String = "John"

println(s"My name is $name and I'm $number years old.")
```

### 3. Hàm:
Đây là một ví dụ về cách định nghĩa và sử dụng hàm trong Scala.

```scala
def add(a: Int, b: Int): Int = {
  a + b
}

val result = add(5, 3)
println(s"5 + 3 = $result")
```

### 4. Class (Lớp):
Lớp trong Scala là một khuôn mẫu định nghĩa cấu trúc dữ liệu và hành vi của các đối tượng. Nó có thể chứa các thuộc tính (biến thành viên) và phương thức (hàm thành viên) để thực hiện các hoạt động trên dữ liệu.

```scala
class Person(name: String, age: Int) {
  def introduce(): Unit = {
    println(s"My name is $name and I'm $age years old.")
  }
}
```

### 5. Object (Đối tượng):
Đối tượng trong Scala là một phiên bản duy nhất của một lớp và thường được sử dụng để lưu trữ hằng số hoặc triển khai các phương thức tiện ích.

```scala
object Constants {
  val pi = 3.14159
  val gravity = 9.81
}
```
Ví dụ sử dụng lớp và đối tượng: Đây là ví dụ sử dụng lớp Person và đối tượng Constants:
```scala
// Sử dụng lớp Person
val person = new Person("John", 30)
person.introduce()

// Sử dụng đối tượng Constants
println(s"The value of pi is ${Constants.pi}")
println(s"The acceleration due to gravity is ${Constants.gravity} m/s²")
```
Trong ví dụ này, chúng ta tạo một đối tượng person từ lớp Person và sử dụng đối tượng Constants để truy cập các hằng số.

### 6. Câu lệnh điều kiện:
Scala sử dụng if và else để thực hiện câu lệnh điều kiện.

```scala
val age = 18

if (age >= 18) {
  println("You are an adult.")
} else {
  println("You are not yet an adult.")
}
```

### 7. Vòng lặp:
Scala có nhiều cách để thực hiện vòng lặp, nhưng thường bạn sẽ sử dụng for và while. Dưới đây là một ví dụ về vòng lặp for.

```scala
for (i <- 1 to 5) {
  println(s"Iteration $i")
}
```

### 8. Collection (Danh sách):
Scala có nhiều loại collection như List, Set và Map. Dưới đây là một ví dụ về cách sử dụng danh sách.

```scala
val numbers = List(1, 2, 3, 4, 5)

val doubledNumbers = numbers.map(_ * 2)

println(s"Original numbers: $numbers")
println(s"Doubled numbers: $doubledNumbers")
```

## C. Some note when using Scala
### 1. Do not use While loop in Scala - Functional programing
- Immutability & Readability: Avoid while loops in favor of functional constructs like for comprehensions and recursion for improved immutability and code clarity.

- Safety & Maintainability: Prefer functional methods and expressions to prevent infinite loops and off-by-one errors, ensuring safer and more maintainable code.

- Conciseness & Parallelism: Functional programming constructs enable concise code, better parallelization, and improved performance in Scala applications, particularly in multi-core environments.


# GIẢI THÍCH RECURSION

Tại sao lại nhắc đến đệ quy đuôi trong Scala?
Hãy tưởng tượng một hàm đệ quy đuôi khi chạy hết các hàm tính toán của nó và sẵn sàng để gọi đệ quy. \
Tại thời điểm này chúng ta đâu còn cần những biến cục bộ nữa vì chúng đã được tính toán ở trên hết rồi. \
Chúng ta không cần biết đang ở lớp nào của đệ quy nữa. Vì vậy trong Scala, đệ quy đuôi được tinh chỉnh để ngăn chặn \
sự tạo mới của những khung bộ nhớ mới thay vào đó tái sử dụng khung bộ nhớ cũ trong call stack. Và call stack không \
bao giờ bị đầy lên ngay cả khi đệ quy rất nhiều lần. Điều này tạo nên sự đặc biệt của đệ quy đuôi trong Scala. \
Trong một số ngôn ngữ khác cũng áp dụng ý tưởng này tuy nhiên sẽ xử lý bằng cách biến đệ quy thành dạng các vòng lặp \
cơ bản hay còn gọi là khử đệ quy. Và điều này không thể áp dụng được với đệ quy đầu. Vì các phép tính được thực hiện sau \
khi gọi đệ quy vì chúng ta cần các biến cục bộ đó.


Đệ quy đầu sẽ là:

``` scala
def sum(x)
   if x == 1
      return x
   else
      return x + sum(x - 1)
   end
end
```

Khi chạy chương trình sẽ được thực hiện như sau:

``` scala
sum(5)
5 + sum(4)
5 + (4 + sum(3))
5 + (4 + (3 + sum(2)))
5 + (4 + (3 + (2 + sum(1))))
5 + (4 + (3 + (2 + 1)))
15
``` 

Lúc gọi sum(5), chương trình phải tính toán sum(4) trước nên sum(5) sẽ được lưu lại trong call stack, sum(4) được gọi, cứ như vậy sum(5), sum(4), sum(3), sum(2) sẽ được lưu lại trong call stack, đến khi sum(1) được gọi trả về kết quả, sum(2), sum(3), sum(4), sum(5) mới được gọi ra từ call stack và trả về kết quả.

Còn đệ quy đuôi sẽ là:
``` scala
def sum(x, running_total=0):
   if x == 0
      return running_total
   else
      return sum(x - 1, running_total + x)
   end
end
```

Kết quả chạy:
``` scala
sum(5, 0)
sum(4, 5)
sum(3, 9)
sum(2, 12)
sum(1, 14)
sum(0, 15)
15
``` 