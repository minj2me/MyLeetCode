package LeetCode_958

import java.util.*

/**
 *958. Check Completeness of a Binary Tree
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
 * https://www.cnblogs.com/Dylan-Java-NYC/p/11144993.html
 *
 * Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
 */

/**
 * 判断一棵树是否是完全二叉树的思路
1>如果树为空，则直接返回错
　　2>如果树不为空：层序遍历二叉树
　　2.1>如果一个结点左右孩子都不为空，则pop该节点，将其左右孩子入队列；
　　2.1>如果遇到一个结点，左孩子为空，右孩子不为空，则该树一定不是完全二叉树；
　　2.2>如果遇到一个结点，左孩子不为空，右孩子为空；或者 左右孩子都为空；则该节点之后的队列中的结点都为叶子节点；
    该树才是完全二叉树，否则就不是完全二叉树；
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.peek() != null) {
            //if popped node is not null, then add its left and right child, no matter if they are null or not
            val cur = queue.poll()
            queue.offer(cur.left)
            queue.offer(cur.right)
        }
        //If the tree is complete, when first met null in the queue, then the rest should all be null.
        //Otherwise, it is not complete.
        //because if left child is null, it's right child must be null
        while (queue.isNotEmpty() && queue.peek() == null) {
            queue.poll()
        }
        return queue.isEmpty()
    }
}