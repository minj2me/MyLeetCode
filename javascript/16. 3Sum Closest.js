/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/description/
 * https://www.cnblogs.com/Dylan-Java-NYC/p/4825050.html
 * 
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
    let diff = Math.pow(2, 31);//largest value
    let sum = 0;
    nums.sort(function (a, b) { return a - b });
    for (let i = 0; i < nums.length; i++) {
        let left = i + 1;
        let right = nums.length - 1;
        while (left < right) {
            let newDiff = Math.abs(nums[i] + nums[left] + nums[right] - target);
            if (diff > newDiff) {
                diff = newDiff;
                sum = nums[i] + nums[left] + nums[right];
            }
            if ((nums[i] + nums[left] + nums[right]) < target)
                left++;
            else if ((nums[i] + nums[left] + nums[right]) > target)
                right--;
            else
                return sum;
        }
    }
    //console.log(sum);
    return sum;
};