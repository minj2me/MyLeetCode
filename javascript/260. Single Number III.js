/**
 * 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/description/
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function (nums) {
    //!!sort is not constant space complexity
    if (nums == null)
        return [];
    let res = [];
    nums.sort(function (a, b) { return a - b });
    //insert fake one at position one
    nums.unshift(-Math.pow(2, 31));
    //console.log(nums);
    for (let i = 0; i < nums.length; i++) {
        let prev = nums[i];
        let current = nums[i + 1];
        let next = nums[i + 2];
        if (current != prev && current != next)
            res.push(current);
    }
    //console.log(res);
    return res;
};
//Follow-up: Can you do this in linear time and constant space?