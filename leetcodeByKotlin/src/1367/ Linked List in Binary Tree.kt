package LeetCode_1367

import LeetCode_1382.TreeNode
import LeetCode_390.ListNode

/**
 * 1367. Linked List in Binary Tree
 * https://leetcode.com/problems/linked-list-in-binary-tree/description/
 * */
class Solution {
    /*
    solution: recursion
    *  Time complexity: O(head.size * root.size)
    * Space complexity: O(root.size)
    * */
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        //check head with root, root.left, root.right
        return isPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right)
    }

    private fun isPath(head: ListNode?, root: TreeNode?): Boolean {
        if (head == null) {//if head is null, check the next one
            return true
        }
        if (root == null) {
            return false
        }
        if (root.`val` != head.`val`) {
            return false
        }
        return isPath(head.next, root.left) || isPath(head.next, root.right)
    }
}