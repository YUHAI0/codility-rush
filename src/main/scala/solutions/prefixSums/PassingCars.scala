package solutions.prefixSums

object PassingCars {
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    var oneCount = 0
    (a.length - 1 to 0 by -1).foreach { i: Int => {
      a(i) match {
        case 1 =>
          oneCount += 1
          a(i) = 0
        case 0 =>
          a(i) = oneCount
      }
    }
    }
    var result: Long = 0
    a.indices.foreach(i => {
      result += a(i)
    })
    if (result > 1000000000L) {
      -1
    } else {
      result.toInt
    }
  }
}
