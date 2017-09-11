package solutions.countingElements

object MaxCounters {

  // lastIsMaxCount 用于减少max counter 操作，如果没有该变量会出现超时case
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    // write your code in Scala 2.12
    val result = new Array[Int](n)
    var max = 0
    var lastIsMaxCount = false
    a.foreach {
      case i if i <= n && i > 0 =>
        result(i - 1) += 1
        max = Math.max(max, result(i - 1))
        lastIsMaxCount = false
      case m if m == n + 1 =>
        if (!lastIsMaxCount) {
          result.indices.foreach { j =>
            result(j) = max
          }
          lastIsMaxCount = true
        }
    }
    result
  }

}
