package me.naloaty.main.practice5.sort

abstract class ISort<T> (val c: Comparator<T>) {
    abstract fun sort(arr: Array<T>)
}