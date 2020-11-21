package LeetCode_94

import java.util.*

/**
 * 94. Binary Tree Inorder Traversal
 * left->root->right
 * */
class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inorderTraversal(root_: TreeNode?): List<Int> {
        //val result = listOf<Int>()//read only
        val result = arrayListOf<Int>()//read,write
        var root = root_
        val stack = Stack<TreeNode>()
        while (root != null || stack.size > 0) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                result.add(root.`val`)
                root = root.right
            }
        }
        return result
    }
}