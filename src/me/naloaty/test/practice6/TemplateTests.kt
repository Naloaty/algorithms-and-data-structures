package me.naloaty.test.practice6

import me.naloaty.main.practice6.Template
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class TemplateTests {

    @Test
    fun test1() {
        val t = Template("Hello!")

        Assertions.assertEquals(6, t.shift('!'))
        Assertions.assertEquals(1, t.shift('o'))
        Assertions.assertEquals(2, t.shift('l'))
        Assertions.assertEquals(4, t.shift('e'))
        Assertions.assertEquals(5, t.shift('H'))
        Assertions.assertEquals(6, t.shift('@'))
    }

    @Test
    fun test2() {
        val t = Template("aaabbbccc")

        Assertions.assertEquals(1, t.shift('c'))
        Assertions.assertEquals(3, t.shift('b'))
        Assertions.assertEquals(6, t.shift('a'))
    }

    @Test
    fun test3() {
        val t = Template("abc1")

        Assertions.assertEquals('a', t[0])
        Assertions.assertEquals('b', t[1])
        Assertions.assertEquals('c', t[2])
        Assertions.assertEquals('1', t[3])
    }

    @Test
    fun test4() {
        val t = Template("Hi there!")

        Assertions.assertEquals(9, t.length)
    }

    @Test
    fun test5() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { Template("") }
    }

    @Test
    fun test6() {
        val t = Template("June")

        Assertions.assertEquals(4, t.shift('e'))
        Assertions.assertEquals(1, t.shift('n'))
        Assertions.assertEquals(2, t.shift('u'))
        Assertions.assertEquals(3, t.shift('J'))
        Assertions.assertEquals(4, t.shift('@'))
    }

}