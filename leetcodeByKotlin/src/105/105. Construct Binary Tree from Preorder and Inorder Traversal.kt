package LeetCode_105
/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
  3
 / \
9  20
  /  \
 15   7
 * */
class Solution {

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /*
    Time complexity:O(n^2), Space complexity:O(n)
    * preorder: root->left->right
    * inorder: left->root->right
    * so the first element of perorder array is the root of the tree,
    * then divide the inorder array based in the the first element of preorder array that two part will be left and right
    * */
    var rootIndex = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        rootIndex = 0
        return buildTree(preorder,0,inorder.size-1,inorder)
    }

    private fun buildTree(preorder: IntArray, start:Int, end:Int, inorder: IntArray):TreeNode?{
        if (start>end){
            return null
        }
        if (start==end){
            return TreeNode(preorder[rootIndex++])
        }
        val root = TreeNode(preorder[rootIndex++])
        for (i in start..end){
            if (inorder[i]==root.`val`){
                //if is preorder array, we build left node first
                //if is postorder array, we build right node first
                root.left = buildTree(preorder, start, i-1, inorder)
                root.right = buildTree(preorder, i+1, end, inorder)
                return root
            }
        }
        return root
    }
}