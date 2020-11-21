package LeetCode_390

/**
 * 390. Elimination Game
 * https://leetcode.com/problems/elimination-game/description/
 *
 * Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun lastRemaining(n: Int,m:Int): Int {
        return josephus(n,m)
    }

    //just like problem: Josephus problem
    /*
    * Given a circular single linked list.
    * Write a program that deletes every kth node until only one node is left.
    After kth node is deleted, start the procedure from (k+1)th node.
    e.g.list is 1->2->3->4->5->1
    k=3
    1. You are at 1, delete 3.
    List is: 1->2->4->5->1
    2. You are at 4, delete 1
    List is: 2->4->5->2
    3. You are at 2,delete 5
    List is: 2->4->2
    4. You are at 2, delete 2
    List is: 4
    Return 4.
    * */
    fun josephus(n:Int,m:Int): Int {
        /*val head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(3)
        head.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next = ListNode(5)
        //create circle
        head.next!!.next!!.next!!.next!!.next = head
        //check it if has circle
        var prev = head
        while (prev!=null && prev.next != head) {
            prev = prev.next!!
        }
        if (prev==null){
            return -1
        }*/

        // Create a circular linked list of size N.
        val head = ListNode(1)
        var prev: ListNode = head
        for (i in 2..n) {
            prev.next = ListNode(i)
            prev = prev.next!!
        }
        // Connect last node to first
        prev.next = head
        //printDoubleLinkedlist(prev)
        //println("========")
        printDoubleLinkedlist(head)
        println("========")
        val k = 2
        var head_ = head
        //now the prev is previous of the head
        var count = 1//the start
        while (head_.next != head_) {
            if (count == k) {
                //if found, delete node and reset the count
                prev.next = head_.next
                head_ = head_.next!!
                count = 1
            } else {
                //when not found the value
                prev = prev.next!!
                head_ = head_.next!!
                count++
            }
            printDoubleLinkedlist(head_)
        }
        println(head_.`val`)
        return head_.`val`
    }

    private fun printDoubleLinkedlist(head: ListNode?) {
        var prve = head
        while (prve!!.next != head) {
            print(prve.`val`)
            if (prve.next != null) {
                print("->")
            }
            prve = prve!!.next
        }
        println("")
    }
}