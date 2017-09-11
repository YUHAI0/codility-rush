package solutions.countingElements

object PermCheck {

  //要求: 时间复杂度O(N) 空间复杂度O(N)

  // 此解复杂度最差情况下为O(N*N)
  def solution_0(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val exists: Array[Int] = new Array[Int](100000)
    a.foreach(e => {
      if (e > 0 && e <= 100000) {
        exists(e - 1) = 1
      }
    })
    var i = 0
    while (exists(i) == 1) {
      i += 1
    }
    if (i == a.length) 1 else 0
  }

  // 正确的解
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val size = a.length
    val exists: Array[Int] = new Array[Int](size+1)
    var result = 1
    var total = 0
    a.foreach(e => {
      if (e > 0 && e <= size) {
        exists(e) = exists(e) + 1
        if (exists(e) > 1)
          result = 0
        total += e
      }
    })
    if (result == 0) 0 else if (total == (1 + size) * size / 2) 1 else 0
  }

}
