package LeetCode_987

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 *
 * Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
Return an list of non-empty reports in order of X coordinate.
Every report will have a list of values of nodes.

Note:
The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
 * */
class TreeNode(var `val`:Int){
    var left: TreeNode?=null
    var right: TreeNode?=null
}

class Solution {
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        return result
    }
}