package LeetCode_1290

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 * */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    /*
    * solution: get the length of ListNode, then use math formula to get the result
    * Time: O(n), Space: O(1)
    * */
    fun getDecimalValue(head_: ListNode?): Int {
        var result = 0
        var len = 0.0
        var node = head_
        var head = head_
        while (node != null) {
            len++
            node = node.next
        }
        len--
        //binary to decimal by math formula: (base two) 101 = 1*2^2 + 0*2^1 + 1*2^0
        while (head != null) {
            //2^len--
            result += head.`val` * Math.pow(2.0, len--).toInt()
            head = head.next
        }
        return result
    }
}