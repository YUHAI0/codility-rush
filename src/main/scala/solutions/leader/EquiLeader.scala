package solutions.leader

object EquiLeader extends App {

  def findLeader(a: Array[Int]): (Integer, Integer) = {
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
      (null, null)
    } else {
      var count = 0
      a.foreach(ele => {
        if (ele == top) {
          count += 1
        }
      })
      if (count > a.length / 2) {
        (top, count)
      } else {
        (null, null)
      }
    }
  }

  def solution(a: Array[Int]): Int = {
    val (leader, count) = findLeader(a)
    if (leader == null) {
      return 0
    }
    var result = 0
    var leaderCount = 0
    a.indices.foreach(i => {
      val ele = a(i)
      val left = i + 1
      val right = a.length - left
      if (ele == leader) {
        leaderCount += 1
      }
      if (leaderCount > left / 2 && count - leaderCount > right / 2) {
        result += 1
      }
    })
    result
  }

}
