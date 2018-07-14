package solutions.primeAndCompositeNumbers

object CountFactors {

  def solution(n: Int): Int = {
    val sqrt = math.sqrt(n).toInt
    var count = 0
    for (i <- 2 to sqrt) {
      if (n % i == 0) {
        count += 2
      }
    }
    if (sqrt * sqrt == n) {
      count += 1
    } else {
      count += 2
    }
    count
  }

}
