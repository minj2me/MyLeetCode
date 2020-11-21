package LeetCode_147

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * Sort a linked list using insertion sort.
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        var head_ = head
        var dummy = ListNode(-1)
        var cur = dummy
        while (head_ != null) {
            var t = head_.next
            cur = dummy//cur alway is -1
            println("cur:" + cur.`val`)
            while (cur.next != null && cur.next!!.`val` <= head_!!.`val`) {
                cur = cur.next!!
            }
            head_.next = cur.next
            cur.next = head_
            head_ = t
        }
        return dummy.next
    }
}