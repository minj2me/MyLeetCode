package LeetCode_872

import java.util.*

/**
 * 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: Stack, Time:O(n), Space:O(n)
    * */
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return getLeaf(root1) == getLeaf(root2)
    }

    private fun getLeaf(root: TreeNode?): String {
        val sb = StringBuilder()
        if (root == null) {
            return ""
        }
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            if (cur.left != null) {
                stack.push(cur.left)
            }
            if (cur.right != null) {
                stack.push(cur.right)
            }
            if (cur.left == null && cur.right == null) {
                sb.append(cur.`val`)
            }
        }
        return sb.toString()
    }
}