package LeetCode_24

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        //dummy node
        val dummy = ListNode(-1)
        var prve = dummy
        var first: ListNode? = null
        dummy.next = head
        while (prve != null) {
            if (prve.next == null || prve.next!!.next == null) {
                break
            }
            first = prve.next
            prve.next = first!!.next
            first.next = first.next!!.next
            prve.next!!.next = first
            prve = first
        }
        return dummy.next
    }
}