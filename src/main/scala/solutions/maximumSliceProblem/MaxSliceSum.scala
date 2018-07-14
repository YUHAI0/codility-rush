package solutions.maximumSliceProblem


object MaxSliceSum {

  def solution(a: Array[Int]): Int = {
    var max_ending = a(0)
    var max_result = a(0)
    for (i <- 1 until a.length) {
      val e = a(i)
      max_ending = math.max(max_ending + e, e)
      max_result = math.max(max_result, max_ending)
    }
    max_result
  }

}
