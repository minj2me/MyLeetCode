package LeetCode_421

/**
 * 421. Maximum XOR of Two Numbers in an Array
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
Follow up: Could you do this in O(n) runtime?

Example 1:
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.

Example 2:
Input: nums = [0]
Output: 0

Constraints:
1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1
 * */
class Solution {
    /*
    * solution 1: bruce force, Time complexity: O(n^2), Space complexity:O(1)
    * */
    fun findMaximumXOR(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in nums.indices) {
            for (j in i until nums.size) {
                max = Math.max(nums[i] xor nums[j], max)
            }
        }
        return max
    }
}