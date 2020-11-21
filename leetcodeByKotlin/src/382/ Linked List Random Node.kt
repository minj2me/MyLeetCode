package LeetCode_382

import java.util.*

/**
 * 382. Linked List Random Node
 *https://leetcode.com/problems/linked-list-random-node/
 *
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
Follow up:
What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

Example:
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);
// getRandom() should return either 1, 2, or 3 randomly.
Each element should have equal probability of returning.
solution.getRandom();
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/*
  solution 1: calculate the length of ListNode, then return node's value by a random num from length;
* solution Follow up: Reservoir sampling, 1/i * (1-1/(i+1)) * (1-1/(i+2)) * (1-1/(i+3)) .. (1-1/n);
* */
class Solution(head: ListNode?) {

    var length = 0
    var cur = head
    var head2 = head

    init {
        getLength(cur)
    }

    private fun getLength(head_: ListNode?) {
        var head = head_
        while (head != null) {
            length++
            head = head.next
        }
    }

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */

    /** Returns a random node's value. */
    fun getRandom(): Int {
        var cur = head2
        var randomNum = Random().nextInt(length)
        while (randomNum > 0) {
            randomNum--
            cur = cur?.next
        }
        return cur!!.`val`
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */