package LeetCode_98

import LeetCode_814.TreeNode

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
-The left subtree of a node contains only nodes with keys less than the node's key.
-The right subtree of a node contains only nodes with keys greater than the node's key.
-Both the left and right subtrees must also be binary search trees.
 * */
class Solution {
    /*
    * solution: recursion, Time complexity:O(n), Space complexity:O(n)
    * */
    fun isValidBST(root: TreeNode?): Boolean {
        return help(root, null, null)
    }

    private fun help(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) {
            return true
        }
        if (min!=null && min >= root.`val` || max!=null && max <= root.`val`) {
            return false
        }
        return help(root.left, min, root.`val`) && help(root.right, root.`val`, max)
    }
}