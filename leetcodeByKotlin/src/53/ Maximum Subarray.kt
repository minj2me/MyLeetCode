package LeetCode_53

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 * https://www.cnblogs.com/grandyang/p/4377150.html
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 * */
class Solution {
    /*
    * solution: prefix sum
    * */
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var currentNum = 0
        for (num in nums) {
            currentNum += num
            currentNum = Math.max(currentNum, num)
            max = Math.max(currentNum, max)
        }
        return max
    }
}