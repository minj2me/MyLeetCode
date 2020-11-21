package LeetCode_1008

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every node, any descendant of node.
left has a value < node.val, and any descendant of node. right has a value > node.val.
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Constraints:
=. 1 <= preorder.length <= 100
=. 1 <= preorder[i] <= 10^8
=. The values of preorder are distinct.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
      Time complexity: O(nlogn), Space complexity: O(n)
    * preorder:root->left->right，so the first element of preorder array is the root of tree
    * */
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder == null || preorder.isEmpty()) {
            return null
        }
        val size = preorder.size
        val root = TreeNode(preorder[0])
        for (i in 1 until size) {
            help(root, preorder[i])
        }
        return root
    }

    private fun help(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) {
            return TreeNode(value)
        }
        if (root.`val` < value) {
            root.right = help(root.right, value)
        } else {
            root.left = help(root.left, value)
        }
        return root
    }
}