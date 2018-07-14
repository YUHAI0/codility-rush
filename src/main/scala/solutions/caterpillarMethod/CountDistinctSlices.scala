package solutions.caterpillarMethod

object CountDistinctSlices {

  def solution(m: Int, a: Array[Int]): Int = {
    var count = 0
    val n = a.length
    val exists: Array[Int] = new Array[Int](m+1)
    var front = 0
    for (end <- a.indices) {
      while(front < n && exists(a(front)) == 0) {
        exists(a(front)) = 1
        front += 1
      }
      count += front - end
      exists(a(end)) = 0
    }
    count
  }

}
