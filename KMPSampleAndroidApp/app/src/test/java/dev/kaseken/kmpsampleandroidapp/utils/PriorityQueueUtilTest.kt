package dev.kaseken.kmpsampleandroidapp.utils

import org.junit.Assert
import org.junit.Test

class PriorityQueueUtilTest {
  @Test
  fun testPickMinimum() {
    Assert.assertEquals(1, PriorityQueueUtil.pickMinimum(listOf(1, 2, 5, 7, 10)))
  }
}
