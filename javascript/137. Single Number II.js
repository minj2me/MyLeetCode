/**
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/description/
 * 
 * Given a non-empty array of integers, every element appears three times except for one,
 *  which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3

Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
    ////!!sort is not constant space complexity
    let fakeOne = -Math.pow(2, 31);//-2147483648
    if (nums == null)
        return fakeOne;
    nums.sort(function (a, b) { return a - b });
    //insert fake one at position one
    nums.unshift(fakeOne);
    for (let i = 0; i < nums.length; i++) {
        let prev = nums[i];
        let current = nums[i + 1];
        let next = nums[i + 2];
        if (current != prev && current != next)
            return current;
    }
    return fakeOne;
};

//Follow-up: Can you do this in linear time and constant space?