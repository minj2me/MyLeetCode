package LeetCode_426

/**
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * https://www.lintcode.com/problem/convert-binary-search-tree-to-sorted-doubly-linked-list/description
 *
 * Convert a BST to a sorted circular doubly-linked list in-place.
 * Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/*
* solution: get a sorted element by inorder, then connect each other
* Time complexity:O(n), Space complexity:O(logn)
* */
class Solution {
    //save last access node
    var prev: TreeNode? = null

    fun treeToDoublyList(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        //the leftmost node
        val dummy = TreeNode(-1)
        //these two node point to the same
        prev = dummy
        inorder(root)
        //link each other
        val head = dummy.right
        prev?.right = head
        head?.left = prev
        return head
    }

    //changing prev
    private fun inorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        inorder(node.left)
        //link each other
        prev?.right = node
        node.left = prev
        //update the prev
        prev = node
        inorder(node.right)
    }
}