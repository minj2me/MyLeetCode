package LeetCode_209

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
Example:
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

其实看到让连续子数组满足一定条件的很多都用了双指针

 * */
class Solution {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        val N = nums.size
        if (N == 0) {
            return 0
        }
        var sum = 0
        var minLen = Int.MAX_VALUE
        var left = 0
        for (i in 0 until N) {
            sum += nums[i]//prefix sum
            while (sum >= s) {
                minLen = Math.min(minLen, i - left + 1)
                sum -= nums[left]
                left++
            }
        }
        return if (minLen == Int.MAX_VALUE) 0 else minLen
    }
}