package LeetCode_263

/**
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/description/
 *
 * Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:
Input: 6
Output: true
Explanation: 6 = 2 × 3

Example 2:
Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2

Example 3:
Input: 14
Output: false
Explanation: 14 is not ugly since it includes another prime factor 7.

Note:
1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].
 * */
class Solution {
    /*
    * solution: keep tracking num if can divide by 2,3,5
    * */
    fun isUgly(num: Int): Boolean {
        if (num == 0) {
            return false
        }
        var num_ = num
        val factorsArray = intArrayOf(2, 3, 5)
        for (item in factorsArray) {
            while (num_ % item == 0) {
                num_ /= item
            }
        }
        return num_ == 1
    }
}