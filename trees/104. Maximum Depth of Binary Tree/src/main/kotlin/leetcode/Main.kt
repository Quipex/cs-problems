package leetcode

import java.lang.Integer.max

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
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val index = 1
        return maxDepth(root, index)
    }

    private fun maxDepth(root: TreeNode, index: Int): Int {
        val maxLeft = root.left?.let { maxDepth(it, index + 1) } ?: index
        val maxRight = root.right?.let { maxDepth(it, index + 1) } ?: index
        return max(maxLeft, maxRight)
    }
}
