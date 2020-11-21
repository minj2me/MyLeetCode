package LeetCode_303

/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 * */
class NumArray(nums: IntArray) {
    var dp: IntArray

    init {
        this.dp = nums
        for (i in 1 until nums.size) {
            dp[i] = dp[i] + dp[i - 1]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return if (i == 0) dp[j] else dp[j] - dp[i - 1]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */