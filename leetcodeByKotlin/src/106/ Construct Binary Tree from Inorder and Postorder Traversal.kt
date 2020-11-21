package LeetCode_106
/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
   3
  / \
 9  20
   /  \
  15   7
 * */
class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    Time complexity:O(n^2), Space complexity:O(n)
    * we know that:
    * inorder: left->root->right
    * postorder: left->right->root
    * so the root of the tree is 3,
    * and we will divide the inorder array based in the last element of the postorder that two part will be left and right
    * */
    var rootIndex = 0

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        rootIndex = postorder.size-1
        return buildTree(inorder,0,inorder.size-1,postorder)
    }

    private fun buildTree(inorder: IntArray,start:Int, end:Int, postorder: IntArray):TreeNode?{
        if (start>end){
            return null
        }
        if (start==end){
            return TreeNode(postorder[rootIndex--])
        }
        val root = TreeNode(postorder[rootIndex--])
        for (i in start..end){
            //if we find out the position of the root, create left and right
            if (inorder[i]==root.`val`) {
                //if is preorder array, we build left node first
                //if is postorder array, we build right node first
                root.right = buildTree(inorder, i + 1, end, postorder)
                root.left = buildTree(inorder, start, i - 1, postorder)
                return root
            }
        }
        return root
    }
}
