package LeetCode_142

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Notice that you should not modify the linked list.

Follow up:
Can you solve it using O(1) (i.e. constant) memory?
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * solution: Two pointer, fast and slow
    * */
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        //detect if had cycle
        var fast = head
        var slow = head
        var hasCycle = false
        //fast each take two steps
        //slow each take one step
        while (fast != null && fast.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) {
                hasCycle = true
                break
            }
        }
        if (!hasCycle) {
            return null
        }
        //reset the fast
        fast = head
        //if fast and slow meet at a point, break
        while (fast != slow) {
            fast = fast?.next
            slow = slow?.next
        }
        return fast
    }
}