package LeetCode_402

import java.util.*

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * */
class Solution {
    /*
    * solution: Stack, scan each number, check current num if large than then the first one in stack,
    * pop the large one, keep some small numbers in stack;
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun removeKdigits(num: String, k: Int): String {
        var k_ = k
        val stack = Stack<Int>()
        for (c in num) {
            //change into digits
            val n = c - '0'
            while (k_ > 0 && stack.isNotEmpty() && stack.peek() > n) {
                //pop the large one, keep some small numbers in stack
                stack.pop()
                k_--
            }
            stack.push(n)
        }
        //handle case some case, for example 1111
        while (k_ > 0) {
            stack.pop()
            k_--
        }
        //construct the result from the stack
        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
        }
        sb.reverse()
        //remove leading zero, if sb=="0", no need to remove
        while (sb.length > 1 && sb[0] == '0') {
            sb.deleteCharAt(0)
        }
        return sb.toString()
    }
}