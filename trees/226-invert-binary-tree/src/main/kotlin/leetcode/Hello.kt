package leetcode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root != null) {
            processNode(root);
        }
        return root;
    }

    private fun processNode(node: TreeNode) {
        swapChildren(node)
        node.left?.let { processNode(it) }
        node.right?.let { processNode(it) }
    }

    private fun swapChildren(node: TreeNode) {
        val tmp = node.left
        node.left = node.right
        node.right = tmp
    }
}

fun main(args: Array<String>) {
}

