package solutions.countingElements

import scala.collection.mutable


object FrogRiverOne {

  def solution(x: Int, a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val leafSets = mutable.HashSet.empty[Int]
    var t = 0
    while (t < a.length) {
      if (a(t) > 0 && a(t) <= x)
      leafSets.add(a(t))
      if (leafSets.size == x) {
        return t
      }
      t += 1
    }
    -1
  }

}
