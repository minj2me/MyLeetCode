package LeetCode_234

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * solution: slow and fast pointer, reverse half of linked list then compare both half,
    * Time:O(n), Space:O(1)
    * */
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return true
        }
        var slow = head
        var fast = head
        while (fast != null && fast!!.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        slow = reverse(slow)
        fast = head
        while (slow != null) {
            if (slow.`val` != fast!!.`val`) {
                return false
            }
            fast = fast.next
            slow = slow.next
        }
        return true
    }

    private fun reverse(head_: ListNode?): ListNode {
        var head = head_
        var prev: ListNode? = null
        while (head != null) {
            val temp = head.next
            head.next = prev
            prev = head
            head = temp
        }
        return prev!!
    }
}