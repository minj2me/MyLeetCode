/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 * 
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  let result = [];
  let visited = new Array(nums.length).fill(0);
  help(nums, 0, [], result, visited);
  //console.log(result);
  return result;
};
var help = function (nums, level, out, result, visited) {
  if (level == nums.length) {
    result.push(out);
    return;
  }
  for (let i = 0; i < nums.length; i++) {
    if (visited[i] == 0) {
      visited[i] = 1;
      out.push(nums[i]);
      help(nums, level + 1, out.concat(), result, visited);
      out.pop();
      visited[i] = 0;
    }
  }
};