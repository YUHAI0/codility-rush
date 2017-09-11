package solutions.timeComplexity

object FrogJmp {

  def solution(x: Int, y: Int, d: Int): Int = {
    // write your code in Scala 2.12
    if ((y - x) % d == 0) (y - x) / d else (y - x) / d + 1
  }

}
