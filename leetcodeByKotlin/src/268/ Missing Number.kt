package LeetCode_268

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/description/
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
Example 1:
Input: [3,0,1]
Output: 2
 * */
class Solution {
    fun missingNumber(nums: IntArray): Int {
        /*
        * solution 1:sum
        * */
        /*val n = nums.size
        //the sum of 0-size
        val sum = (0 + n) * (n + 1) / 2
        return sum - nums.sum()*/

        //solution 2: xor
        //我们将这个少了一个数的数组合0到n之间完整的数组异或一下，那么相同的数字都变为0了，剩下的就是少了的那个数字了
        var x = 0
        for (i in nums.indices) {
            x = x xor (i + 1) xor nums[i]
        }
        return x
    }
}