package solutions.stacksAndQueues

import scala.collection.mutable

object StoneWall {

  def solution(h: Array[Int]): Int = {
    val stack = new mutable.Stack[Int]()
    var blockCount = 0
    h.foreach(e=> {
      if (stack.isEmpty || e > stack.top) {
        stack.push(e)
      } else if (e < stack.top) {
        while (stack.nonEmpty && e < stack.top) {
          stack.pop()
          blockCount += 1
        }
        if (stack.isEmpty || e > stack.top) {
          stack.push(e)
        }
      }
    })
    blockCount += stack.size
    blockCount
  }

}
