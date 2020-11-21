/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/description/
 * https://www.cnblogs.com/grandyang/p/4332522.html
 * https://blog.csdn.net/u010500263/article/details/18435495
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
  let result = [];
  helper(n, k, 1, [], result);
  return result;
};

var helper = function (n, k, level, out, result) {
  //console.log(out);
  if (out.length == k) {
    result.push(out);
    return;
  }
  //console.log("n:"+n);
  for (let i = level; i <= n; i++) {
    out.push(i);
    //out.concat mains pass array copy to it
    helper(n, k, i + 1, out.concat(), result);
    out.pop();
  }
};