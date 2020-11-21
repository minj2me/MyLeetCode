/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/description/
 * 
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:

Input: [4,1,2,1,2]
Output: 4

http://www.cnblogs.com/grandyang/p/4130577.html

由于数字在计算机是以二进制存储的，每位上都是0或1，如果我们把两个相同的数字异或，如2与2异或是0，0与2异或是2
0与0异或是0,1与1异或也是0，那么我们会得到0。根据这个特点，我们把数组中所有的数字都异或起来，
则每对相同的数字都会得0，
然后最后剩下来的数字就是那个只有1次的数字。
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    var res = 0;
    for (var i = 0; i < nums.length; i++) {
      res = res ^ nums[i];
    }
    return res;
};