package dev.kaseken.kmpsampleandroidapp.utils

import dev.kaseken.kmpsamplelibrary.PriorityQueue

object PriorityQueueUtil {
  fun pickMinimum(array: List<Int>): Int? {
    val pq = PriorityQueue<Int> { a, b -> a - b }
    array.forEach { pq.push(it) }
    return pq.pop()
  }
}
