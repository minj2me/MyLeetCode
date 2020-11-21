package LeetCode_123

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * */
class Solution {
    /*
    * solution: First buy,first sell, second buy, second sell
    * */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        var firstBuy = Int.MIN_VALUE
        var secondBuy = Int.MIN_VALUE
        var firstSell = 0
        var secondSell = 0
        for (price in prices) {
            firstBuy = Math.max(firstBuy, -price)
            firstSell = Math.max(firstSell, firstBuy + price)
            secondBuy = Math.max(secondBuy, firstSell - price)
            secondSell = Math.max(secondSell, secondBuy + price)
        }
        return secondSell
    }
}