package me.naloaty.test.practice6

import me.naloaty.main.practice6.binarySearch
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class BinarySearchTests {

    @Test
    fun emptyArray1() {
        Assertions.assertEquals(-1, binarySearch(emptyArray(), -15))
    }

    @Test
    fun emptyArray2() {
        Assertions.assertEquals(-1, binarySearch(emptyArray(), 15))
    }

    @Test
    fun emptyArray3() {
        Assertions.assertEquals(-1, binarySearch(emptyArray(), 0))
    }

    @Test
    fun outLeft() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(-1, binarySearch(arr, -15))
    }

    @Test
    fun boundLeft() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(0, binarySearch(arr, 1))
    }

    @Test
    fun outRight() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(-1, binarySearch(arr, 15))
    }

    @Test
    fun boundRight() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(7, binarySearch(arr, 6))
    }

    @Test
    fun outMiddle() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(-1, binarySearch(arr, 4))
    }

    @Test
    fun singleEntry1() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(1, binarySearch(arr, 2))
    }

    @Test
    fun singleEntry2() {
        val arr = arrayOf(10, 15, 20, 25, 30)
        Assertions.assertEquals(2, binarySearch(arr, 20))
    }

    @Test
    fun multiEntry2() {
        val arr = arrayOf(1, 2, 3, 3, 3, 5, 5, 6)
        Assertions.assertEquals(5, binarySearch(arr, 5))
    }

    @Test
    fun multiEntry3() {
        val arr = arrayOf(1, 1, 2, 2, 2, 3, 3, 3, 4)
        Assertions.assertEquals(5, binarySearch(arr, 3))
    }

    @Test
    fun singleElementArray1() {
        val arr = arrayOf(1)
        Assertions.assertEquals(0, binarySearch(arr, 1))
    }

    @Test
    fun singleElementArray2() {
        val arr = arrayOf(1)
        Assertions.assertEquals(-1, binarySearch(arr, -15))
    }

    @Test
    fun negativeBoundLeft() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(0, binarySearch(arr, -8))
    }

    @Test
    fun negativeBoundRight() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(6, binarySearch(arr, -1))
    }

    @Test
    fun negativeOutLeft() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(-1, binarySearch(arr, -15))
    }

    @Test
    fun negativeOutRight() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(-1, binarySearch(arr, 0))
    }

    @Test
    fun negativeOutMiddle() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(-1, binarySearch(arr, -4))
    }

    @Test
    fun negativeSingleEntry() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(2, binarySearch(arr, -5))
    }

    @Test
    fun negativeMultiEntry() {
        val arr = arrayOf(-8, -6, -5, -3, -3, -2, -1)
        Assertions.assertEquals(3, binarySearch(arr, -3))
    }
}