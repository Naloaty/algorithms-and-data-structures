package me.naloaty.main.practice5.sort

class HeapSort<T>(c: Comparator<T>): ISort<T>(c) {

    private fun swap(arr: Array<T>, i: Int, j: Int) {
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }

    private fun heapify(arr: Array<T>, s: Int, i: Int) {
        var largest = i
        val l = (2 * i) + 1
        val r = (2 * i) + 2

        if (l < s && c.compare(arr[l], arr[largest]) >= 1)
            largest = l

        if (r < s && c.compare(arr[r], arr[largest]) >= 1)
            largest = r

        if (largest != i) {
            swap(arr, i, largest)
            heapify(arr, s, largest)
        }
    }

    override fun sort(arr: Array<T>) {
        for (i in (arr.size / 2 - 1) downTo 0)
            heapify(arr, arr.size, i)

        for (i in (arr.size - 1) downTo 1) {
            swap(arr, 0, i)
            heapify(arr, i, 0)
        }
    }
}