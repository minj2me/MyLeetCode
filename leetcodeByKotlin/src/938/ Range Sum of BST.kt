package LeetCode_938

import java.util.*

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/description/
 *
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: in-order traverse, use flag to check if can sum up node's value,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun rangeSumBST(root_: TreeNode?, L: Int, R: Int): Int {
        var root = root_
        val stack = Stack<TreeNode>()
        var canDoSum = false
        var result = 0
        //use inorder
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                if (!canDoSum) {
                    if (root.`val` == L) {
                        canDoSum = true
                    }
                }
                if (canDoSum) {
                    result += root.`val`
                }
                if (root.`val` == R) {
                    canDoSum = false
                }
                root = root.right
            }
        }
        return result
    }
}