package com.programming.kotlin.chapter03

sealed class IntBinaryTree {
    class EmptyNode : IntBinaryTree()
    class IntBinaryTreeNode(val left: IntBinaryTree, val value: Int, val right: IntBinaryTree) : IntBinaryTree()
}

fun toCollection(tree: IntBinaryTree): Collection<Int> =
        when (tree) {
            is IntBinaryTree.EmptyNode -> emptyList<Int>()
            is IntBinaryTree.IntBinaryTreeNode -> toCollection(tree.left) + tree.value + toCollection(tree.right)
        }

