package solutions.maximumSliceProblem

object MaxProfit {

  def solution(a: Array[Int]): Int = {
    var max_profit = 0
    var result =0

    for (i <- 1 until a.length) {
      val e = a(i)
      val b = a(i-1)
      val min = math.min(b - max_profit, b)
      max_profit = e - min
      result = math.max(result, max_profit)
    }
    if (result < 0) 0
    else result
  }

}
