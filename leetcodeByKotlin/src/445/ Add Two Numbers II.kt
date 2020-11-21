package LeetCode_445

import LeetCode_2.ListNode

/**
 * 445. Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 * */
class Solution {
    /*
    * Time complexity:O(max(m,n)), Space complexity:O(max(m,n))
    * */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val str1 = listNodeToString(l1)
        val str2 = listNodeToString(l2)
        val array1 = str1.toCharArray()
        val array2 = str2.toCharArray()
        var i = array1.size - 1
        var j = array2.size - 1
        var carry = 0
        val sb = StringBuilder()
        while (i >= 0 || j >= 0) {
            val value1 = if (i >= 0) array1[i--] - '0' else 0
            val value2 = if (j >= 0) array2[j--] - '0' else 0
            var temp = value1 + value2 + carry
            if (temp >= 10) {
                carry = temp / 10
                temp %= 10
            } else {
                carry = 0
            }
            sb.insert(0, temp)
        }
        if (carry != 0) {
            sb.insert(0, 1)
        }
        val dummy = ListNode(0)
        var head = dummy
        for (item in sb) {
            head.next = ListNode(item - '0')
            head = head.next!!
        }
        return dummy.next
    }

    private fun listNodeToString(l1_: ListNode?): String {
        var l1 = l1_
        val sb = StringBuilder()
        while (l1 != null) {
            sb.append(l1.`val`)
            l1 = l1.next
        }
        return sb.toString()
    }
}