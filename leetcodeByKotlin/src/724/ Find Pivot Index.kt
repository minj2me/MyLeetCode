package LeetCode_724

/**
 * 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/description/
 *
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
We define the pivot index as the index where the sum of all the numbers to the left of the index is
equal to the sum of all the numbers to the right of the index.
If no such index exists, we should return -1.
If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
 * */
class Solution {
    /*
    * solution: prefix sum and suffix sum, then found out the meeting point,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun pivotIndex(nums: IntArray): Int {
        val n = nums.size
        val prefixs = IntArray(n)
        val suffixs = IntArray(n)

        var prefixSum = 0
        for (i in 0 until n) {
            prefixSum += nums[i]
            prefixs[i] = prefixSum
        }

        var suffixSum = 0
        for (i in n - 1 downTo 0) {
            suffixSum += nums[i]
            suffixs[i] = suffixSum
        }
        for (i in 0 until n) {
            if (prefixs[i] == suffixs[i]) {
                return i
            }
        }
        return -1
    }
}