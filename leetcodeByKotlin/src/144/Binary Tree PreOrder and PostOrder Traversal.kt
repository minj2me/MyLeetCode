package LeetCode_144

import java.util.*

class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     *      4
     *     / \
     *    1   3
     *       /
     *      2
     *
     * preorder: 4,1,3,2
     * inorder: 1,4,2,3
     * postorder, 1,2,3,4
     * */

    /**
     * 94. Binary Tree Inorder Traversal
     * left->root->right
     * */
    fun inorderTraversal(root_: TreeNode?): List<Int>? {
        val result = arrayListOf<Int>()//read,write
        var root = root_
        val stack = Stack<TreeNode>()
        while (root != null || stack.size > 0) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                result.add(root.`val`)//inorder add result here
                root = root.right
            }
        }
        return result
    }

    /**
     * 144. Binary Tree Preorder Traversal
     * root->left->right
     * */
    fun preorderTraversal(root_: TreeNode?): List<Int>? {
        val result = arrayListOf<Int>()//read,write
        var root = root_
        val stack = Stack<TreeNode>()
        while (root != null || stack.size > 0) {
            if (root != null) {
                stack.push(root)
                result.add(root.`val`)
                root = root.left
            } else {
                root = stack.pop()
                root = root.right
            }
        }
        return result
    }

    /**
     * 145. Binary Tree Postorder Traversal
     * left->right->root
     * */
    fun postorderTraversal(root_: TreeNode?): List<Int>? {
        val result = arrayListOf<Int>()//read,write
        var root = root_
        val stack = Stack<TreeNode>()
        while (root != null || stack.size > 0) {
            if (root != null) {
                stack.push(root)
                result.add(0, root.`val`)//value put in the first position
                root = root.right
            } else {
                root = stack.pop()
                /*
                * loop left node after right node, so will insert left value before right value,
                * because we using stack, first in last out
                * */
                root = root.left
            }
        }
        return result
    }
}