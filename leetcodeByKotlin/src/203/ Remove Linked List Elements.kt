package LeetCode_203

/***
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * Remove all elements from a linked list of integers that have value val.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        var head_ = ListNode(1)
        head_.next = ListNode(2)
        head_.next!!.next = ListNode(3)
        /*if (head == null) {
            return head
        }*/
        //var head_ = head
        //help by 2 pointer: dummy, pre
        val dummy = ListNode(-1)//fake head
        var pre = dummy
        dummy.next = head_
        while (pre.next!=null) {
            if (pre.next!!.`val` == value) {
                pre.next = pre.next!!.next
            } else {
                pre = pre.next!!
            }
        }
        printNode(dummy.next)
        return dummy.next
    }

    private fun printNode(head: ListNode?){
        var head_ = head
        while (head_!=null){
            println(head_.`val`)
            head_ = head_!!.next
        }
    }
}