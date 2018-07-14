package solutions.maximumSliceProblem

object MaxDoubleSliceSum extends App {

  def solution(a: Array[Int]): Int = {
    var x = a(0)
    var y = a(1)
    var z = a(2)
    var maxEnd = 0
    var maxSlice = 0
    (3 until a.length).foreach(i=> {
      maxEnd = Math.max(maxEnd + Math.max(y, z), 0)
      val ny = Math.min(y, z)
//      if (ny != y && maxEnd > 0) {
//        maxEnd = math.max(maxEnd, maxEnd - y)
//      }
      y = ny
      z = a(i)

      maxSlice = Math.max(maxSlice, maxEnd)
    })
    maxSlice
  }

  println(solution(Array(3, 2, 6, -1, 4, 5, -1, 2)))
  println(solution(Array(1, -2, 6, -1, 4, -5, -1, -2)))

}
