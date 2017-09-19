package solutions.sorting

object MaxProductOfThree {

  def solution(a: Array[Int]): Int = {
    val sorted = a.sorted
    val size = sorted.length
    Math.max(sorted(0) * sorted(1) * sorted(size - 1), sorted(size - 1) * sorted(size - 2) * sorted(size - 3))
  }
  
}
