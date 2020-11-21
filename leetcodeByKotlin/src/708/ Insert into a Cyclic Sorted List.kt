package LeetCode_708

/**
 * 708. Insert into a Cyclic Sorted List
 * (Prime)
 * Given a node from a cyclic linked list which is sorted in ascending order,
 * write a function to insert a value into the list such that it remains a cyclic sorted list.
 * The given node can be a reference to any single node in the list,and may not be necessarily the smallest value in the cyclic list.
If there are multiple suitable places for insertion, you may choose any place to insert the new value.
After the insertion, the cyclic list should remain sorted.
If the list is empty (i.e., given node is null),
you should create a new single cyclic list and return the reference to that single node.
Otherwise, you should return the original given node.

Example 1:
Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements.
You are given a reference to the node with value 3, and we need to insert 2 into the list.
The new node should be inserted between node 1 and node 3.
After the insertion, the list should look like this, and we should still return node 3.

Example 2:
Input: head = [], insertVal = 1
Output: [1]
Explanation: The list is empty (given head is null).
We create a new single circular list and return the reference to that single node.

Example 3:
Input: head = [1], insertVal = 0
Output: [1,0]

Constraints:
1. 0 <= Number of Nodes <= 5 * 10^4
2. -10^6 <= Node.val <= 10^6
3. -10^6 <= insertVal <= 10^6
 * */
class ListNode(var `val`: Int, next_: ListNode?) {
    var next: ListNode? = null

    init {
        this.next = next_
    }
}

class Solution {
    /*
    * solution: handle 3 situations
    * */
    fun insert(head: ListNode?, insertVal: Int): ListNode? {
        val newNode = ListNode(insertVal, null)
        if (head == null) {
            newNode.next = newNode
            return newNode
        }
        var prev = head
        var next = head.next
        while (next != head) {
            //insert into flat or rising range
            if (prev?.`val` == insertVal || (prev?.`val`!! < insertVal && insertVal < next!!.`val`)) {
                val cur = ListNode(insertVal, next)
                prev.next = cur
                return head
            }
            //insert into peak or falling range
            if (prev.`val` > next!!.`val` && (insertVal < next.`val` || insertVal > prev.`val`)) {
                val cur = ListNode(insertVal, next)
                prev.next = cur
                return head
            }
            prev = next
            next = next.next
        }
        //insert before head
        val cur = ListNode(insertVal, next)
        prev?.next = cur

        return head
    }
}