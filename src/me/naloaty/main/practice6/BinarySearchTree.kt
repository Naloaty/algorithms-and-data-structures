package me.naloaty.main.practice6

class Node<K, V>(
    val key: K,
    val value: V
) {
    var left: Node<K, V>? = null
    var right: Node<K, V>? = null
    var parent: Node<K, V>? = null

    fun clone(): Node<K, V> {
        return Node(key, value)
    }

    override fun toString(): String {
        return "($key, $value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node<*, *>

        if (key != other.key) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key?.hashCode() ?: 0
        result = 31 * result + (value?.hashCode() ?: 0)
        return result
    }
}

class BinarySearchTree<K : Comparable<K>, V> {

    private var tree: Node<K, V>? = null

    private fun min(tree: Node<K, V>): Node<K, V> {
        return if (tree.left == null)
            tree
        else
            min(tree.left!!)
    }

    private fun replace(old: Node<K, V>, new: Node<K, V>?) {
        val p = old.parent
        new?.parent = p

        if (p == null) {
            tree = new
            return
        }

        if (p.key < old.key)
            p.right = new
        else
            p.left = new
    }

    private fun insert(root: Node<K, V>, node: Node<K, V>) {
        // right subtree
        if (node.key > root.key) {
            if (root.right == null) {
                root.right = node
                node.parent = root
            }
            else
                insert(root.right!!, node)
        }
        // left subtree
        else if (node.key < root.key) {
            if (root.left == null) {
                root.left = node
                node.parent = root
            }
            else
                insert(root.left!!, node)
        }
        // equal nodes
        else {
            replace(root, node)
            node.right = root.right
            node.left = root.left
            node.right?.parent = node
            node.left?.parent = node
        }
    }

    fun insert(key: K, value: V) {
        val node = Node(key, value)

        when (tree) {
            null -> tree = node
            else -> insert(tree!!, node)
        }
    }

    fun find(key: K, node: Node<K, V>? = tree): Node<K, V>? {
        if (node == null)
            return null

        return when {
            key > node.key -> find(key, node.right)
            key < node.key -> find(key, node.left)
            else -> node.clone()
        }
    }

    fun remove(key: K, node: Node<K, V>? = tree) {
        if (node == null)
            return

        when {
            key > node.key -> {
                remove(key, node.right)
                return
            }
            key < node.key -> {
                remove(key, node.left)
                return
            }
        }

        // no children
        if (node.right == null && node.left == null)
            replace(node, null)

        // two children
        else if (node.right != null && node.left != null) {

            // left child of right subtree is null
            if (node.right!!.left == null) {
                val new = node.right!!
                replace(node, new)

                new.left = node.left
                node.left?.parent = new
            }
            else {
                val farLeft = min(node.right!!)
                val new = farLeft.clone()
                replace(node, new)

                new.left = node.left
                new.right = node.right
                node.left?.parent = new
                node.right?.parent = new

                remove(farLeft.key, farLeft)
            }
        }

        // only right child
        else if (node.right != null) {
            replace(node, node.right)
            node.right?.parent = node.parent
        }

        // only left child
        else {
            replace(node, node.left)
            node.left?.parent = node.parent
        }

    }

    private fun toList(
        node: Node<K, V>?,
        list: MutableList<Node<K, V>>
    ) {
        if (node == null)
            return

        toList(node.left, list)
        list.add(node.clone())
        toList(node.right, list)
    }

    fun toList(): List<Node<K, V>> {
        val list = ArrayList<Node<K, V>>()
        toList(tree, list)
        return list
    }
}
