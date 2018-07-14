package solutions.primeAndCompositeNumbers

object MinPerimeterRectangle {

  def solution(n: Int): Int = {
    var a = math.sqrt(n).toInt
    while (a > 0) {
      if (n % a == 0) {
        return 2 * (n / a + a)
      }
      a -= 1
    }
    -1
  }

}
