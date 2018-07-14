package solutions.caterpillarMethod

object CountTriangles {

  def solution(a: Array[Int]): Int = {
    val sorted = a.sorted
    val n = sorted.length
    var count = 0
    for (p <- 0 to n - 3) {
      for (q <- p + 1 to n - 2) {
        var r = q + 1
        while (r < n && sorted(p) + sorted(q) > sorted(r)) {
          r += 1
        }
        if (r == n || sorted(p) + sorted(q) <= sorted(r)) {
          count += r - q - 1
        }
      }
    }
    count
  }

}
