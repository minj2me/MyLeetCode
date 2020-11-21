package LeetCode_70

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 * */
class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }
        //method 1: TLE
        //return climbStairs(n-1)+climbStairs(n-2)
        //dp
        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2
        for (i in 2 until n) {
            dp[i] = dp[i - 2] + dp[i - 1]
        }
        return dp[dp.size - 1]
    }
}