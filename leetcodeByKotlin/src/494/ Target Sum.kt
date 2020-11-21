package LeetCode_494

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 * */
class Solution {
    /*
    * solution 1: dfs, Time complexity:O(2^n), Space complexity:O(n)
    * */

    private var result = 0

    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        dfs(0, nums, S)
        return result
    }

    private fun dfs(start: Int, nums: IntArray, target: Int) {
        //println(target)
        if (start == nums.size) {
            if (target == 0) {
                result++
            }
            return
        }
        //mean choice -1 or +1
        dfs(start + 1, nums, target - nums[start])
        dfs(start + 1, nums, target + nums[start])
    }
}