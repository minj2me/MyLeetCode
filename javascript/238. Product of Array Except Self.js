/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * [数] 乘积
 * 
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? 
(The output array does not count as extra space for the purpose of space complexity analysis.)

这道题给定我们一个数组，让我们返回一个新数组，对于每一个位置上的数是其他位置上数的乘积，并且限定了时间复杂度O(n)，并且不让我们用除法。
如果让用除法的话，那这道题就应该属于Easy，因为可以先遍历一遍数组求出所有数字之积，然后除以对应位置的上的数字。但
是这道题禁止我们使用除法，那么我们只能另辟蹊径。
我们想，对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，那么二者相乘就是我们要的结果，
所以我们只要分别创建出这两个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积累积数组
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
    let len = nums.length;
    let t1 = new Array(len), t2 = new Array(len), result = new Array(len);
    t1[0] = 1;
    t2[len - 1] = 1;
    //scan left to right
    for (let i = 0; i < len - 1; i++) {
        t1[i + 1] = t1[i] * nums[i];
    }
    //scan right to left
    for (let i = len - 1; i > 0; i--) {
        t2[i - 1] = t2[i] * nums[i];
    }
    for (let i = 0; i < len; i++) {
        result[i] = t1[i] * t2[i];
    }
    console.log(t1);
    console.log(t2);
    console.log(result);
    return result;
};