package LeetCode_29

/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero, which means losing its fractional part.
For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
For this problem, assume that your function returns 2^31 − 1 when the division result overflows.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.

Example 3:
Input: dividend = 0, divisor = 1
Output: 0

Example 4:
Input: dividend = 1, divisor = 1
Output: 1

Constraints:
1. -2^31 <= dividend, divisor <= 2^31 - 1
2. divisor != 0
 * */
class Solution {
    /*
    * solution: reducing dividend, Time:O(dividend), Space:O(1)
    * */
    fun divide(dividend: Int, divisor: Int): Int {
        //conner case
        if (dividend == 0) {
            return 0
        }
        if (dividend != divisor && divisor == Int.MIN_VALUE) {
            return 0
        }
        if (dividend == divisor) {
            return 1
        }
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }
        //checking position or negative
        var sign = 1
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1
        }
        var dividendAbs = Math.abs(dividend * 1L)
        var divisorAbs = Math.abs(divisor * 1L)
        var result = 0
        while (dividendAbs >= divisorAbs) {
            dividendAbs -= divisorAbs
            result++
        }
        return if (sign==-1) -result else result
    }
}