package LeetCode_206

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * Reverse a singly linked list.
 *
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head_: ListNode?): ListNode? {
        //iteratively
        var head = head_
        var prve: ListNode? = null
        while (head != null) {
            val temp = head.next
            head.next = prve
            prve = head
            head = temp
        }
        return prve

        /*var current = head
        var newHead: ListNode? = null
        var next: ListNode? = null
        while (current!=null){
            next = current.next
            current.next = newHead
            newHead = current
            current = next //let the head change into last one
        }
        return newHead*/

        //recursively
        /**
         * 下面我们来看递归解法，代码量更少，递归解法的思路是，不断的进入递归函数，
         * 直到head指向倒数第二个节点，因为head指向空或者是最后一个结点都直接返回了，
         * newHead则指向对head的下一个结点调用递归函数返回的头结点，此时newHead指向最后一个结点，
         * 然后head的下一个结点的next指向head本身，这个相当于把head结点移动到末尾的操作，因为是回溯的操作，
         * 所以head的下一个结点总是在上一轮被移动到末尾了，但head之后的next还没有断开，所以可以顺势将head移动到末尾，
         * 再把next断开，最后返回newHead即可，代码如下：
         * */
        /*if (head == null || head.next == null) {
            return head
        }
        val newHead = reverseList(head.next)
        head.next!!.next = head
        head.next = null
        return newHead*/

        //iteratively2
        /*if (head == null || head.next == null) {
            return head
        }
        var cur = head
        var pre: ListNode? = null
        while (cur != null) {
            val temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        }
        return pre*/
    }

}