package LeetCode_16

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Constraints:
1. 3 <= nums.length <= 10^3
2. -10^3 <= nums[i] <= 10^3
3. -10^4 <= target <= 10^4
 * */
class Solution {
    /*
    * solution: sort Array and two pointer, and use minDiff to keep tracking the minimum diff of 3 sums,
    * Time complexity: O(n^2), Space complexity: O(1)
    * */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closest = 0
        var minDiff = Int.MAX_VALUE
        val n = nums.size
        for (i in nums.indices) {
            var left = i + 1
            var right = n - 1
            while (left < right) {
                val curSum = nums[i] + nums[left] + nums[right]
                if (curSum == target) {
                    return curSum
                }
                if (curSum < target) {
                    //if sum less than target, we need more large number, so left++
                    left++
                } else {
                    right--
                }
                val diff = Math.abs(target - curSum)
                //curSum is closest to target in this situation
                if (diff < minDiff) {
                    //update minDiff and closest
                    minDiff = diff
                    closest = curSum
                }
            }
        }
        return closest
    }
}