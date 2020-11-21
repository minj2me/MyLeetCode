/**
 * 673. Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 * https://www.cnblogs.com/grandyang/p/7603903.html
 * 
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumberOfLIS = function (nums) {
    /*let len = nums.length;
    let max = 0, res = 0;
    let longestLen = new Array(len);
    let longestCount = new Array(len);
    //1,3,5,4,7
    for (let i = 0; i < len; i++) {
        longestLen[i] = 1;
        longestCount[i] = 1;
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                if (longestLen[j] + 1 > longestLen[i]) {
                    longestLen[i] = longestLen[j] + 1;
                    longestCount[i] = longestCount[j];
                } else if (longestLen[j] + 1 == longestLen[i]) {
                    longestCount[i] += longestCount[j];
                }
            }
        }
        // console.log(longestLen)
        // console.log(longestCount)
        if (longestLen[i] > max) {
            max = longestLen[i];
            res = longestCount[i];
        } else if (max == longestLen[i]) {
            res += longestCount[i];
        }
    }
    return res;
    */
    let len = nums.length;
    let maxLen = 1;
    let dp = new Array(len).fill(1);
    let ct = new Array(len).fill(1);
    for (let i = 1; i < len; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1
                    ct[i] = ct[j];
                } else if (dp[i] == dp[j] + 1) {
                    ct[i] += ct[j];
                }
            }
        }
        maxLen = Math.max(maxLen, dp[i]);
    }
    //console.log(dp);
    let res = 0;
    for (let i = 0; i < ct.length; i++) {
        if (dp[i] == maxLen)
            res += ct[i];
    }
    return res;
};