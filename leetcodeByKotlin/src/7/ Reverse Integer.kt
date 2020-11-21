package LeetCode_7

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 * */
class Solution {
    fun reverse(x_: Int): Int {
        var x = x_
        var result: Long = 0
        var isNegitive = false
        if (x < 0) {
            isNegitive = true
            x *= -1
        }
        while (x > 0) {
            result = result * 10 + x % 10
            x /= 10
        }
        if (result > Int.MAX_VALUE) {
            return 0
        }
        return if (isNegitive) -result.toInt() else result.toInt()
    }
}