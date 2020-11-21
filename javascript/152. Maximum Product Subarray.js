/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * https://www.cnblogs.com/grandyang/p/4028713.html
 * 
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function (nums) {
    //使用累加积数组
    let res = nums[0], prod = 1, len = nums.length;
    for (let i = 0; i < len; i++) {
        res = Math.max(res, prod *= nums[i]);
        if (nums[i] == 0)
            prod = 1;
    }
    //console.log(res);
    prod = 1;
    //testcase will be this:[3,-1,4], so do below to check right from left
    for (let i = len - 1; i >= 0; i--) {
        res = Math.max(res, prod *= nums[i]);
        if (nums[i] == 0)
            prod = 1;
    }
    // console.log(res);
    return res;
};