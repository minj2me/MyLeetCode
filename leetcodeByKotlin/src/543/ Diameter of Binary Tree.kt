package LeetCode_543

/**
 *543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.

Example:
Given a binary tree
    1
   / \
  2   3
 / \
4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number of edges between them.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//一般树的题:
//时间复杂度:O(n),因为每个节点都要访问一次
//空间复杂度:O(h),如果用递归的话，需要入stack，所以根据树的高度定义stack的深度
class Solution {
    var answer = 0
    //每条边只能调用一次
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        //递归方式，非递归的可以试
        //http://zxi.mytechroad.com/blog/tree/leetcode-543-diameter-of-binary-tree/
        diameterHelp(root)
        return answer
    }

    private fun diameterHelp(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }
        val l = diameterHelp(root.left) + 1
        val r = diameterHelp(root.right) + 1
        answer = Math.max(answer, l + r)
        //return the max of current level
        return Math.max(l, r)
    }
}