package LeetCode_285

import java.util.*

/**
 * 285. Inorder Successor in BST
 * (Prime)
 *
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
The successor of a node p is the node with the smallest key greater than p.val.

Example 1:
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.

Example 2:
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.

Note:
If the given node has no in-order successor in the tree, return null.
It's guaranteed that the values of the tree are unique.
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//inorder: root->left->right
class Solution {
    fun inorderSuccessor(root_: TreeNode?, node: TreeNode): TreeNode? {
        var findIt = false
        var root = root_
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (root != null || stack.size > 0) {
            if (root != null) {
                stack.push(root)
                root = root.left!!
            } else {
                root = stack.pop()
                if (findIt) {
                    return root
                }
                if (root.`val` == node.`val`) {
                    //if found the node, the next node is the result
                    //because next node is current node's Successor
                    findIt = true
                }
                root = root.right
            }
        }
        return null
    }
}