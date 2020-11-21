package LeetCode_121

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * */
class Solution {
    /*
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        var minPrice = Int.MAX_VALUE
        var profit = 0
        for (i in 0 until prices.size - 1) {
            if (prices[i + 1] > prices[i]) {
                //buy in the lower price, so keep tracking the min price so far
                minPrice = Math.min(minPrice, prices[i])
                //sell in the high price
                profit = Math.max(profit, prices[i + 1] - minPrice)
            }
        }
        return profit
    }
}