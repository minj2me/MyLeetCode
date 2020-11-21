package LeetCode_540

/**
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * Find this single element that appears only once.
 *
Follow up: Your solution should run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1. 1 <= nums.length <= 10^5
2. 0 <= nums[i] <= 10^5
 * */
class Solution {
    /*
    * solution 1: xor, two same num xor return 0, otherwise return 1,
    *   Time complexity:O(n), Space complexity:O(1)
    * solution 2: binary search, we found the index of single number is even,
    *   Time complexity:O(logn), Space complexity:O(1)
    * */
    fun singleNonDuplicate(nums: IntArray): Int {
        //solution 1
        /*
        var result = 0
        for (num in nums){
            result = result xor num
        }
        return result
        */

        //solution 2
        val n = nums.size
        var left = 0
        var right = n - 1
        while (left < right) {
            //we check the index of pair, if m is even, so n is odd
            //for example: [1,1,2]: we should check index 0,1; [10,11,11]: we should check index 1,2
            val m = left + (right - left) / 2
            val n = if (m % 2 == 0) m + 1 else m - 1
            if (nums[m] == nums[n]) {
                //for example:[3,3,7,7,10,11,11]
                //search in right side
                left = m + 1
            } else {
                right = m
            }
        }
        return nums[left]
    }
}