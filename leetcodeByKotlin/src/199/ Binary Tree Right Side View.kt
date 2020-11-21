package LeetCode_199

import LeetCode_814.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        if (root==null){
            return result
        }
        //bfs
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()){
            val size = queue.size
            for (i in 0 until size){
                val cur = queue.pop()
                //the first element in the queue, just right-most in tree
                if (i==0){
                    result.add(cur.`val`)
                }
                //add right first, then out first, because use queue: first in first out
                if (cur.right!=null){
                    queue.offer(cur.right)
                }
                if (cur.left!=null){
                    queue.offer(cur.left)
                }
            }
        }
        return result
    }
}