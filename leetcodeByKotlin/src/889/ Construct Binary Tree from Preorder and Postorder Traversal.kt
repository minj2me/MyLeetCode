package LeetCode_889

import java.util.*

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * Return any binary tree that matches the given preorder and postorder traversals.
Values in the traversals pre and post are distinct positive integers.

Example 1:
Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

Note:
1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 * */

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: Stack, Time complexity: O(n^2), Space complexity: O(n)
    * just put nodes into stack with the order of preorder until the top of stack is the same as postorder
      the key is that if the top of stack is postorder[postIdx],
      we know that for this node, whatever underneath this node is all done, and what can safely pop this node out and find its parent form the stack.
      why the stack top must be higher the current node?
      well becuase preorder goes like: parent, [left, right]
      while postorder goes like: [left, right], parent
       so for the left and right slibling under the same parent, we can garantee that left will be popped before we put right in the stack
    * */
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        val stack = Stack<TreeNode>()
        var preIndex = 0
        var postIndex = 0
        val n = pre.size
        var root: TreeNode? = null
        while (preIndex < n) {
            if (preIndex < n) {
                val node = TreeNode(pre[preIndex])
                stack.push(node)
                preIndex++
            }
            while (stack.peek().`val` == post[postIndex]) {
                val cur = stack.pop()
                postIndex++
                if (postIndex == n) {
                    root = cur
                    break
                }
                if (stack.peek().left == null) {
                    stack.peek().left = cur
                } else {
                    stack.peek().right = cur
                }
            }
        }
        return root
    }
}