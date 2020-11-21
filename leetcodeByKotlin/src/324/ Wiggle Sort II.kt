package LeetCode_324

/**
 * 324. Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 * */
class Solution {
    fun wiggleSort(nums: IntArray): Unit {
        /*
        https://www.jianshu.com/p/98ed84a8e219
        * 1. find mid by findKthLargest
        * 2. use sort color solution
        * */
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}