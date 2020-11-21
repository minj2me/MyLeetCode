/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/description/
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
  nums.sort(function (a, b) { return a - b });
  let result = [];
  help(nums, 0, [], result);
  return result;
};
var help = function (nums, index, outArray, result) {
  result.push(outArray);
  for (let i = index; i < nums.length; i++) {
    //avoid duplicate
    if (i > index && nums[i] == nums[i - 1])
      continue;
    outArray.push(nums[i]);
    help(nums, i + 1, outArray.concat(), result);
    outArray.pop();
  }
};

