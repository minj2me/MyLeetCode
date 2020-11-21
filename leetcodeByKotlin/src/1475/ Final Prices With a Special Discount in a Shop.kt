package LeetCode_1475

import java.util.*

/**
 * 1475. Final Prices With a Special Discount in a Shop
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
 *
 * Given the array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.

Example 1:
Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
 * */
class Solution {
    /**
     * solution 1: brute force, Time complexity:O(n*n), Space complexity:O(1)
     * solution 2: monotonic stack, Time complexity:O(n), Space complexity:O(n)
     * */
    fun finalPrices(prices: IntArray): IntArray {
        val n = prices.size
        //soluton 1
        /*for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (prices[i] >= prices[j]) {
                    prices.set(i, prices[i] - prices[j])
                    break
                }
            }
        }*/
        //solution 2
        val stack = Stack<Int>()
        for (i in 0 until n) {
            while (stack.isNotEmpty() && prices[stack.peek()] >= prices[i]) {
                val index = stack.pop()
                prices.set(index, prices[index] - prices[i])
            }
            stack.push(i)
        }
        return prices
    }
}