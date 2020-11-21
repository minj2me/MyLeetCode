package LeetCode_198

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * */
class Solution {
    fun rob(nums: IntArray): Int {
        //try dp
        val n = nums.size
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return nums[0]
        }
        val dp = IntArray(n + 1)
        dp[0] = nums[0]
        dp[1] = Math.max(dp[0], nums[1])
        for (i in 2 until n) {
            //由于不能抢相邻的，所以可以用再前面的一个的 dp 值加上当前的房间值，和当前房间的前面一个 dp 值比较，取较大值当做当前 dp 值
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
            //println("dp[$i]:${dp[i]}")
        }
        return dp[n - 1]
    }
}