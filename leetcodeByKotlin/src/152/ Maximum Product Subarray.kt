package LeetCode_152

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
 * */
class Solution {
    fun maxProduct(nums: IntArray): Int {
        if (nums == null || nums.size == 0) {
            return 0
        }
        var res = nums[0]
        var minValue = nums[0]
        var maxValue = nums[0]
        for (i in 1 until nums.size) {
            val temp1 = minValue * nums[i]
            val temp2 = maxValue * nums[i]
            minValue = Math.min(nums[i], Math.min(temp1, temp2))
            maxValue = Math.max(nums[i], Math.max(temp1, temp2))
            res = Math.max(res, maxValue)
        }
        return res
    }
}