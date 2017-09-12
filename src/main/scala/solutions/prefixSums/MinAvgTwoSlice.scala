package solutions.prefixSums

object MinAvgTwoSlice {

  // 定理: 不可能出现大于３的slice为最小平均slice
  // 根据定理只需计算长度为2或3的slice即可
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val len = a.length
    var minAvg = (a(len - 1) + a(len - 2)) / 2.0
    var minIdx = len - 2
    (0 to len - 3).foreach(i => {
      val avg2 = (a(i) + a(i + 1)) / 2.0
      val avg3 = (a(i) + a(i + 1) + a(i + 2)) / 3.0
      if (avg2 == minAvg || avg3 == minAvg) {
        minIdx = math.min(i, minIdx)
      }
      if (avg2 < minAvg) {
        minAvg = avg2
        minIdx = i
      }
      if (avg3 < minAvg) {
        minAvg = avg3
        minIdx = i
      }
    })
    minIdx
  }

}
