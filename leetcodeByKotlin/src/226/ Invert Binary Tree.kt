package LeetCode_226

import java.util.*

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * Invert a binary tree.
 *
 * Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        //method 1: bfs
        if (root==null){
            return root
        }
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()){
            //invert level by level
            val cur = queue.pop()
            if (cur!=null){
                val temp = cur.left
                cur.left = cur.right
                cur.right = temp
            }
            if (cur.left!=null){
                queue.offer(cur.left)
            }
            if (cur.right!=null){
                queue.offer(cur.right)
            }
        }
        return root
    }
}