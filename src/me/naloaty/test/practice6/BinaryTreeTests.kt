package me.naloaty.test.practice6

import org.junit.jupiter.api.Assertions
import me.naloaty.main.practice6.BinarySearchTree
import me.naloaty.main.practice6.Node
import org.junit.jupiter.api.Test

class BinaryTreeTests {

    @Test
    fun insertSortedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Alice", 22)
        tree.insert("Bob", 30)
        tree.insert("Charlie", 28)
        tree.insert("David", 26)
        tree.insert("Eva", 27)
        tree.insert("Frank", 25)
        tree.insert("George", 26)
        tree.insert("Harry", 24)
        tree.insert("Ilona", 23)

        val expected = arrayOf(
            Node("Alice", 22), Node("Bob", 30), Node("Charlie", 28),
            Node("David", 26), Node("Eva", 27), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24), Node("Ilona", 23))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun insertReversedTest() {
        val tree = BinarySearchTree<String, Int>()

        tree.insert("Ilona", 23)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Frank", 25)
        tree.insert("Eva", 27)
        tree.insert("David", 26)
        tree.insert("Charlie", 28)
        tree.insert("Bob", 30)
        tree.insert("Alice", 22)

        val expected = arrayOf(
            Node("Alice", 22), Node("Bob", 30), Node("Charlie", 28),
            Node("David", 26), Node("Eva", 27), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24), Node("Ilona", 23))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun insertRandomTest() {
        val tree = BinarySearchTree<String, Int>()

        tree.insert("Bob", 30)
        tree.insert("David", 26)
        tree.insert("Frank", 25)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Ilona", 23)
        tree.insert("Eva", 27)
        tree.insert("Alice", 22)
        tree.insert("Charlie", 28)

        val expected = arrayOf(
            Node("Alice", 22), Node("Bob", 30), Node("Charlie", 28),
            Node("David", 26), Node("Eva", 27), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24), Node("Ilona", 23))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun updateSortedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Alice", 22)
        tree.insert("Bob", 30)
        tree.insert("Charlie", 28)
        tree.insert("David", 26)
        tree.insert("Eva", 27)
        tree.insert("Frank", 25)
        tree.insert("George", 26)
        tree.insert("Harry", 24)
        tree.insert("Ilona", 23)

        tree.insert("David", 10)
        tree.insert("Eva", 15)

        val expected = arrayOf(
            Node("Alice", 22), Node("Bob", 30), Node("Charlie", 28),
            Node("David", 10), Node("Eva", 15), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24), Node("Ilona", 23))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun updateReversedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Ilona", 23)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Frank", 25)
        tree.insert("Eva", 27)
        tree.insert("David", 26)
        tree.insert("Charlie", 28)
        tree.insert("Bob", 30)
        tree.insert("Alice", 22)

        tree.insert("David", 10)
        tree.insert("Eva", 15)

        val expected = arrayOf(
            Node("Alice", 22), Node("Bob", 30), Node("Charlie", 28),
            Node("David", 10), Node("Eva", 15), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24), Node("Ilona", 23))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun updateRandomTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Bob", 30)
        tree.insert("David", 26)
        tree.insert("Frank", 25)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Ilona", 23)
        tree.insert("Eva", 27)
        tree.insert("Alice", 22)
        tree.insert("Charlie", 28)

        tree.insert("David", 10)
        tree.insert("Eva", 15)

        val expected = arrayOf(
            Node("Alice", 22), Node("Bob", 30), Node("Charlie", 28),
            Node("David", 10), Node("Eva", 15), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24), Node("Ilona", 23))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun updateRootTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Alice", 22)

        tree.insert("Alice", 10)

        val expected = arrayOf(Node("Alice", 10))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun findSortedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Alice", 22)
        tree.insert("Bob", 30)
        tree.insert("Charlie", 28)
        tree.insert("David", 26)
        tree.insert("Eva", 27)
        tree.insert("Frank", 25)
        tree.insert("George", 26)
        tree.insert("Harry", 24)
        tree.insert("Ilona", 23)

        Assertions.assertEquals(Node("Alice", 22), tree.find("Alice"))
        Assertions.assertEquals(Node("Eva", 27), tree.find("Eva"))
        Assertions.assertEquals(Node("Ilona", 23), tree.find("Ilona"))
        Assertions.assertEquals(null, tree.find("LolKek"))
    }

    @Test
    fun findReversedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Ilona", 23)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Frank", 25)
        tree.insert("Eva", 27)
        tree.insert("David", 26)
        tree.insert("Charlie", 28)
        tree.insert("Bob", 30)
        tree.insert("Alice", 22)

        Assertions.assertEquals(Node("Alice", 22), tree.find("Alice"))
        Assertions.assertEquals(Node("Eva", 27), tree.find("Eva"))
        Assertions.assertEquals(Node("Ilona", 23), tree.find("Ilona"))
        Assertions.assertEquals(null, tree.find("LolKek"))
    }

    @Test
    fun findRandomTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Bob", 30)
        tree.insert("David", 26)
        tree.insert("Frank", 25)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Ilona", 23)
        tree.insert("Eva", 27)
        tree.insert("Alice", 22)
        tree.insert("Charlie", 28)

        Assertions.assertEquals(Node("Alice", 22), tree.find("Alice"))
        Assertions.assertEquals(Node("Eva", 27), tree.find("Eva"))
        Assertions.assertEquals(Node("Ilona", 23), tree.find("Ilona"))
        Assertions.assertEquals(null, tree.find("LolKek"))
    }

    @Test
    fun removeSortedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Alice", 22)
        tree.insert("Bob", 30)
        tree.insert("Charlie", 28)
        tree.insert("David", 26)
        tree.insert("Eva", 27)
        tree.insert("Frank", 25)
        tree.insert("George", 26)
        tree.insert("Harry", 24)
        tree.insert("Ilona", 23)

        tree.remove("Alice")
        tree.remove("Ilona")
        tree.remove("Eva")

        val expected = arrayOf(
            Node("Bob", 30), Node("Charlie", 28),
            Node("David", 26), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun removeReversedTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Ilona", 23)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Frank", 25)
        tree.insert("Eva", 27)
        tree.insert("David", 26)
        tree.insert("Charlie", 28)
        tree.insert("Bob", 30)
        tree.insert("Alice", 22)

        tree.remove("Alice")
        tree.remove("Ilona")
        tree.remove("Eva")

        val expected = arrayOf(
            Node("Bob", 30), Node("Charlie", 28),
            Node("David", 26), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun removeRandomTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("Bob", 30)
        tree.insert("David", 26)
        tree.insert("Frank", 25)
        tree.insert("Harry", 24)
        tree.insert("George", 26)
        tree.insert("Ilona", 23)
        tree.insert("Eva", 27)
        tree.insert("Alice", 22)
        tree.insert("Charlie", 28)

        tree.remove("Alice")
        tree.remove("Ilona")
        tree.remove("Eva")

        val expected = arrayOf(
            Node("Bob", 30), Node("Charlie", 28),
            Node("David", 26), Node("Frank", 25),
            Node("George", 26), Node("Harry", 24))
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
    }

    @Test
    fun complexTest() {
        val tree = BinarySearchTree<String, Int>()
        tree.insert("D", 4)
        tree.insert("B", 2)
        tree.insert("F", 6)
        tree.insert("A", 1)
        tree.insert("C", 3)
        tree.insert("E", 5)
        tree.insert("G", 7)

        // stage 1
        var expected = arrayOf(
            Node("A", 1), Node("B", 2), Node("C", 3),
            Node("D", 4), Node("E", 5), Node("F", 6),
            Node("G", 7)
        )
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
        Assertions.assertEquals(Node("G", 7), tree.find("G"))
        Assertions.assertEquals(Node("A", 1), tree.find("A"))
        Assertions.assertEquals(Node("D", 4), tree.find("D"))

        // stage 2
        tree.insert("B", 22)
        tree.insert("F", 66)
        tree.insert("A", 11)
        tree.insert("G", 77)

        expected = arrayOf(
            Node("A", 11), Node("B", 22), Node("C", 3),
            Node("D", 4), Node("E", 5), Node("F", 66),
            Node("G", 77)
        )
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
        Assertions.assertEquals(Node("G", 77), tree.find("G"))
        Assertions.assertEquals(Node("A", 11), tree.find("A"))
        Assertions.assertEquals(Node("D", 4), tree.find("D"))

        // stage 3
        tree.insert("H", 8)

        expected = arrayOf(
            Node("A", 11), Node("B", 22), Node("C", 3),
            Node("D", 4), Node("E", 5), Node("F", 66),
            Node("G", 77), Node("H", 8)
        )
        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
        Assertions.assertEquals(Node("G", 77), tree.find("G"))
        Assertions.assertEquals(Node("A", 11), tree.find("A"))
        Assertions.assertEquals(Node("D", 4), tree.find("D"))
        Assertions.assertEquals(Node("H", 8), tree.find("H"))

        // stage 4
        tree.remove("H")
        tree.remove("A")

        expected = arrayOf(
            Node("B", 22), Node("C", 3),
            Node("D", 4), Node("E", 5), Node("F", 66),
            Node("G", 77)
        )

        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
        Assertions.assertEquals(Node("G", 77), tree.find("G"))
        Assertions.assertEquals(null, tree.find("A"))
        Assertions.assertEquals(Node("D", 4), tree.find("D"))
        Assertions.assertEquals(null, tree.find("H"))

        //stage 5
        tree.remove("B")
        tree.remove("F")

        expected = arrayOf(
            Node("C", 3), Node("D", 4),
            Node("E", 5), Node("G", 77)
        )

        Assertions.assertArrayEquals(expected, tree.toList().toTypedArray())
        Assertions.assertEquals(null, tree.find("B"))
        Assertions.assertEquals(null, tree.find("F"))
        Assertions.assertEquals(Node("C", 3), tree.find("C"))
        Assertions.assertEquals(Node("E", 5), tree.find("E"))
    }
}