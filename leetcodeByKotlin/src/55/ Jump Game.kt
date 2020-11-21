package LeetCode_55

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 * */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        //method 1
        /*var lastGoodIndexPostion = nums.size - 1
        for (i in nums.size - 1 downTo 0) {
            //i+nums[i] represent the maximum distance that current i can reach
            if (i + nums[i] >= lastGoodIndexPostion) {
                lastGoodIndexPostion = i
            }
        }
        return lastGoodIndexPostion == 0*/

        //method 2
        var currentCover = 0
        for (i in nums.indices) {
            if (i > currentCover) {
                return false
            }
            //i+nums[i] represent the maximum distance that current i can reach
            currentCover = Math.max(currentCover, i + nums[i])
        }
        return true
    }
}