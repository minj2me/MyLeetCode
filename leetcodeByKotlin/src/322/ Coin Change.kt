package LeetCode_322

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.
 * */
class Solution {
    private var array: IntArray? = null

    fun coinChange(coins: IntArray, amount: Int): Int {
        //init array with amount + 1, then we can use it conveniently
        array = IntArray(amount + 1, { 0 })
        return dp(coins, amount)
    }

    /*
    * solution: recursion + memorization (Top-Down), Time complexity:O(amount*amount), Space complexity:O(amount+1)
    * */
    private fun dfs(coins: IntArray, target: Int): Int {
        if (target < 0) {
            return -1
        }
        if (target == 0) {
            //match the amount, mean no more coin to add
            return 0
        }
        if (array!![target] != 0) {
            return array!![target]
        }
        var min = Int.MAX_VALUE
        for (coin in coins) {
            val sub = dfs(coins, target - coin)
            if (sub >= 0 && sub < min) {
                //+1, just mean we had used 1 coin
                min = 1 + sub
            }
        }
        array!![target] = if (min == Int.MAX_VALUE) -1 else min
        return array!![target]
    }

    /*
    solution 2: dp (Bottom-Up)
    * */
    private fun dp(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1, { amount + 1 })
        //mean that can use zero coin to sum up 0
        dp[0] = 0//<-count of icon
        for (i in 0..amount) {
            for (coin in coins) {
                if (i >= coin) {
                    //dp[i - coin] + 1, i used that coin
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1)
                }
            }
        }
        return if (dp[amount] > amount) -1 else dp[amount]
    }
}