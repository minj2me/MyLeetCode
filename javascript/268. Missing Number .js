/**
 * 268. Missing Number
https://leetcode.com/problems/missing-number/description/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2

Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function (nums) {
    nums.sort(function (a, b) { return a - b });
    let i = 0;
    for (; i < nums.length; i++) {
        if (nums[i] != i)
            return i;
    }
    return i;

    //用二分法try
    // let left=0,right=nums.length;
    // while (left<right){
    //     let mid = parseInt((right-left)/2);
    //     if (nums[mid]>mid)
    //         right=mid;
    //     else
    //         left=mid+1;
    // }
    // return right;
};