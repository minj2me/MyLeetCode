package LeetCode_628

/**
 * 628. Maximum Product of Three Numbers
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
Example 1:
Input: [1,2,3]
Output: 6
 * */
class Solution {
    /*
    * solution: Sort, Time complexity:O(nlogn), Space complexity:O(1)
    * */
    fun maximumProduct(nums: IntArray): Int {
        nums.sort()
        //if first and two is negative, and the last one is biggest
        val num1 = nums[0] * nums[1] * nums[nums.size - 1]
        val num2 = nums[nums.size - 1] * nums[nums.size - 2] * nums[nums.size - 3]
        //compare two situation's number
        return Math.max(num1, num2)
    }
}