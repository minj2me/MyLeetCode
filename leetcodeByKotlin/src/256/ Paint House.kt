package LeetCode_256

/**
 * 256. Paint House
 * Lock in leetcode
 * https://www.lintcode.com/problem/paint-house/description
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color, and you need to cost the least.
 * Return the minimum cost.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
For example,
costs[0][0] is the cost of painting house 0 with color red;
costs[1][2] is the cost of painting house 1 with color green,
and so on... Find the minimum cost to paint all houses.
All costs are positive integers.

Example
Input: [[14,2,11],[11,14,5],[14,3,10]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10.
 * */
class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    fun minCost(costs: Array<IntArray>): Int {
        if (costs == null || costs.size === 0) {
            return 0
        }
        val dp: Array<IntArray> = costs //init dp array
        for (i in 1 until dp.size) {
            //dp[i][j] 表示刷到第 i+1 房子用颜色j的最小花费
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2])
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2])
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1])
        }
        val n = dp.size - 1
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2])
    }
}