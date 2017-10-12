package solutions.stacksAndQueues

import scala.collection.mutable

object Fish extends App {

  def solution(a: Array[Int], b: Array[Int]): Int = {
    val downstream = new mutable.Stack[Int]
    val size = a.size
    var alive = 0
    (0 until size).foreach(i => {
      b(i) match {
        case 0 =>
          while (!downstream.isEmpty && downstream.top < a(i)) {
            downstream.pop
          }
          if (downstream.isEmpty) {
            alive += 1
          }
        case 1 =>
          downstream.push(a(i))
      }
    })
    alive += downstream.size
    alive
  }

}
