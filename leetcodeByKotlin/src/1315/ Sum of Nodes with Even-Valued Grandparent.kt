package LeetCode_1315

import java.util.*

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
If there are no nodes with an even-valued grandparent, return 0.

Constraints:
1. The number of nodes in the tree is between 1 and 10^4.
2. The value of nodes is between 1 and 100.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: BFS, traversal tree level by level, Time: O(n), Space:O(n)
    * */
    fun sumEvenGrandparent(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var result = 0
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            //checking cur's left child
            if (cur.left != null) {
                queue.offer(cur.left)
                if (cur.`val` % 2 == 0) {
                    //checking cur's left Grandson and right Grandson
                    if (cur.left!!.left != null) {
                        result += cur.left!!.left!!.`val`
                    }
                    if (cur.left!!.right != null) {
                        result += cur.left!!.right!!.`val`
                    }
                }
            }
            //checking cur's right child
            if (cur.right != null) {
                queue.offer(cur.right)
                if (cur.`val` % 2 == 0) {
                    //checking cur's left Grandson and right Grandson
                    if (cur.right!!.left != null) {
                        result += cur.right!!.left!!.`val`
                    }
                    if (cur.right!!.right != null) {
                        result += cur.right!!.right!!.`val`
                    }
                }
            }
        }
        return result
    }
}