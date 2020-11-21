package LeetCode_23
import java.util.*
/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
Input:
[
1->4->5,
1->3->4,
2->6
]
Output: 1->1->2->3->4->4->5->6
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * use priorityQueue, can use for linked list or array
    * Time complexity: O(nklogk),
    * n is the size of list, k is the size of priorityQueue, each execute in priorityQueue is logk
    * Space: O(k)+O(n)
    * */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<ListNode> { a, b -> a.`val` - b.`val` }
        minHeap.poll()
        val dummy = ListNode(-1)
        for (node in lists) {
            if (node != null) {
                minHeap.offer(node)
            }
        }
        var cur = dummy
        while (minHeap.isNotEmpty()) {
            val node = minHeap.poll()
            cur.next = node
            //also check the children
            if (node.next != null) {
                minHeap.offer(node.next)
            }
            cur = cur.next!!
        }
        return dummy.next
    }
}