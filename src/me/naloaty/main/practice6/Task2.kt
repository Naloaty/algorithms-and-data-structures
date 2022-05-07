package me.naloaty.main.practice6

fun main() {
    val tree = BinarySearchTree<String, Int>()

    tree.insert("Bob", 30)
    tree.insert("Charlie", 28)
    tree.insert("Alice", 22)

    println(tree.toList().toString())
    println(tree.find("Charlie"))
    tree.remove("Charlie")
    println(tree.toList().toString())
}