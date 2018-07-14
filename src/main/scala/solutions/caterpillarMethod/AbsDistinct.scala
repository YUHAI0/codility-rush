package solutions.caterpillarMethod

object AbsDistinct {

  def solution(a: Array[Int]): Int = {
    a.map(math.abs).distinct.length
  }

}
