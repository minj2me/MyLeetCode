package LeetCode_333

import LeetCode_814.TreeNode

/**
 * 333. Largest BST Subtree
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
Note:
A subtree must include all of its descendants.

Example:
Input: [10,5,15,1,8,null,7]
10
/  \
5   15
/ \   \
1   8   7
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one (5,1,8).
The return value is the subtree's size, which is 3.

Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 * */
class Solution {
    /*
    * solution: recursion, Time complexity:O(n*n), Space complexity:O(n)
    * 1. check it if BST
    * 2. count the node it have
    * 3. recursion to check left node and node, and return the max count
    * */
    fun largestSubTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (isBST(root, null, null)) {
            return count(root)
        }
        return Math.max(largestSubTree(root.left), largestSubTree(root.right))
    }

    private fun isBST(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) {
            return true
        }
        if (min != null && min > root.`val` || max != null && max < root.`val`) {
            return false
        }
        return isBST(root.left, min, root.`val`) && isBST(root.right, root.`val`, max)
    }

    private fun count(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return count(root.left) + count(root.right) + 1
    }
}