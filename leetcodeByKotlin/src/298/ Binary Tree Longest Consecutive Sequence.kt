package LeetCode_298

/**
 * 298. Binary Tree Longest Consecutive Sequence (Locked by leetcode)
 * https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence/description
 * Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-childconnections.
The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:
Input:
    1
    \
    3
   / \
   2  4
      \
      5
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var result = 0
    fun longestConsecutive(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        dfs(root, 0, 0)
        return result
    }

    /*
    just from parent to child
   每个遍历到的节点，看节点值是否比参数值(父节点值)大1(因为cannot be the reverse)，如果是则长度加1，否则长度重置为1，
   然后更新结果 res，再遍历左右子节点
   */
    private fun dfs(root: TreeNode?, value: Int, current_: Int) {
        if (root == null) {
            return
        }
        var currentLen = current_
        if (root.`val` == value + 1) {
            currentLen++
        } else {
            currentLen = 1
        }
        result = Math.max(currentLen, result)

        dfs(root.left, root.`val`, currentLen)
        dfs(root.right, root.`val`, currentLen)
    }
}