package LeetCode_270

import java.util.*

/**
 * 270. Closest Binary Search Tree Value
 * (Prime)
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:
Input: root = [4,2,5,1,3], target = 3.714286
    4
   / \
  2  5
 / \
1  3
Output: 4
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: use Stack to scan BST via in-order and compare the closest value,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun closestValue(root_: TreeNode?, target: Float): Int {
        var root = root_
        val stack = Stack<TreeNode>()
        var result = 0
        var diff = 0f
        var min = Int.MAX_VALUE.toFloat()
        while (root != null || stack.isNotEmpty()) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                diff = Math.abs(target - root.`val`)
                //found out the smallest one, mean that it's most close to target
                if (diff < min) {
                    min = diff
                    result = root.`val`
                }
                root = root.right
            }
        }
        return result
    }
}