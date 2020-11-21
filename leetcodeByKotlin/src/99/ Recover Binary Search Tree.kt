package LeetCode_99

import java.util.*
import kotlin.collections.ArrayList

/**
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.

Example 1:
Input: [1,3,null,null,2]
  1
 /
3
 \
  2

Output: [3,1,null,null,2]
  3
 /
1
 \
  2

Follow up:
A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 * */

class TreeNode(var `val`:Int){
    var left:TreeNode?=null
    var right:TreeNode?=null
}

class Solution {
    /*
    * Solution 1: In-order + Two List and Sort, Time complexity:O(nlogn), Space complexity:O(n);
    * Solution 2: Morris Traversal,
    * */
    fun recoverTree(root: TreeNode?): Unit {
        val listForNode = ArrayList<TreeNode>()
        val listForValue = ArrayList<Int>()
        inorder(root,listForNode,listForValue)
        listForValue.sort()
        //update the node value by sorted array
        for (i in listForNode.indices){
            listForNode[i].`val` = listForValue[i]
        }
    }

    private fun inorder(root_:TreeNode?, listForNode:ArrayList<TreeNode>, listForValue:ArrayList<Int>){
        var root = root_
        val stack = Stack<TreeNode>()
        while (stack.isNotEmpty() || root!=null){
            if (root!=null){
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                listForNode.add(root)
                listForValue.add(root.`val`)
                root = root.right
            }
        }
    }
}