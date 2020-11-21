/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/description/
 * https://www.cnblogs.com/grandyang/p/4359825.html
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 * 
 * 由于输入数组有可能出现重复数字，如果按照之前的算法运算，会有重复排列产生，我们要避免重复的产生，
 * 在递归函数中要判断前面一个数和当前的数是否相等，如果相等，前面的数必须已经使用了，即对应的visited中的值为1，当前的数字才能使用，否则需要跳过，
 * 这样就不会产生重复排列了
 */
var permuteUnique = function (nums) {
    let result = [];
    let visited = new Array(nums.length).fill(0);
    nums.sort(function (a, b) { return a - b });
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
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)
                continue;
            visited[i] = 1;
            out.push(nums[i]);
            help(nums, level + 1, out.concat(), result, visited);
            out.pop();
            visited[i] = 0;
        }
    }
};