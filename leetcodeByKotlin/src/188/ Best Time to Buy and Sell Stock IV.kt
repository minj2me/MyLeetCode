package LeetCode_188

/**
 * 188. Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * Say you have an array for which the i-th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:
Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * */
class Solution {
    /*
    * Time complexity:O(nk), Space complexity:O(k)
    * */
    fun maxProfit(k: Int, prices: IntArray): Int {
        val n = prices.size
        if (n <= 1 || k <= 0) {
            return 0
        }

        var profit = 0
        //check the k, if large than n, will be Memory Limit Exceeded
        //so do below like Leetcode_122
        if (k > n / 2) {
            for (i in 0 until prices.size - 1) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i]
                }
            }
            return profit
        }

        val buys = IntArray(k){ Int.MIN_VALUE }
        val sells = IntArray(k)
        for (i in prices.indices) {
            for (j in 0 until k) {
                val price = if (j == 0) -prices[i] else (sells[j - 1] - prices[i])
                buys[j] = Math.max(buys[j], price)
                sells[j] = Math.max(sells[j], buys[j] + prices[i])
            }
        }
        return sells[k - 1]
    }
}