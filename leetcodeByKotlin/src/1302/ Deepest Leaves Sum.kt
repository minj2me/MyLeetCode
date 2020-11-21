package LeetCode_1302

import java.util.*

/**
 * 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 * Constraints:
1. The number of nodes in the tree is between 1 and 10^4.
2. The value of nodes is between 1 and 100.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: BFS, calculating sum of tree by level by level, there is the result when reach last level,
    * Time complexity: O(n), Space complexity: O(n)
    * */
    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var result = 0
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            //reset for calculating for next level
            result = 0
            for (i in 0 until size) {
                val cur = queue.pop()
                result += cur.`val`
                if (cur.left != null) {
                    queue.offer(cur.left)
                }
                if (cur.right != null) {
                    queue.offer(cur.right)
                }
            }
        }
        return result
    }
}