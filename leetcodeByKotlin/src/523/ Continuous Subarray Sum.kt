package LeetCode_523

/**
 * 523. Continuous Subarray Sum
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k,
 * that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * */
class Solution {
    /*
    * solution 1: prefix sum, Time complexity:O(n^2), Space complexity:O(1)
    * solution 2: hash map, Time complexity:O(n), Space complexity:O(n)
    * */
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        for (i in nums.indices) {
            var num = nums[i]
            for (j in i + 1 until nums.size) {
                num += nums[j]
                if (num == k) {
                    return true
                }
                if (k != 0) {
                    if (num % k == 0) {
                        return true
                    }
                }
            }
        }
        return false
    }
}