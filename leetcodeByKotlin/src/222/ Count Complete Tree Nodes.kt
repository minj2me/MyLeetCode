package LeetCode_222

import java.util.*

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * Given a complete binary tree, count the number of nodes.

Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.

Example:
Input:
     1
   /  \
  2    3
 / \  /
4  5 6

Output: 6
 * */

class TreeNode{
    var left:TreeNode?=null
    var right:TreeNode?=null
}
class Solution {
    /*
    * solution:BFS,Time complexity:O(n), Space complexity:O(n)
    * */
    fun countNodes(root: TreeNode?): Int {
        if (root == null){
            return 0
        }
        val queue = LinkedList<TreeNode>()
        //insert root first
        queue.offer(root)
        var result = 1
        while (queue.isNotEmpty()){
            val size = queue.size
            for (i in 0 until size){
                val cur = queue.pop()
                if (cur.left != null){
                    queue.offer(cur.left)
                    result++
                } else {
                    return result
                }
                if (cur.right != null){
                    queue.offer(cur.right)
                    result++
                } else {
                    return result
                }
            }
        }
        return result
    }
}