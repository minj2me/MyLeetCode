package LeetCode_61

/**
 * 61. Rotate List
 * * https://leetcode.com/problems/rotate-list/
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * solution, step:
    * 1. count the length of ListNode and find out tail
    * 2. find out new-head's prev node and set this prev node.next = null
    * 3. set tail.next = head
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        //if not null, mean length at least 1
        var length = 1
        var tail = head
        //avoid set tail to null
        while (tail!!.next != null) {
            length++
            tail = tail.next
        }
        //rotate k time == rotate k % length time, avoid k larger than length
        val k_ = k % length
        if (k_ == 0) {
            //after k step, the same with the old head
            return head
        }
        /*
        * find out newHead's prev node, for example: 1->2->3->4->5, k=2, need change into: 4->5->1->2->3
        * newHead should be 4,it's prev node is 3, and 3 is the tail of newHead, so set 3.next = null
        * */
        var prevOfNewHead = head
        for (i in 0 until length - k_ - 1) {
            prevOfNewHead = prevOfNewHead!!.next
        }
        //create new head
        val newHead = prevOfNewHead!!.next
        prevOfNewHead.next = null
        //set 5.next = old head
        tail!!.next = head
        return newHead
    }
}