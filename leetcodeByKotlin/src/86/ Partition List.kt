package LeetCode_86

/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/description/
 *
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private fun printNode(head: ListNode?){
        var head_ = head
        while (head_!=null){
            print(head_.`val`)
            if (head_.next!=null) {
                print("->")
            }
            head_ = head_!!.next
        }
        println("")
    }

    fun partition(head: ListNode?, x: Int): ListNode? {
        //for test
        var head_ = ListNode(1)
        head_.next = ListNode(4)
        head_.next!!.next = ListNode(3)
        head_.next!!.next!!.next = ListNode(2)
        head_.next!!.next!!.next!!.next = ListNode(5)
        head_.next!!.next!!.next!!.next!!.next = ListNode(2)

        val dummy = ListNode(-1)
        val newDummy = ListNode(-1)
        dummy.next = head_
        var cur = dummy
        var p = newDummy
        //created new linked list p for the save the value less than x
        while (cur.next != null) {
            if (cur.next!!.`val` < x) {
                p.next = cur.next
                p = p.next!!
                //remove the current one and pointed to next
                cur.next = cur.next!!.next
                //p.next=null
            } else {
                cur = cur.next!!
            }
        }
        //because the cur was move always, so here just print out the value of last element, the same as p
        //printNode(cur)
        //printNode(dummy.next)
        //printNode(newDummy.next)//new linked list
        //printNode(dummy.next)//the old one after move element
        p.next = dummy.next//merge together
        printNode(newDummy.next)
        return newDummy.next
    }
}