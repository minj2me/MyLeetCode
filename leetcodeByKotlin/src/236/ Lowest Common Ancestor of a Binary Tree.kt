package LeetCode_236

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * */
class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: recursion, Time complexity:O(n), Space complexity:O(n)
    * */
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == p?.`val` || root.`val` == q?.`val`) {
            return root
        }
        val left = lowestCommonAncestor(root?.left, p, q)
        val right = lowestCommonAncestor(root?.right, p, q)
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left != null && right != null) {
            return root
        }
        // Otherwise check if left subtree or right subtree is LCA
        if (left != null) {
            return left
        } else {
            return right
        }
    }
}