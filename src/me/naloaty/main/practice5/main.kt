package me.naloaty.main.practice5

import me.naloaty.main.practice5.sort.HeapSort
import me.naloaty.main.practice5.sort.InclusionSort

fun main() {
    val count = 100000
    val benchmark = Benchmark<Int>()

    val comp = Comparator<Int> { a, b -> a.compareTo(b) }
    benchmark.addSort("HeapSort", HeapSort(comp))
    benchmark.addSort("InclusionSort", InclusionSort(comp))

    val sorted = buildList {
        addAll(0..count)
    }

    val random = buildList {
        addAll(0..count)
        shuffle()
    }

    val reversed = buildList {
        addAll(0..count)
        reverse()
    }

    benchmark.addBundle("Sorted", sorted.toTypedArray())
    benchmark.addBundle("Random", random.toTypedArray())
    benchmark.addBundle("Reversed", reversed.toTypedArray())

    benchmark.measureAndPrint()

    /*
    *  | Criteria      | Sorted | Random | Reversed |
    *  | ------------- | ------ | ------ | -------- |
    *  | HeapSort      |  0.068 |  0.046 |    0.029 |
    *  | InclusionSort |  0.007 | 14.539 |   27.693 |
    * */
}