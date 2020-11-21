package LeetCode_156

/**
 * 156. Binary Tree Upside Down
 * (Prime)
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
Example:
Input: [1,2,3,4,5]
    1
   / \
  2   3
 / \
4   5
Output: return the root of the binary tree [4,5,2,#,#,3,1]
    4
   / \
  5   2
     / \
    3   1
Clarification:
Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
Here's an example:
    1
   / \
  2   3
     /
    4
     \
      5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
 * */
class TreeNode(var `val`:Int){
    var left: TreeNode?=null
    var right: TreeNode?=null
}
class Solution {
    /*
    * Solution: turn the tree by clockwise, for example root, so we have to do,
    * 1. let root.left become root
    * 2. root.left become root.right
    * 3. root.right become root.left
    * 4. this root become new root's right child node
    * */
    fun upsideDownBinaryTree(root: TreeNode?): TreeNode?{
        if (root==null || root.left==null){
            return root
        }
        val left = root.left
        val right = root.right
        val result = upsideDownBinaryTree(left)
        //let root.left become root and new's root.left become right
        left?.left = right
        //root become new root's right child node
        left?.right = root
        root.left = null
        root.right = null
        return result
    }
}