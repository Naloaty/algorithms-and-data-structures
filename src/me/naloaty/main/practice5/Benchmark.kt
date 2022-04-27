package me.naloaty.main.practice5

import me.naloaty.main.practice5.sort.ISort
import me.naloaty.main.table.MyTable
import kotlin.system.measureTimeMillis

class Benchmark<T> {

    class Bench<T> (val name: String, val sort: ISort<T>)
    class Bundle<T> (val name: String, val values: Array<T>)

    private val benches: MutableList<Bench<T>> = ArrayList<Bench<T>>()
    private val bundles: MutableList<Bundle<T>> = ArrayList<Bundle<T>>()

    fun addSort(name: String, sort: ISort<T>) {
        benches.add(Bench(name, sort))
    }

    fun addBundle(name: String, values: Array<T>) {
        bundles.add(Bundle(name, values))
    }

    fun measureAndPrint() {
        val table = MyTable()
        table.addColumn("Criteria")

        for (bundle in bundles)
            table.addColumn(bundle.name, MyTable.Align.RIGHT)

        for (bench in benches) {
            val cols = ArrayList<String>()
            cols.add(bench.name)

            for (bundle in bundles) {
                val array = bundle.values.clone()

                val timeInMillis = measureTimeMillis {
                    bench.sort.sort(array)
                }

                cols.add((timeInMillis / 1000f).toString())
            }

            table.addRow(cols)
        }

        println(table)
    }
}