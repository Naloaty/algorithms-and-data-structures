package me.naloaty.main.practice5.sort

class InclusionSort<T>(c: Comparator<T>) : ISort<T>(c) {

    override fun sort(arr: Array<T>) {
        for (i in 1 until arr.size) {
            val value = arr[i]
            var index = i

            // arr[index - 1] > value
            while (index > 0 && c.compare(arr[index - 1], value) >= 1) {
                arr[index] = arr[index - 1]
                index--
            }

            arr[index] = value
        }
    }
}