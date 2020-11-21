/**
 * 718. Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 * 
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var findLength = function (A, B) {
    let ALen = A.length, BLen = B.length;
    //init array[][]
    let dp = new Array();
    for (let l = 0; l < ALen + 1; l++) {
        let arr = new Array();
        for (let b = 0; b < BLen + 1; b++) {
            arr.push(0);
        }
        dp[l] = arr;
    }
    let result = 0;
    for (let i = 1; i < dp.length; i++) {
        for (let j = 1; j < dp[i].length; j++) {
            dp[i][j] = (A[i - 1] == B[j - 1]) ? dp[i - 1][j - 1] + 1 : 0;
            result = Math.max(dp[i][j], result);
        }
    }
    console.log(dp);
    console.log(result);
    return result;
};