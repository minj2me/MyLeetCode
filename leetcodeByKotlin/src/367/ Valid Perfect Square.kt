package LeetCode_367

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/description/
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.

Example 1:
Input: num = 16
Output: true

Example 2:
Input: num = 14
Output: false

Constraints:
1 <= num <= 2^31 - 1
 * */
class Solution {
    /*
    * solution: binary search
    * */
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) {
            return true
        }
        var left = 0
        var right = num
        //close left and open right
        while (left < right) {
            val m = left + (right - left) / 2
            if (m * m == num) {
                return true
            } else if (m > num / m) {
                right = m
            } else {
                left = m + 1
            }
        }
        return false
    }
}