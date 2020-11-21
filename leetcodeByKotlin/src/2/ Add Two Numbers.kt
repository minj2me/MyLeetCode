package LeetCode_2

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1_: ListNode?, l2_: ListNode?): ListNode? {
        var l1 = l1_
        var l2 = l2_
        var tail = ListNode(-1)
        val dummy = tail
        var sum = 0
        while (l1 != null || l2 != null || sum > 0) {
            val l1Value = if (l1 == null) 0 else l1.`val`
            val l2Value = if (l2 == null) 0 else l2.`val`
            sum += l1Value + l2Value
            tail.next = ListNode(sum % 10)//get ones digits
            tail = tail.next!!
            if (l1 != null) {
                l1 = l1.next
            }
            if (l2 != null) {
                l2 = l2.next
            }
            sum /= 10
        }
        return dummy.next
    }
}