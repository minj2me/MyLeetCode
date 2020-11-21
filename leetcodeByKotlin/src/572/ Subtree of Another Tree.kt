package LeetCode_572

import java.util.*

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: pre-order traversal TreeNode and check the structure
    * Time:O(n), Space:O(n)
    * */
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        val sString = preOrder(s)
        val tString = preOrder(t)
        return sString.indexOf(tString) >= 0
    }

    //root->left->right
    private fun preOrder(root_: TreeNode?): String {
        if (root_ == null) {
            return ""
        }
        var root = root_
        val sb = StringBuilder()
        val stack = Stack<TreeNode>()
        while (root != null || stack.isNotEmpty()) {
            if (root != null) {
                stack.push(root)
                //append , to avoid like: [12],[2]
                sb.append(",")
                sb.append(root.`val`)
                root = root.left
            } else {
                root = stack.pop()
                root = root.right
            }
            //use # to represent null of root
            if (root == null) {
                sb.append(",#")
            }
        }
        return sb.toString()
    }
}