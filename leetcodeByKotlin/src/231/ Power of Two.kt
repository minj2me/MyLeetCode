package LeetCode_231

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/description/
 * Given an integer, write a function to determine if it is a power of two.
 * 判断数字是否是 2 的幂次方；
 * 分析2的次方数的二进制写法:
 * 1: 1
 * 2: 100
 * 4: 100
 * 8: 1000
 * 16:10000
 * 看出 2 的次方数都只有一个1, 剩下的都是0
 * */
class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        var num = n
        var count = 0
        while (num > 0) {
            count += num and 1
            num = num shr 1
        }
        return count == 1
    }
}