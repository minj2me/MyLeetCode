package LeetCode_237

/**
 * 237. Delete Node in a Linked List
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun deleteNode(node: ListNode) {
        //var node = node_
        node.`val` = node.next!!.`val`
        node.next = node.next!!.next
    }
}