package LeetCode_25

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * https://www.cnblogs.com/grandyang/p/4441324.html
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(-1)
        var pre = dummy
        var current = head
        dummy.next = head
        return null
    }

    /**
     *
    -1->1->2->3->4->5
    |        |  |
    pre      cur next

    -1->3->2->1->4->5
    |     |  |
    cur   pre next
     *
     * */
    private fun reverseGroup(pre: ListNode, next: ListNode): ListNode {
        val last = pre.next
        var cur = last!!.next
        while (cur != next) {
            last.next = cur!!.next
            cur.next = pre.next
            pre.next = cur
            cur = last.next
        }
        return last
    }
}