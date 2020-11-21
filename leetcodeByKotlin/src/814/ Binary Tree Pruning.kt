package LeetCode_814

/**
 * 814. Binary Tree Pruning
 * https://leetcode.com/problems/binary-tree-pruning/description/
 *
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: recursion,
    * Time complexity: O(n)
    * Space complexity: O(n)
    * */
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return root
        }
        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)
        if (root.`val` == 1 || root.left != null || root.right != null) {
            return root
        } else {
            return null
        }
    }

}