package LeetCode_1658

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * You are given an integer array nums and an integer x.
 * In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1

Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.

Constraints:
1. 1 <= nums.length <= 105
2. 1 <= nums[i] <= 104
3. 1 <= x <= 109
 * */
class Solution {
    /*
    * solution: Sliding Window, Time complexity:O(n), Space complexity:O(1)
    * 1. finding out the longest sub-array sum up to nums.sum-x,
    * 2. the result is nums.size - sub-array.size,
    * */
    fun minOperations(nums: IntArray, x: Int): Int {
        val target = nums.sum() - x
        var lengthOfSubArray = Int.MIN_VALUE
        var left = 0
        var currentSum = 0
        for (right in nums.indices) {
            currentSum += nums[right]
            while (currentSum > target && left <= right) {
                currentSum -= nums[left]
                left++
            }
            if (currentSum == target) {
                lengthOfSubArray = Math.max(lengthOfSubArray, right - left + 1)
            }
        }
        return if (lengthOfSubArray == Int.MIN_VALUE) -1 else nums.size - lengthOfSubArray
    }
}