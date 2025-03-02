package dev.kaseken.kmpsamplelibrary

class PriorityQueue<T: Comparable<T>>(private val comparator: (T, T) -> Int) {
  private val heap = mutableListOf<T>()

  fun isEmpty(): Boolean = heap.isEmpty()

  fun size(): Int = heap.size

  fun peek(): T? = heap.firstOrNull()

  fun push(element: T) {
    heap.add(element)
    siftUp(heap.lastIndex)
  }

  fun pop(): T? {
    if (heap.isEmpty()) return null
    return if (heap.size == 1) {
      heap.removeAt(0)
    } else {
      val result = heap[0]
      heap[0] = heap.removeAt(heap.lastIndex)
      siftDown(0)
      result
    }
  }

  private fun siftUp(index: Int) {
    var i = index
    while (i > 0) {
      val parent = (i - 1) / 2
      if (comparator(heap[i], heap[parent]) >= 0) break
      heap.swap(i, parent)
      i = parent
    }
  }

  private fun siftDown(index: Int) {
    var i = index
    while (true) {
      val left = 2 * i + 1
      val right = 2 * i + 2
      var smallest = i

      if (left < heap.size && comparator(heap[left], heap[smallest]) < 0) {
        smallest = left
      }
      if (right < heap.size && comparator(heap[right], heap[smallest]) < 0) {
        smallest = right
      }
      if (smallest == i) break

      heap.swap(i, smallest)
      i = smallest
    }
  }

  private fun MutableList<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
  }
}
