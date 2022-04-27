package me.naloaty.test.practice5

import me.naloaty.main.practice5.sort.InclusionSort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions


class InclusionSortTests {

    private val s = InclusionSort<Int> { a, b -> a.compareTo(b) }

    @Test
    fun reversedTest() {
        val arr = arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        val expected = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        s.sort(arr)

        Assertions.assertArrayEquals(expected, arr)
    }

    @Test
    fun halfSortedTest() {
        val arr = arrayOf(1, 2, 3, 4, 5, 10, 9, 8, 7, 6)
        val expected = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        s.sort(arr)

        Assertions.assertArrayEquals(expected, arr)
    }

    @Test
    fun sortedTest() {
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val expected = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        s.sort(arr)

        Assertions.assertArrayEquals(expected, arr)
    }

    @Test
    fun negativeTest() {
        val arr = arrayOf(10, 9, 7, 6, -1, 5, -2, 4, -3, 8)
        val expected = arrayOf(-3, -2, -1, 4, 5, 6, 7, 8, 9, 10)

        s.sort(arr)

        Assertions.assertArrayEquals(expected, arr)
    }

    @Test
    fun allTheSameTest() {
        val arr = arrayOf(1, 1, 1, 1, 1)
        val expected = arrayOf(1, 1, 1, 1, 1)

        s.sort(arr)

        Assertions.assertArrayEquals(expected, arr)
    }
}