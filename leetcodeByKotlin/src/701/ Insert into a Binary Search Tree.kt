package LeetCode_701

/**
 * 701. Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
You can return any of them.

Constraints:
1. The number of nodes in the tree will be in the range [0, 104].
2. -108 <= Node.val <= 108
3. All the values Node.val are unique.
4. -108 <= val <= 108
5. It's guaranteed that val does not exist in the original BST.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: recursion, Time:O(n), Space:O(logn)
    * */
    fun insertIntoBST(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) {
            return TreeNode(value)
        }
        if (root.`val` > value) {
            //value should be root's left child
            root.left = insertIntoBST(root.left, value)
        } else {
            root.right = insertIntoBST(root.right, value)
        }
        return root
    }
}