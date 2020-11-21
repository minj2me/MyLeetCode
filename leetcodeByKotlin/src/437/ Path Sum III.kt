package LeetCode_437

import java.util.*

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 * http://gaozhipeng.me/posts/Path_Sum_III/
 *
 * You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */

//可以用非递归?
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var result = 0
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) {
            return result
        }
        val stack = Stack<TreeNode>()
        help(root, sum, stack)
        return result
    }

    private fun help(root_: TreeNode?, sum: Int, stack: Stack<TreeNode>) {
        stack.push(root_)
        //println("temp:${root_?.`val`}")
        var temp = 0
        //for (item in stack) {
        for (i in stack.size - 1 downTo 0) {
            //temp += item!!.`val`
            temp += stack.elementAt(i).`val`
            //println("temp:$temp")
            if (temp == sum) {
                result++
            }
        }
        //print("=====")
        if (root_!!.left != null) {
            help(root_!!.left, sum, stack)
        }
        if (root_!!.right != null) {
            help(root_!!.right, sum, stack)
        }
        stack.pop()
    }
}