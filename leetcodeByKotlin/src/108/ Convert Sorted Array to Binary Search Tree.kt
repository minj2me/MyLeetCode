package LeetCode_108

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST. For this problem,
 * a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node
 * never differ by more than 1.
 * */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums == null || nums.size == 0) {
            return null
        }
        return help(nums, 0, nums.size - 1)
    }

    private fun help(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }
        val mid = (left + right) / 2
        val node = TreeNode(nums[mid])
        node.left = help(nums, left, mid - 1)
        node.right = help(nums, mid + 1, right)
        return node
    }
}