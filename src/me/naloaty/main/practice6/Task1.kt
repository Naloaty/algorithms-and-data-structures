package me.naloaty.main.practice6

import kotlin.random.Random

fun binarySearch(arr: Array<Int>, x: Int): Int {
    var l = 0
    var r = arr.size - 1
    var m: Int

    while (l < r) {
        m = l + (r - l) / 2
        println("l: $l, r: $r, m: $m")

        if (x <= arr[m])
            r = m
        else
            l = m + 1
    }

    return if (r >= 0 && arr[r] == x) r else -1
}

fun main() {
    // Array init
    print("Array size: ")
    val size = readln().toInt()

    val array = Array(size) { Random.nextInt(0, 10) }
    array.sort()
    println("Generated array: ${array.joinToString(prefix = "[", postfix = "]")}")

    // Value search
    print("Search value: ")
    val value = readln().toInt()
    var i = binarySearch(array, value)

    val indexes = ArrayList<Int>()

    if (i != -1) {
        indexes.add(i++)

        while (i < array.size && array[i] == value)
            indexes.add(i++)
    }

    // Printing result
    println("Indexes: ${indexes.size} ${indexes.joinToString(prefix = "(", postfix = ")")}")
}