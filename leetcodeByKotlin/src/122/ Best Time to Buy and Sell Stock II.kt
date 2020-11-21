package LeetCode_122

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
Example 1:
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * */
class Solution {
    /*
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 0 until prices.size - 1) {
            if (prices[i + 1] > prices[i]) {
                //because can many transactions, so we sum up the profile
                result += prices[i + 1] - prices[i]
            }
        }
        return result
    }
}