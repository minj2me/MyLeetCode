package LeetCode_213

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 * */
class Solution {
    fun rob(nums: IntArray): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        //because there are a circle, so you can not rob both first and last together
        //172ms
        /*val numsWithOutFirst = nums.slice(1..nums.size-1).toIntArray()
        val numsWithOutLast = nums.slice(0..nums.size-2).toIntArray()
        val maxWithOutFirst = helpRob(numsWithOutFirst)
        val maxWithOutLast = helpRob(numsWithOutLast)
        return Math.max(maxWithOutFirst, maxWithOutLast)*/

        //140ms
        return Math.max(helpRob(nums, 0, nums.size - 1), helpRob(nums, 1, nums.size))
    }

    private fun helpRob(nums: IntArray): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }
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
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[n - 1]
    }

    private fun helpRob(nums: IntArray, left: Int, right: Int): Int {
        //avoid case:[0,0]
        if (right - left <= 1) {
            return nums[left]
        }
        val dp = IntArray(right)
        dp[left] = nums[left]
        dp[left + 1] = Math.max(nums[left], nums[left + 1])
        for (i in 2 until right) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[dp.size - 1]
    }
}