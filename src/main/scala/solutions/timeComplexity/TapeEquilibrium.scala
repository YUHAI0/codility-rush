package solutions.timeComplexity

object TapeEquilibrium {

  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    var lastLeft = 0
    var lastRight = a.sum
    var min = -1
    (1 until a.length).foreach(p => {
      val abs = Math.abs(lastLeft - lastRight + 2 * a(p - 1))
      min = if (min == -1) abs else Math.min(min, abs)
      lastLeft = lastLeft + a(p -1)
      lastRight = lastRight - a(p - 1)
    })
    min
  }

}
