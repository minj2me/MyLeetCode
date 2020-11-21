package LeetCode_102

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
  3
 / \
9  20
  /  \
 15   7
return its level order traversal as:
[
[3],
[9,20],
[15,7]
]
 * */

class TreeNode(var `val`: Int) {
    val left: TreeNode? = null
    val right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null)
            return result
        val stack = mutableListOf<TreeNode>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val oneLevel = mutableListOf<Int>()
            var size = stack.size
            while (size > 0) {
                //below 2 lines do as pop
                val node = stack.get(0)
                stack.removeAt(0)
                size--
                oneLevel.add(node.`val`)
                if (node.left != null)
                    stack.add(node.left)
                if (node.right != null)
                    stack.add(node.right)
            }
            result.add(oneLevel)
        }
        return result
    }
}