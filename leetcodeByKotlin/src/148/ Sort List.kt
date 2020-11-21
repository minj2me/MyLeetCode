package LeetCode_148

/**
 * 148. Sort List
https://leetcode.com/problems/sort-list/description/
https://www.cnblogs.com/grandyang/p/4249905.html

 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * solution: Merge sort; find out mid point of listNode by tow pointer, fast and slow,
    * Time:O(nlogn), Space:O(logn)
    * */
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null)
            return head
        var cur: ListNode? = head
        var fast: ListNode? = head
        var slow: ListNode? = head
        while (fast != null && fast.next != null) {
            cur = slow
            slow = slow!!.next
            fast = fast!!.next!!.next
        }
        cur!!.next = null
        return merge(sortList(head), sortList(slow))
    }

    private fun merge(l1: ListNode?, l2: ListNode?): ListNode {
        if (l1 == null)
            return l2!!
        if (l2 == null)
            return l1
        if (l1.`val` < l2.`val`) {
            l1.next = merge(l1.next, l2)
            return l1
        } else {
            l2.next = merge(l1, l2.next)
            return l2
        }
    }
}