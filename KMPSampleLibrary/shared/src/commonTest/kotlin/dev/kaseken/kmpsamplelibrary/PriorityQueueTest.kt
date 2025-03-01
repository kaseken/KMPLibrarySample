package dev.kaseken.kmpsamplelibrary

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class PriorityQueueTest {

  @Test
  fun testEmptyQueue() {
    val pq = PriorityQueue<Int> { a, b -> a - b }
    // Initially the queue should be empty.
    assertTrue(pq.isEmpty())
    assertNull(pq.peek())
    assertNull(pq.pop())
  }

  @Test
  fun testSingleElement() {
    val pq = PriorityQueue<Int> { a, b -> a - b }
    pq.push(10)
    // After one push, peek should return the element.
    assertEquals(10, pq.peek())
    // Popping should return the same element.
    assertEquals(10, pq.pop())
    assertTrue(pq.isEmpty())
  }

  @Test
  fun testMultipleElementsOrder() {
    val pq = PriorityQueue<Int> { a, b -> a - b }
    val numbers = listOf(5, 2, 8, 1, 3)
    numbers.forEach { pq.push(it) }

    // Expected order for a min-heap: smallest to largest.
    val expectedOrder = listOf(1, 2, 3, 5, 8)
    for (expected in expectedOrder) {
      assertEquals(expected, pq.pop())
    }
  }

  @Test
  fun testSize() {
    val pq = PriorityQueue<Int> { a, b -> a - b }
    assertEquals(0, pq.size())
    pq.push(1)
    assertEquals(1, pq.size())
    pq.push(2)
    assertEquals(2, pq.size())
    pq.pop()
    assertEquals(1, pq.size())
    pq.pop()
    assertEquals(0, pq.size())
  }

  @Test
  fun testCustomComparatorForMaxHeap() {
    // Create a max-heap by reversing the natural order.
    val pq = PriorityQueue<Int> { a, b -> b - a }
    val numbers = listOf(5, 2, 8, 1, 3)
    numbers.forEach { pq.push(it) }

    // Expected order for a max-heap: largest to smallest.
    val expectedOrder = listOf(8, 5, 3, 2, 1)
    for (expected in expectedOrder) {
      assertEquals(expected, pq.pop())
    }
  }
}
