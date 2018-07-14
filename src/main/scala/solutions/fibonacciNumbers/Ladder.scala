package solutions.fibonacciNumbers

object Ladder {

  def fibonacci_0(x: Int): Long = {
    val result = (math.pow((1 + math.sqrt(5)) / 2, x.toDouble) - math.pow((1 - math.sqrt(5)) / 2, x.toDouble)) / math.sqrt(5)
    result.toLong
  }

  // 会有大整数精度问题
  def solution_0(a: Array[Int], b: Array[Int]): Array[Int] = {
    a.indices.map(i => {
      val ia = a(i)
      val ib = b(i)
      val fib = ((math.pow((1 + math.sqrt(5)) / 2, (ia + 1).toDouble) -
        math.pow((1 - math.sqrt(5)) / 2, (ia + 1).toDouble)) /
        math.sqrt(5)).toLong % (1 << ib).toLong
      fib.toInt
    }).toArray
  }

  def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
    val l = a.length
    val result = new Array[Array[Int]](l+1)
    val exArr = new Array[Int](31)
    for (i <- 0 to 30) {
      exArr(i) = 1 << i
    }
    result(0) = Array()
    for (i <- 1 to l) {
      val perResult = new Array[Int](31)
      for (j <- 1 to 30) {
        val ex = exArr(j)
        if (i == 1) {
          perResult(j) = 1 % ex
        } else if (i == 2) {
          perResult(j) = 2 % ex
        } else {
          val perResult1 = result(i-1)
          val perResult2 = result(i-2)
          perResult(j) = (perResult1(j) + perResult2(j)) % ex
        }
      }
      result(i) = perResult
    }

    a.indices.map(k=> {
      val ka = a(k)
      val kb = b(k)
      result(ka)(kb)
    }).toArray
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(4, 4, 5, 5, 1), Array(3, 2, 4, 3, 1)).mkString("\t"))
  }

}
