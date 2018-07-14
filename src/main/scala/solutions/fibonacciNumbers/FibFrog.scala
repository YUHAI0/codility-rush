package solutions.fibonacciNumbers

object FibFrog {

  def nextAvailable(current: Int, a: Array[Int], fib: Array[Int]): List[Int] = {
    if (current == a.length) {
      Nil
    } else if (fib(a.length - current) == 1) {
      List(a.length)
    } else {
      (current + 1 until a.length).filter(j => a(j) == 1 && fib(j - current) == 1).toList
    }
  }

  var minStep = 0
  var steps: Array[Int] = _

  def isSolution(steps: Array[Int], n: Int, fib: Array[Int]): Boolean = {
    var i = 0
    var prev = -1
//    println(steps.mkString(","))
    while (i < steps.length && (steps(i) - prev) > 0 && fib(steps(i) - prev) == 1) {
      prev = steps(i)
      i += 1
    }
    prev == n
  }

  def solutionStep(steps: Array[Int], n: Int): Int = steps.indexOf(n) + 1

  def search(current: Int, step: Int, a: Array[Int], fib: Array[Int]): Unit = {
    val nexts = nextAvailable(current, a, fib)
//    println(s"Available: ${nexts.mkString(",")}")
    if (minStep > 0 && step + 1 >= minStep)
      return
    for (next <- nexts) {
      steps(step) = next
      if (isSolution(steps, a.length, fib)) {
//        println(s"Solution: ${steps.mkString(",")}")
        if (minStep == -1) {
          minStep = solutionStep(steps, a.length)
        } else {
          minStep = math.min(minStep, solutionStep(steps, a.length))
        }
      } else {
        search(next, step + 1, a, fib)
      }
    }
  }

  def solution(a: Array[Int]): Int = {
    val n = a.length
    val fib = new Array[Int](n + 2)
    var f0 = 0
    var f1 = 1
    fib(0) = 1
    fib(1) = 1
    var fi = f0 + f1
    while (fi <= n + 1) {
      fib(fi) = 1
      f0 = f1
      f1 = fi
      fi = f0 + f1
    }
    steps = new Array[Int](n + 2)
//    step = 0
    minStep = -1
    search(-1, 0, a, fib)
    minStep
  }

  def main(args: Array[String]): Unit = {
    val cases = List(
      Array(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0),
      Array(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1)
    )
    cases.foreach(a=> {
      println(a.mkString(","))
      println(solution(a))
    })
  }

}
