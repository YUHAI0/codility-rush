package solutions.prefixSums

object GenomicRangeQuery {

  def valueOf(c: Char): Int = {
    c match {
      case 'A' => 1
      case 'C' => 2
      case 'G' => 3
      case 'T' => 4
    }
  }

  def findLeast(s: String, p: Int, q: Int): Int = {
    var least = valueOf(s.charAt(p))
    (p + 1 to q).foreach(m => {
      val value = valueOf(s.charAt(m))
      if (least > value) {
        least = value
      }
    })
    least
  }

  // 时间复杂度为0(N*M)
  def solution_fail_0(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    // write your code in Scala 2.12
    val result = new Array[Int](p.length)
    p.indices.foreach(m => {
      result(m) = findLeast(s, p(m), q(m))
    })
    result
  }

  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    // write your code in Scala 2.12
    val n = s.length
    val A = new Array[Int](n + 1)
    val C = new Array[Int](n + 1)
    val G = new Array[Int](n + 1)
    s.indices.foreach(ni => {
      A(ni + 1) = A(ni) + (if (s(ni) == 'A') 1 else 0)
      C(ni + 1) = C(ni) + (if (s(ni) == 'C') 1 else 0)
      G(ni + 1) = G(ni) + (if (s(ni) == 'G') 1 else 0)
    })
    val result = new Array[Int](p.length)
    p.indices.foreach(mi => {
      result(mi) =
        if (A(q(mi) + 1) - A(p(mi)) > 0) 1
        else if (C(q(mi) + 1) - C(p(mi)) > 0) 2
        else if (G(q(mi) + 1) - G(p(mi)) > 0) 3
        else 4
    })
    result
  }

}
