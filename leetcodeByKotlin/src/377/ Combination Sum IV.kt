package LeetCode_377

/**
 * 377. Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations. Therefore the output is 7.

Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 * */
class Solution {
    private var result = 0
    private var array: Array<Int>? = null

    fun combinationSum4(nums: IntArray, target: Int): Int {
        //1. recursion
        //help(nums, target)

        //2. recursion + memorization
        /*array = Array(target + 1, { -1 })
        array?.set(0, 1)
        return help2(nums, target)*/

        //3. dp
        return dp(nums, target)
    }

    /*
    * method 1: recursion
    * Time complexity: O(2^target), Space complexity: O(n);
    * TLE, 11/17 test cases passed
    * */
    private fun help(nums: IntArray, target: Int) {
        if (target == 0) {
            result += 1
        }
        if (target < 0) {
            return
        }
        for (num in nums) {
            help(nums, target - num)
        }
    }

    /*
    * method 2: recursion + memorization
    * Time complexity: O(sum({target/num_i})), Space complexity: O(target)
    * */
    private fun help2(nums: IntArray, target: Int): Int {
        if (target < 0) {
            return 0
        }
        if (array!![target] != -1) {
            return array!![target]
        }
        var res = 0
        for (num in nums) {
            res += help2(nums, target - num)
        }
        array!![target] = res
        return res
    }

    /*
    * method 3:dp
    * Time complexity: O(target * n), Space complexity: O(target)
    * */
    private fun dp(nums: IntArray, target: Int): Int {
        //dp[i] represent number of combinations sum up to i
        val dp = Array(target + 1, { 0 })
        dp[0] = 1//there are is 1 combination sum up to 0
        for (i in 1..target) {
            for (num in nums) {
                //just like fibonacci sequence
                if (i - num >= 0) {
                    dp[i] += dp[i - num]
                }
            }
        }
        for (item in dp){
            println(item)
        }
        return dp[target]
    }
}