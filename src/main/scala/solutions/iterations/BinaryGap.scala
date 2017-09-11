package solutions.iterations

object BinaryGap {
  def solution(n: Int): Int = {
    // write your code in Scala 2.12
    var maxSize = 0
    var inGap = false
    var gapSize = 0
    var quotient = n
    while (quotient > 0) {
      val left = quotient % 2
      quotient = quotient / 2

      left match {
        case 1 =>
          if (!inGap) {
            inGap = true
          } else {
            maxSize = Math.max(maxSize, gapSize)
            gapSize = 0
          }
        case 0 =>
          if (inGap) {
            gapSize += 1
          }
      }
    }
    maxSize
  }
}
