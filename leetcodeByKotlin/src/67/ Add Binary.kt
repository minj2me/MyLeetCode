package LeetCode_67

import java.lang.StringBuilder

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/description/
 * https://www.youtube.com/watch?v=OEW50g03mT0
 *
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010",
b = "1011"
Output: "10101"
 * */
class Solution {
    /*
    * solution:Time complexity:O(m+n), Space complexity:O(n)
    * */
    fun addBinary(a: String, b: String): String {
        var i = a.length - 1
        var j = b.length - 1
        var carry = 0
        val sb = StringBuilder()
        while (i >= 0 || j >= 0) {
            var sum = carry
            if (i >= 0) {
                sum += (a[i--] - '0')//change a[i] into digital
            }
            if (j >= 0) {
                sum += (b[j--] - '0')//change a[j] into digital
            }
            //insert sum's binary into head of result,and no need to reverse
            sb.insert(0, sum % 2)
            //get the carry
            carry = sum / 2
        }
        //if carry is 1, insert into head
        if (carry != 0) {
            sb.insert(0, carry)
        }
        println("result:${sb.toString()}")
        return sb.toString()
    }
}