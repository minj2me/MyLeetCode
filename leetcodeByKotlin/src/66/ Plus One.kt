package LeetCode_66

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/description/
 * https://www.cnblogs.com/grandyang/p/4079357.html
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list,
and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 * */
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val n = digits.size
        for (i in (n - 1) downTo 0) {
            if (digits[i] < 9) {
                ++digits[i]
                return digits
            }
            digits[i] = 0//把该位的9变成0
        }
        //处理尾数为9的情况
        val result = IntArray(n + 1)
        result[0] = 1
        return result
    }
}