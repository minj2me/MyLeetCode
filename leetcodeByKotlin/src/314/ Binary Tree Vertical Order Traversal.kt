package LeetCode_314

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 314. Binary Tree Vertical Order Traversal
 * (Prime)
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.

Examples 1:
Input: [3,9,20,null,null,15,7]
3
/\
/  \
9  20
/\
/  \
15   7
Output:
[
[9],
[3,15],
[20],
[7]
]
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Node(root: TreeNode?, hd: Int) {
    var root: TreeNode? = null
    var horizontalDistance = 0

    init {
        this.root = root
        this.horizontalDistance = hd
    }
}

class Solution {
    /*
    * solution: BFS+HashMap, BFS to traverse all node, and HashMap to save elements of each coordinate
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (root == null) {
            return result
        }
        //for the range of result
        var minHD = Int.MAX_VALUE
        var maxHD = Int.MIN_VALUE
        //key is coordinate, value is elements of this coordinate
        val map = HashMap<Int, ArrayList<Int>>()
        val queue = LinkedList<Node>()
        //the coordinate root is 0, root.left should be -1, root.right should be +1
        val starting = Node(root, 0)
        queue.offer(starting)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            if (cur != null) {
                map.putIfAbsent(cur.horizontalDistance, ArrayList())

                minHD = Math.min(minHD, cur.horizontalDistance)
                maxHD = Math.max(maxHD, cur.horizontalDistance)

                if (cur.root != null) {
                    map.get(cur.horizontalDistance)!!.add(cur.root!!.`val`)

                    if (cur.root!!.left != null) {
                        queue.offer(Node(cur.root!!.left, cur.horizontalDistance - 1))
                    }
                    if (cur.root!!.right != null) {
                        queue.offer(Node(cur.root!!.right, cur.horizontalDistance + 1))
                    }
                }
            }
        }

        for (i in minHD..maxHD) {
            result.add(map.get(i)!!)
        }

        return result
    }
}