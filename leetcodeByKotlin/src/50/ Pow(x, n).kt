package LeetCode_50

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/description/
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100

Note:
-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 * */
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n < 0) {
            return 1 / help(x, n)
        }
        return help(x, n)
    }

    private fun help(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        val half = help(x, n / 2)
        //handle n is odd or even
        if (n % 2 == 0) {
            return half * half
        } else {
            return half * half * x
        }
    }
}