/**
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch/description/
 * 
 * The set S originally contains numbers from 1 to n. 
 * But unfortunately, due to the data error, one of the numbers in the set got duplicated
 *  to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. 
Your task is to firstly find the number occurs twice and then find the number that is missing. 
Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function (nums) {
    let index = 0;
    let res = [];
    nums.sort(function (a, b) { return a - b });
    for (let n of nums) {
      index = Math.abs(n);
      if (nums[index] > 0)
        nums[index] = -nums[index];
      else {
        res.push(index);
        break;
      }
    }
    for (let i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        res.push(Math.abs(nums[i] + 1));
        break;
      }
    }
    console.log(nums);
    return res;
};