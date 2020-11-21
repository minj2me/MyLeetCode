package LeetCode_637

import LeetCode_297.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 637. Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * */

class Solution {
    /*
    * solution: BFS, Time complexity:O(n), Space complexity:O(n)
    * */
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val list = ArrayList<Double>()
        if (root == null) {
            return DoubleArray(0)
        }
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0.0
            //the size of current level
            for (i in 0 until size) {
                val cur = queue.pop()
                sum += cur.`val`
                if (cur.left != null) {
                    queue.offer(cur.left)
                }
                if (cur.right != null) {
                    queue.offer(cur.right)
                }
            }
            list.add(sum / size)
        }
        //setup he result
        val result = DoubleArray(list.size)
        list.forEachIndexed { index, element ->
            result.set(index, element)
        }
        return result
    }
}