package solutions.stacksAndQueues

import scala.collection.mutable

object Brackets {

  def solution(s: String): Int = {
    val stack = new mutable.Stack[Char]
    s.foreach{
      case '{' => stack.push('{')
      case '}' => if (stack.isEmpty || stack.pop() != '{') return 0
      case '(' => stack.push('(')
      case ')' => if (stack.isEmpty || stack.pop() != '(') return 0
      case '[' => stack.push('[')
      case ']' => if (stack.isEmpty || stack.pop() != '[') return 0
      case _ =>
        return 0
    }
    if (stack.isEmpty) 1 else 0
  }

}
