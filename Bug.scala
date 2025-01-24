```scala
class MyClass[T](val value: T) {
  def myMethod(other: MyClass[T]): T = {
    value match {
      case s: String => s + other.value
      case i: Int => i + other.value
      case _ => throw new IllegalArgumentException("Unsupported type")
    }
  }
}

object Main extends App {
  val str1 = new MyClass("Hello")
  val str2 = new MyClass(" World")
  println(str1.myMethod(str2)) // Works fine

  val int1 = new MyClass(1)
  val int2 = new MyClass(2)
  println(int1.myMethod(int2)) // Works fine

  val mixed1 = new MyClass(1)
  val mixed2 = new MyClass("hello")
  println(mixed1.myMethod(mixed2)) // Compilation error
}
```