package LeetCode_559

import java.util.*

/**
 * 559. Maximum Depth of N-ary Tree
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 *
 * Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * */
class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class Solution {
    /**
     * solution: BFS, Time complexity:O(n), Space complexity:O(n)
     * */
    fun maxDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }
        var res = 0
        val queue = LinkedList<Node>()
        queue.offer(root)
        while (queue.isNotEmpty()){
            res++
            val size = queue.size
            for (i in size-1 downTo 0){
                val cur = queue.poll()
                if (cur!=null){
                    for (item in cur.children){
                        queue.offer(item)
                    }
                }
            }
        }
        return res
    }
}