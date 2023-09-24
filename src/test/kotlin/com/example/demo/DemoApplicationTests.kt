package com.example.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.springframework.boot.test.context.SpringBootTest
import com.example.demo.services.BubbleOp

@SpringBootTest
class DemoApplicationTests {

	@Test
	fun contextLoads() {
		Assertions.assertEquals(2, 1 + 1)
	}

	@Test
	fun testBubble() {
		var service = BubbleOp()
		val expected = intArrayOf(1,2,3,4,5,6,7,8,9,10)
		val unsorted = intArrayOf(10,6,4,3,5,2,8,7,9,1)
		val sorted = service.sort(unsorted)
		Assertions.assertArrayEquals(expected, sorted)
	}

	@Test
	fun testBubbleDesc() {
		var service = BubbleOp()
		val expected = intArrayOf(10,9,8,7,6,5,4,3,2,1)
		val unsorted = intArrayOf(10,6,4,3,5,2,8,7,9,1)
		val sorted = service.sortDesc(unsorted)
		Assertions.assertArrayEquals(expected, sorted)
	}


	@Test
	fun testBubbleDescDumb() {
		var service = BubbleOp()
		val expected = intArrayOf(10,9,8,7,6,5,4,3,2,1)
		val unsorted = intArrayOf(10,6,4,3,5,2,8,7,9,1)
		val sorted = service.sortDescDumb(unsorted)
		Assertions.assertArrayEquals(expected, sorted)
	}


}
