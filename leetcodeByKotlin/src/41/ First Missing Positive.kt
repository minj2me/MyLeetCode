package LeetCode_41

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/description/
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Follow up:
Your algorithm should run in O(n) time and uses constant extra space.
 * */
class Solution {
    /*
    * solution 1: use array to record appearance number, then find out the missing one,
    * Time complexity:O(n), Space complexity:O(n);
    * */
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        val hasNumbers = BooleanArray(n+1)
        for (num in nums) {
            if (num <= 0 || num >= hasNumbers.size) {
                continue
            }
            hasNumbers[num] = true
        }
        //because smallest positive integer is from 1
        for (i in 1 until hasNumbers.size) {
            if (!hasNumbers[i]) {
                return i
            }
        }
        return hasNumbers.size
    }
}