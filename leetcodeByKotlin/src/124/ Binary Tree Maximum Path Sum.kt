package LeetCode_124

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]
1
/ \
2   3
Output: 6
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * Time:O(n), Space:O(n)
    * */
    var max = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        findMax(root)
        return max
    }

    /*
    * 递归函数返回值就可以定义为以当前结点为根结点，到叶节点的最大路径之和
    * */
    private fun findMax(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        //avoid get negative count
        val left = Math.max(0, findMax(root.left))
        val right = Math.max(0, findMax(root.right))
        max = Math.max(max, left + right + root.`val`)
        //return path sum of root to left or to right, just mean return left side or right side each time
        return Math.max(left, right) + root.`val`
    }
}