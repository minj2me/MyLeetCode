package LeetCode_110

/**
 * 110. Balanced Binary Tree
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null)
            return true
        if (root.left == null && root.right == null)
            return true
        val leftDeep = getDeep(root.left)
        val rightDeep = getDeep(root.right)
        if (Math.abs(leftDeep - rightDeep) > 1)
            return false
        return isBalanced(root.left) && isBalanced(root.right)
    }

    fun getDeep(node: TreeNode?): Int {
        if (node == null)
            return 0
        val leftHeight = getDeep(node.left)
        val rightHeight = getDeep(node.right)
        return 1 + Math.max(leftHeight, rightHeight)
    }
}