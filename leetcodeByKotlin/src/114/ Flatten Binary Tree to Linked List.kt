package LeetCode_114

import java.util.*

/**
114. Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
https://www.cnblogs.com/grandyang/p/4293853.html

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:
    1
   / \
  2  5
 / \  \
3  4   6
The flattened tree should look like:
1
 \
 2
  \
  3
   \
   4
    \
    5
     \
     6
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun flatten(root_: TreeNode?) {
        if (root_==null){
            return
        }
        var root = root_
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (!stack.isEmpty()){
            root = stack.pop()
            //put the right first
            if (root.right!=null){
                stack.push(root.right)
            }
            if (root.left!=null){
                //##im_here
                stack.push(root.left)
            }
            root.left=null
            if (!stack.isEmpty()){
                //now the root.right is the top of stack which is push at last in ##im_here
                //后进先出
                root.right = stack.peek()
            }
        }
        //the process of above
        /**
         *    1
             / \
            2   5
           / \   \
          3   4   6

        1
         \
          2
         / \
        3   4
             \
             5
              \
              6

         * */
    }
}