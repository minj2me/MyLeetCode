package LeetCode_83

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private fun printNode(head: ListNode?) {
        var head_ = head
        while (head_ != null) {
            print(head_.`val`)
            if (head_.next != null) {
                print("->")
            }
            head_ = head_!!.next
        }
        println("")
    }

    fun deleteDuplicates(head_: ListNode?): ListNode? {
        if (head_ == null) {
            return head_
        }
        var result = head_
        var head = head_
        while (head!!.next != null) {
            if (head.`val` == head.next!!.`val`) {
                head.next = head.next!!.next
            } else {
                head = head!!.next
            }
        }
        //printNode(result)
        return result
    }

    /**
     * 82. Remove Duplicates from Sorted List II
     *https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
     *
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.

    Example 1:
    Input: 1->2->3->3->4->4->5
    Output: 1->2->5

    Example 2:
    Input: 1->1->1->2->3
    Output: 2->3
     * */
    fun deleteDuplicates2(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        ////4,3,2,5,1,1,8,8,10
        val dummy = ListNode(-1)
        var pre = dummy
        dummy.next = head
        while (pre.next != null) {
            var current = pre.next
            while (current!!.next != null && current.`val` == current.next!!.`val`) {
                current = current.next
                printNode(current)
            }
            //println("current.val: ${current.`val`}")
            //println("pre.next.val: ${pre.next!!.`val`}")
            //printNode(current)
            //println("========")
            if (pre.next != current) {
                //直到遇到不同项时，把前驱指针的next指向下面那个不同的元素
                pre.next = current.next
            } else {
                pre = pre.next!!
            }
        }
        //because head_ was move always, so return result
        //printNode(dummy.next)
        return dummy.next
    }
}
