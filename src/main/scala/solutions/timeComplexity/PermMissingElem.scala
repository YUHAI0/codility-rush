package solutions.timeComplexity

object PermMissingElem {

  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    (1 to a.length + 1).sum - a.sum
  }
}
