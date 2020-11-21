package LeetCode_515

import java.util.*
import kotlin.collections.ArrayList

/**
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * You need to find the largest value in each row of a binary tree.
Example:
Input:
   1
  / \
  3   2
 / \   \
5   3   9

Output: [1, 3, 9]
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution:BFS, scan every level and pick the maximum number;
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun largestValues(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        if (root == null) {
            return result
        }
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var max = Int.MIN_VALUE
            for (i in 0 until size) {
                val cur = queue.poll()
                max = Math.max(max, cur.`val`)
                if (cur.left != null) {
                    queue.offer(cur.left)
                }
                if (cur.right != null) {
                    queue.offer(cur.right)
                }
            }
            result.add(max)
        }
        return result
    }
}