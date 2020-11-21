/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * https://www.cnblogs.com/grandyang/p/4383632.html
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    let len = nums.length;
    let num1 = 0, num2 = 0, max = 0;
    for (let i = 0; i < len; i++) {
        if (i % 2 == 0)
            num1 = Math.max(num1 += nums[i], num2);
        if (i % 2 != 0)
            num2 = Math.max(num2 += nums[i], num1);
        //num2 += nums[i];
    }
    max = Math.max(num1, num2);
    console.log(max);
    return max;
};