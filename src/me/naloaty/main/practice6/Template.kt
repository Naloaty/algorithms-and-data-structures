package me.naloaty.main.practice6

class Template(
    private val string: String
) {
    private val map: Map<Char, Int>

    val length: Int
        get() = string.length

    init {
        map = HashMap()

        if (length == 0)
            throw IllegalArgumentException("Template cannot be empty")

        for (i in (length - 2) downTo 0) {
            val ch = string[i]

            if (!map.containsKey(ch))
                map[ch] = (length - 1) - i
        }
    }

    fun shift(ch: Char): Int {
        return if (map.containsKey(ch))
            map[ch]!! else string.length
    }

    operator fun get(index: Int) = string[index]
}