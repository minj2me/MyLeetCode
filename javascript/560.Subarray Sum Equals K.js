/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * 
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function (nums, k) {
    //304ms
    //time complexcity: O(n*n), space: O(1)
    let len = 0;
    for (let i = 0; i < nums.length; i++) {
        let num = nums[i];
        if (num==k)//equals also is subarray
            len++;
        for (let j = i + 1; j < nums.length; j++) {
            num += nums[j];
            if (num == k)
                len++;
        }
    }
    return len;
};