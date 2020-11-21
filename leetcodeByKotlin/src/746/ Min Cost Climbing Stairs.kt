package LeetCode_746

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
and you can either start from the step with index 0, or the step with index 1.
//1, 100, 1, 1, 1, 100, 1, 1, 100, 1
 * */
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost == null || cost.size == 0) {
            return 0
        }
        val dp = IntArray(cost.size+1)
        for (i in 2 .. cost.size) {
            //一个是从第 i-2 层上直接跳上来，一个是从第 i-1 层上跳上来
            //不会再有别的方法，所以 dp[i] 只和前两层有关系
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1])
        }
        return dp[dp.size  - 1]
    }
}