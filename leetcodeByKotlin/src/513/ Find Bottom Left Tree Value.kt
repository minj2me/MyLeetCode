package LeetCode_513

import java.util.*

/**
 * 513. Find Bottom Left Tree Value
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 * https://www.cnblogs.com/grandyang/p/6405128.html
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        var result = 0
        queue.offer(root)
        while (queue.size > 0) {
            val size = queue.size
            for (i in 0..size - 1) {
                val node = queue.poll()
                if (i == 0) {
                    //i==0表示第一个node,即左边的,set value to result until the loop finish
                    result = node.`val`
                }
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        return result
    }
}