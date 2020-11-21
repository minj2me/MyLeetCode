/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
 * For each integer, you should choose one from + and - as its new symbol.

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
 */
/**
 * @param {number[]} nums
 * @param {number} S
 * @return {number}
 */
var findTargetSumWays = function (nums, S) {
    let result = new Array(1).fill(0);
    help(nums, 0, S, result);
    return result[0];
};
var help = function (nums, start, S, result) {
    if (start >= nums.length) {
        if (S == 0)
            result[0] += 1;
        return;
    }
    help(nums, start + 1, S - nums[start], result);
    help(nums, start + 1, S + nums[start], result);
}