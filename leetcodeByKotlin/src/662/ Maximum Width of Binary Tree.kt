package LeetCode_662

import java.util.*
import kotlin.collections.ArrayList

/**
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *https://www.cnblogs.com/grandyang/p/7538821.html
 *
 * Input:
     1
   /   \
  3     2
 / \     \
5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 *
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * 所以这道题的关键就是要记录每一层中最左边结点的位置，我们知道对于一棵完美二叉树，如果根结点是深度1，那么每一层的结点数就是2*n-1，
 * 那么每个结点的位置就是[1, 2*n-1]中的一个，假设某个结点的位置是i，那么其左右子结点的位置可以直接算出来，为2*i和2*i+1，可以自行带例子检验。
 * */
class Solution {
    /*
    * solution 1:dfs, Time:O(n), Space:O(h)
    * solution 2:bfs, Time:O(n), Space:O(n)
    * */
    fun widthOfBinaryTree(root: TreeNode?): Int {
        //solution 1
        /*val lefts = ArrayList<Int>()
        val res = IntArray(1)
        dfs(root, 0, 1, lefts, res)
        return res[0]*/

        //solution 2:
        return bfs(root)
    }

    fun dfs(node: TreeNode?, depth: Int, id: Int, lefts: ArrayList<Int>, res: IntArray) {
        if (node == null)
            return
        if (depth >= lefts.size)
            lefts.add(id)
        res[0] = Math.max(res[0], id + 1 - lefts.get(depth))
        //if the parent node is n, then the left child is 2*n, and right child is 2*n+1
        dfs(node.left, depth + 1, id * 2, lefts, res)
        dfs(node.right, depth + 1, id * 2 + 1, lefts, res)
    }

    fun bfs(root: TreeNode?): Int {
        //queue for save node
        val queue = LinkedList<TreeNode>()
        //queue for save index
        val queueForIndex = LinkedList<Int>()
        var max = 0
        queue.offer(root)
        //assuming root's index is 1
        queueForIndex.offer(1)
        while (queue.isNotEmpty()) {
            //the size of current level
            val size = queue.size
            var start = 0
            var end = 0
            for (i in 0 until size) {
                val node = queue.poll()
                val curIndex = queueForIndex.poll()
                //the start, and of each level
                if (i == 0) {
                    start = curIndex
                }
                if (i == size - 1) {
                    end = curIndex
                }
                //if the parent node is n, then the left child is 2*n, and right child is 2*n+1
                if (node.left != null) {
                    queue.offer(node.left)
                    queueForIndex.offer(2 * curIndex)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                    queueForIndex.offer(2 * curIndex + 1)
                }
            }
            max = Math.max(max, end - start + 1)
        }
        return max
    }
}