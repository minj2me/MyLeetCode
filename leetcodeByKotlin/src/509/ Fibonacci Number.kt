package LeetCode_509

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

Example 1:
Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * */
class Solution {
    /*
    * solution: DP, Bottom-Up,
    * Time:O(n), Space:O(n)
    * */
    fun fib(N: Int): Int {
        if (N == 0) {
            return 0
        }
        if (N == 1) {
            return 1
        }
        val dp = IntArray(N + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..N) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[N]
    }
}