package LeetCode_45

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:
You can assume that you can always reach the last index.
 * */
class Solution {
    //try greedy
    fun jump(nums: IntArray): Int {
        val size = nums.size
        var result = 0
        var lastCover = 0//last how far can reach
        var currentCover = 0//current how far can reach
        for (i in 0 until size) {
            if (lastCover < i) {
                lastCover = currentCover
                result++
            }
            if (lastCover >= size - 1) {
                return result
            }
            //i+nums[i] represent the maximum distance that current i can reach
            currentCover = Math.max(currentCover, i + nums[i])
        }
        return result
    }
}