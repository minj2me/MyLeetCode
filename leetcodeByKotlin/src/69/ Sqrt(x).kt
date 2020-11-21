package LeetCode_69

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/description/
 *
 * Implement int sqrt(int x).
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
the decimal part is truncated, 2 is returned.
 * */
class Solution {
    /*
    * solution: Binary Search
    * */
    fun mySqrt(x: Int): Int {
        var l = 0
        var r = x
        //close left and open right
        while (l < r) {
            val m = l + (r - l) / 2
            if (m > x / m) {//<=m(g)
                //new range:[l,m)
                r = m
            } else {
                l = m + 1
            }
        }
        //l is the first one large than Sqrt(x), so return l-1
        return l - 1
    }
}