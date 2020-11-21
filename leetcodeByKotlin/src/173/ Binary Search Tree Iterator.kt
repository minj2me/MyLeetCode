package LeetCode_173

import java.util.*

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Note:
next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is,
there will be at least a next smallest number in the BST when next() is called.
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/*
* solution 1: in-order + ArrayList, But need O(n) space
* solution 2: Stack, O(1) time and O(h) space in next() and hasNext()
* */
class BSTIterator(root: TreeNode?) {

    //val list = ArrayList<Int>()
    val stack = Stack<TreeNode>()

    init {
        //inorder(root)
        setNext(root)
    }

    //inorder:left->root->right, save sorted numbers in list，is Ascending
    /*private fun inorder(root:TreeNode?){
        if (root==null){
            return
        }
        inorder(root.left)
        list.add(root.`val`)
        inorder(root.right)
    }*/

    /** @return the next smallest number */
    fun next(): Int {
        //return list.removeAt(0)
        val node = stack.pop()
        //set next for right node
        setNext(node.right)
        return node.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        //return list.isNotEmpty()
        return stack.isNotEmpty()
    }

    private fun setNext(root_: TreeNode?) {
        //push the left node in stack, because left node in BST is always small
        //stack: first in last out
        var root = root_
        while (root != null) {
            stack.push(root)
            root = root.left
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */