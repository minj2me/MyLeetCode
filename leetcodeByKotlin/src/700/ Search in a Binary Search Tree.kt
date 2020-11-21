package LeetCode_700

import java.util.*

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun searchBST(root_: TreeNode?, targe: Int): TreeNode? {
        if (root_ == null) {
            return null
        }
        var root = root_
        val stack = Stack<TreeNode>()
        //use inorder: root,left,right
        while (stack.isNotEmpty() || root != null) {
            if (root != null) {
                stack.add(root)
                root = root.left
            } else {
                root = stack.pop()
                if (root.`val`==targe){
                    return root
                }
                root = root.right
            }
        }
        return null
    }
}