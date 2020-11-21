package LeetCode_136

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/description/
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Example 1:
Input: [2,2,1]
Output: 1
 * */
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            //xor, 异或：相同为0，不同为1
            //则每对相同的数字都会得0，然后最后剩下来的数字就是那个只有1次的数字
            result = result xor num
        }
        return result
    }
}