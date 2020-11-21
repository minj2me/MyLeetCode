package LeetCode_328

import LeetCode_390.ListNode

/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *https://leetcode.com/articles/odd-even-linked-list/
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

!! The best way of solving any linked list problem is to visualize it either in your mind or on a piece of paper.
 * */
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head==null || head.next==null){
            return null
        }
        var odd = head
        var even = head.next
        //将even的值(它存储的地址编号）如0x0001赋值给evenHead，所以evenHead的值变为了0x0001
        val evenHead = head.next//这里打印是2->3->4->5
        //printNode(evenHead)
        while (even!=null && even.next!=null){
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        //如1,2,3,4,5,add这时的值是最后一个odd数，是5,
        //所以把他与evenHead边起来
        odd?.next = evenHead
        //这时的evenHead还是指向even的，但even的指向在while里有变化了
        //所以这里打印还是2开头
        return head
    }

    private fun printNode(node_:ListNode?){
        var node = node_
        while (node!=null){
            print(node.`val`)
            print("->")
            node = node.next
        }
    }
}