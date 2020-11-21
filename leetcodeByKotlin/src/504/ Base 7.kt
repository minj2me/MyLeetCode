package LeetCode_504

/**
 * 504. Base 7 (7进制)
 * https://leetcode.com/problems/base-7/description/
 * Given an integer, return its base 7 string representation.
 * Note: The input will be in range of [-1e7, 1e7].
 * */
class Solution {
    fun convertToBase7(num_: Int): String {
        var num = num_
        if (num == 0) {
            return "0"
        }
        val isNegative = num < 0
        num = Math.abs(num)
        val sb = StringBuilder()
        while (num != 0) {
            sb.append(num % 7)
            num /= 7
        }
        if (isNegative) {
            sb.append("-")
        }
        return sb.reverse().toString()
    }
}