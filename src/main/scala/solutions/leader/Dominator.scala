package solutions.leader

object Dominator {

  def solution(a: Array[Int]): Int = {
    var deep = 0
    var top = 0
    a.foreach(ele => {
      if (deep == 0) {
        top = ele
        deep += 1
      } else if (top == ele) {
        deep += 1
      } else {
        deep -= 1
      }
    })
    if (deep == 0) {
      -1
    } else {
      var count = 0
      var result = -1
      a.indices.foreach(i => {
        val ele = a(i)
        if (ele == top) {
          result = i
          count += 1
        }
      })
      if (count > a.length / 2) {
        result
      } else {
        -1
      }
    }
  }

}
