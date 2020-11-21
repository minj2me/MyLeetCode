package LeetCode_633

/**
 * 633. Sum of Square Numbers
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: 3
Output: False
 * */
class Solution {
    /*
    * solution: two pointer, Time complexity:O(c/2), Space complexity:O(1)
    * */
    fun judgeSquareSum(c: Int): Boolean {
        var left = 0
        var right = Math.sqrt(c.toDouble()).toInt()
        while (left <= right) {
            val cur = left * left + right * right
            if (cur == c) {
                return true
            } else if (cur < c) {
                left++
            } else {
                right--
            }
        }
        return false
    }
}