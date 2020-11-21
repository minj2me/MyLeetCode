package LeetCode_1480

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * */
class Solution {
    /*
    * solution 1: Time:O(n), Space:O(n)
    * solution 2: Time:O(n), Space:O(1)
    * */
    fun runningSum(nums: IntArray): IntArray {
        if (nums == null || nums.isEmpty()) {
            return nums
        }
        //solution 1:
        /*val result = IntArray(nums.size)
        result[0] = nums[0]
        for (i in 1 until nums.size) {
            result[i] = nums[i] + result[i - 1]
        }
        return result*/

        //solution 2
        for (i in 1 until nums.size) {
            nums[i] += nums[i - 1]
        }
        return nums
    }
}