package solutions.sorting

import java.util

object NumberOfDiscIntersections {

  // O(N**2)
  def solution_fail0(a: Array[Int]): Int = {
    val rangeWithSize = a.zipWithIndex.map {
      case (e, i) => ((i - e).toLong, (i + e).toLong, 2 * e.toLong)
    }
    var pairs = 0
    (0 to rangeWithSize.length - 2).foreach(j => {
      var k = j + 1
      while (k < rangeWithSize.length) {
        val left = rangeWithSize(j)
        val right = rangeWithSize(k)
        if (Math.max(left._2, right._2) - Math.min(left._1, right._1) <= left._3 + right._3) {
          pairs += 1
        }
        k += 1
      }
    })
    pairs
  }

  // O(N**2)
  def solution_fail1(a: Array[Int]): Int = {
    val rangeWithSize = a.zipWithIndex.map {
      case (e, i) => ((i - e).toLong, (i + e).toLong, 2 * e.toLong)
    }
    val size = rangeWithSize.length
    var exclude = 0
    (0 to size - 2).foreach(j => {
      val jRight = rangeWithSize(j)._2

      (j until size).foreach(k => {
        if (rangeWithSize(k)._1 > jRight) {
          exclude += 1
        }
      })
    })
    size * (size - 1) / 2 - exclude
  }

  //algorithm description https://rafal.io/posts/codility-intersecting-discs.html
  def solution(a: Array[Int]): Int = {
    val arrI = new Array[Long](a.length)
    val arrJ = new Array[Long](a.length)
    a.indices.foreach(idx => {
      arrI(idx) = a(idx).toLong + idx
      arrJ(idx) = -a(idx).toLong + idx
    })
    val size = a.length.toLong
    var result = 0L
    util.Arrays.sort(arrJ)
    arrI.foreach { iv =>
      var si = util.Arrays.binarySearch(arrJ, iv)
      if (si >= 0) {
        while (si < size && arrJ(si) == iv) {
          si += 1
        }
        result += si
      } else {
        result += -si - 1
      }
    }
    val sub =  (size - 1) * size / 2 + size
    result -= sub
    if (result > 10000000) -1 else result.toInt
  }

}
