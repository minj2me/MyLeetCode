/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 * https://www.cnblogs.com/grandyang/p/4419386.html
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function (candidates, target) {
  let result = [];
  candidates.sort(function (a, b) { return a - b })
  helper(candidates, target, 0, [], result);
  return result;
};

var helper = function (candidates, target, start, out, result) {
  // console.log("start:" + start);
  // console.log("target:" + target);
  // console.log("out:" + out);
  if (target < 0)
    return;
  else if (target == 0)
    result.push(out);
  else {
    for (let i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1])//防止重复添加
        continue;
      out.push(candidates[i]);
      helper(candidates, target - candidates[i], i + 1, out.concat(), result);
      out.pop();
    }
  }
};