package me.naloaty.test.practice6

import me.naloaty.main.practice6.Template
import me.naloaty.main.practice6.bmFind
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BMSearchTests {

    @Test
    fun middleTest() {
        val source = "Hello, world!"
        val template = Template("wor")

        Assertions.assertEquals(7, bmFind(source, template))
    }

    @Test
    fun leftBoundTest() {
        val source = "Hello, world!"
        val template = Template("Hel")

        Assertions.assertEquals(0, bmFind(source, template))
    }

    @Test
    fun rightBoundTest() {
        val source = "Hello, world!"
        val template = Template("ld!")

        Assertions.assertEquals(10, bmFind(source, template))
    }

    @Test
    fun noMatchTest() {
        val source = "Hello, world!"
        val template = Template("Kek")

        Assertions.assertEquals(-1, bmFind(source, template))
    }

    @Test
    fun singleCharMiddleTest() {
        val source = "Hello, world!"
        val template = Template(",")

        Assertions.assertEquals(5, bmFind(source, template))
    }

    @Test
    fun singleCharLeftBoundTest() {
        val source = "Hello, world!"
        val template = Template("H")

        Assertions.assertEquals(0, bmFind(source, template))
    }

    @Test
    fun singleCharRightBoundTest() {
        val source = "Hello, world!"
        val template = Template("!")

        Assertions.assertEquals(12, bmFind(source, template))
    }

    @Test
    fun fullLengthTest() {
        val source = "Hello, world!"
        val template = Template("Hello, world!")

        Assertions.assertEquals(0, bmFind(source, template))
    }

    @Test
    fun overLengthTest() {
        val source = "Hello, world!"
        val template = Template("Hello, world!)))")

        Assertions.assertEquals(-1, bmFind(source, template))
    }

    @Test
    fun extra1() {
        val source = "First published on June 26, 1997. His entire "
        val template = Template("June")

        Assertions.assertEquals(19, bmFind(source, template))
    }

    @Test
    fun extra2() {
        val source = "Harry Potter and the Philosopher's"
        val template = Template("and")

        Assertions.assertEquals(13, bmFind(source, template))
    }

    @Test
    fun extra3() {
        val source = "Stone is a famous fantasy novel by J. K. Rowling."
        val template = Template("a famous")

        Assertions.assertEquals(9, bmFind(source, template))
    }

    @Test
    fun extra4() {
        val source = "childhood, the protagonist, Harry Potter,"
        val template = Template("Potter")

        Assertions.assertEquals(34, bmFind(source, template))
    }

    @Test
    fun extra5() {
        val source = "lives with his uncle's family, as his parents"
        val template = Template("his")

        Assertions.assertEquals(11, bmFind(source, template))
    }



}