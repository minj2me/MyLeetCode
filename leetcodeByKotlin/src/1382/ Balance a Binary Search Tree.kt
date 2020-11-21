package LeetCode_1382

import kotlin.collections.ArrayList

/**
 * 1382. Balance a Binary Search Tree
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 *
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 *
 * 1.BST+inorder=>array sorted
 * time complexity is O(n)
 * space complexity is O(n)
 *
 * 2.cover sorted array to BST(Binary Search Tree)
 * time complexity is O(n)
 * space complexity is O(logn)
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun balanceBST(root_: TreeNode?): TreeNode? {
        if (root_==null){
            return null
        }
        val list = ArrayList<Int>()
        //Iteration
        /*val stack = Stack<TreeNode>()
        var root = root_
        while (stack.isNotEmpty() || root != null) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                list.add(root.`val`)
                root = root.right
            }
        }*/
        //recursion
        //left->root->right
        inorder(list,root_)
        return coverHelp(list, 0, list.size - 1)
    }

    private fun inorder(list: ArrayList<Int>,root:TreeNode?){
        if (root==null){
            return
        }
        inorder(list,root.left)
        list.add(root.`val`)
        inorder(list,root.right)
    }

    private fun coverHelp(list: ArrayList<Int>, left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }
        val mid = (left + right) / 2
        val node = TreeNode(list[mid])
        node.left = coverHelp(list, left, mid - 1)
        node.right = coverHelp(list, mid + 1, right)
        return node
    }
}