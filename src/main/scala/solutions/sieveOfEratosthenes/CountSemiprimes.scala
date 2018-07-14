package solutions.sieveOfEratosthenes

object CountSemiprimes {

  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {
    val semis = Array.fill[Int](n + 1)(0)
    val primes = Array.fill[Int](n + 1)(0)
    val semiSum = Array.fill[Int](n + 2)(0)
    val m = p.length
    var i = 2
    while (i * i <= n) {
      var k = i * i
      while (k <= n) {
        primes(k) = 1
        k += i
      }
      i += 1
    }

    i = 2
    while (i * i <= n) {
      var k = i * i
      if (primes(i) == 0) {
        while (k <= n) {
          if (primes(k / i) == 0) {
            semis(k) = 1
          }
          k += i
        }
      }
      i += 1
    }

    var acc = 0
    for (i <- 1 to n) {
      if (semis(i) == 1) {
        acc += 1
      }
      semiSum(i + 1) = acc
    }

    val result = new Array[Int](m)
    for (j <- 0 until m) {
      val left = p(j)
      val right = q(j)
      result(j) = semiSum(right + 1) - semiSum(left)
    }

    result
  }

}
