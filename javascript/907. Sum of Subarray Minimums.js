/**
 * 907. Sum of Subarray Minimums
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 * 
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.


Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 */
/**
 * @param {number[]} A
 * @return {number}
 */
var sumSubarrayMins = function(A) {
    if (A=="")
        return 0;
    A.sort(function(a,b){return b-a});
    let result=[],arr=[];
    dfs(result,arr,A,0);
    console.log(result);
};

var dfs = function(result,arr,A,index){
    result.push(arr);
    for (let i=index;i<A.length;i++){
        arr.push(A[i]);
        dfs(result,arr.concat(),A,index+1);
        arr.pop();
    }
}
