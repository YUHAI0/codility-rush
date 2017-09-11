package solutions.arrays

object CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    // write your code in Scala 2.12
    val size = a.length
    val result = new Array[Int](size)
    a.indices.foreach(i=>{
      val newIndex = (i + k) % size
      result(newIndex) = a(i)
    })
    result
  }
}
