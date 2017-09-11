package solutions.arrays

import scala.collection.mutable

object OddOccurrencesInArray {

  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val paired: mutable.HashMap[Int, Int] = new mutable.HashMap[Int, Int]()
    a.foreach(e => {
      if (!paired.contains(e)) {
        paired.put(e, 1)
      } else {
        paired.put(e, paired(e) + 1)
      }
    })
    paired.keySet.foreach(key=>{
      if (paired(key) % 2 == 1) {
        return key
      }
    })
    0
  }

}
