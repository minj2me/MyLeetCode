/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @param {number[]} nums
 * @return {number[][]}
 */

//just practice for dp
// var subsetsCount = function (nums) {
//     if (nums == "")
//         return 0;
//     let dp = [];
//     dp[0] = 1;
//     dp[1] = 3;
//     for (let i = 2; i <= nums.length; i++) {
//         dp[i] = (dp[i] == undefined ? 0 : dp[i]) + dp[i - 1] + dp[i - 2];
//     }
//     console.log(dp[nums.length]);
//     console.log(dp);
//     return dp[nums.length];
// };

//subsetsCount([1,2,3]);

var subsets = function (nums) {
    //runtime 64 ms
    let result = [];
    if (nums == "")
        return result;
    let arr = [];
    nums.sort(function (a, b) { return a - b });
    subsetsDFS(result, arr, nums, 0);
    //console.log(result);
    return result;
};

var subsetsDFS = function (result, arr, nums, index) {
    result.push(arr);
    for (let i = index; i < nums.length; i++) {
        arr.push(nums[i]);
        //console.log(arr);
        subsetsDFS(result, arr.concat(), nums, i + 1);
        arr.pop();
        //arr=[];
    }
}

// var subsetsHelp = new function (nums) {
//     let arr_ = [];//改变引用
//     for (let i = 0; i < arr.length; i++)
//         arr_.push(arr[i]);
//     result.push(arr_);
//     //console.log(result);
//     console.log("index:" + index);
//     for (let i = index; i < nums.length; i++) {
//         console.log("arr.push(nums[" + i + "])");
//         arr.push(nums[i]);
//         console.log(arr);
//         subsetsDFS(result, arr, nums, i + 1);
//         arr.pop();
//         console.log("backtracking");
//     }
//     console.log("out of for");
// }
