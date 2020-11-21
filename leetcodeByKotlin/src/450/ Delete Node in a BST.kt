package LeetCode_450

import LeetCode_814.TreeNode

/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
Basically, the deletion can be divided into two stages:
--Search for a node to remove.
--If the node is found, delete the node.

Note: Time complexity should be O(height of tree).
 * */
class Solution {
    /*
    * 1.node to be delete is leaf: simply remove it from tree
    * 2.node to be delete has only one child: copy the child to the node and remove the child
    * 3.node to be delete has two children: find inorder successor of the node, copy the content of the inorder
    * successor to the node and delete the inorder successor. the inorder predecessor can also be used.
    * */
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else {
            if (root.right == null) {
                return root.left
            } else if (root.left == null) {
                return root.right
            }
            /*node with two children:
            1. get the inorder successor(中序编历时的后继节点) (the smallest one in the right subtree)
                5
               / \
              3   6
             / \   \
            2   4   7
            node3的inorder successor是4
            2. replace root value by the value of inorder successor
           */
            root.`val` = minValue(root.right) ?: -1
            //delete the inorder successor
            root.right = deleteNode(root.right, root.`val`)
        }
        return root
    }

    private fun minValue(node_: TreeNode?): Int? {
        var node = node_
        var min = node?.`val`
        while (node?.left != null) {
            min = node.left?.`val`
            node = node.left
        }
        return min
    }
}