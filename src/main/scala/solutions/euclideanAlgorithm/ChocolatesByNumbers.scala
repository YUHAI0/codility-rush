package solutions.euclideanAlgorithm

object ChocolatesByNumbers {

  //  空间复杂度O(N)　不满足O(Log(M+N))
  def solution_0(n: Int, m: Int): Int = {
    val ring = new Array[Int](n)
    var count = 0
    var i = 0
    while (ring(i) != 1) {
      ring(i) = 1
      count += 1
      i = (i + m) % n
    }
    count
  }

  def solution(n: Int, m: Int): Int = {
    val cd = gcd(n, m)
    ((n.toLong * m) / (m.toLong * cd)).toInt
  }

  def gcd(a: Int, b: Int): Int = {
    if (a % b == 0) {
      b
    } else {
      gcd(b, a % b)
    }
  }

}
