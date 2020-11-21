package LeetCode_8

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
Note:
1. Only the space character ' ' is considered a whitespace character.
2. Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:[−231,  231 − 1].
If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 1:
Input: str = "42"
Output: 42

Example 2:
Input: str = "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
Then take as many numerical digits as possible, which gets 42.
 * */
class Solution {
    fun myAtoi(s: String): Int {
        var str = s
        str = str.trim()
        if (str.isEmpty()) {
            return 0
        }
        //avoid loss of accuracy
        var sum = 0L
        var start = 0
        val length = str.length
        val first = str[0]
        //1:positive, -1:negative
        var sign = 1
        if (first == '+') {
            sign = 1
            start++
        } else if (first == '-') {
            sign = -1
            start++
        }
        for (i in start until length) {
            val c = str[i]
            //scan till meet not digit, return result
            if (!c.isDigit()) {
                return (sum * sign).toInt()
            }
            sum = sum * 10 + (c - '0')
            if (sign == 1 && sum > Int.MAX_VALUE) {
                return Int.MAX_VALUE
            }
            if (sign == -1 && (-1 * sum) < Int.MIN_VALUE) {
                return Int.MIN_VALUE
            }
        }
        return (sum * sign).toInt()
    }
}