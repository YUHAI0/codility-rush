package solutions.sorting

object Triangle {

  def solution(a: Array[Int]): Int = {
    val sorted = a.filter(_ > 0).map(_.toLong).sorted
    (0 to sorted.length - 3).foreach(ai => {
      var bi = ai + 1
      while (bi < sorted.length - 1) {
        var inFlag = true
        var ci = bi + 1
        while (inFlag && ci < sorted.length) {
          if (sorted(ai) + sorted(bi) <= sorted(ci)) {
            inFlag = false
          } else if (sorted(ai) + sorted(ci) > sorted(bi)) {
            return 1
          } else {
            ci += 1
          }
        }
        bi += 1
      }
    })
    0
  }

}
