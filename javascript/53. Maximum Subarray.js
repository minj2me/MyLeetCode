/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    let curSum = 0, max = -2147483647;
    for (let i = 0; i < nums.length; i++) {
        curSum += nums[i];
        curSum = Math.max(curSum, nums[i]);
        max = Math.max(max, curSum);
    }
    // console.log(max);
    return max;
};