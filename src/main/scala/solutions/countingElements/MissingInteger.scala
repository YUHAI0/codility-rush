package solutions.countingElements

object MissingInteger {

  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val exists: Array[Int] = new Array[Int](1000001)
    a.filter(_ > 0).foreach(e => {
      exists(e) = 1
    })
    (1 to exists.length).find(i=>exists(i) != 1).getOrElse(1000001)
  }
}
