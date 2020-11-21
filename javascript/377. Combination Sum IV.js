/**
 * 377. Combination Sum IV
 * https://leetcode.com/problems/combination-sum-iv/description/
 * https://www.cnblogs.com/grandyang/p/5705750.html
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

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */

!!!need dp, otherwise Memory Limit Exceeded 

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function (nums, target) {
    let result = [];
    help(target, nums, [], result);
    return result.length;
};
var help = function (target, nums, out, result) {
    if (target < 0)
        return;
    else if (target == 0) {
        result.push(out);
    } else {
        for (let i = 0; i < nums.length; i++) {
            out.push(nums[i]);
            help(target - nums[i], nums, out.concat(), result);
            out.pop();
        }
    }
};