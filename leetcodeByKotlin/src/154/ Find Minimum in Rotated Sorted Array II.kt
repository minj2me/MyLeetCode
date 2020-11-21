package LeetCode_154

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.

Example 1:
Input: [1,3,5]
Output: 1

Example 2:
Input: [2,2,2,0,1]
Output: 0

Note:
1. This is a follow up problem to Find Minimum in Rotated Sorted Array.
2. Would allow duplicates affect the run-time complexity? How and why?
 * */
class Solution {
    /*
   * solution: Divide and conquer, check left side and right side of array,
   * Time complexity: O(logn), because at least half of array is sorted,
   * Space complexity: O(logn), there are logn levels recursion,
   * */
    fun findMin(nums: IntArray): Int {
        return findMin(nums, 0, nums.size - 1)
    }

    private fun findMin(nums: IntArray, left: Int, right: Int): Int {
        //if just one or two elements
        if (left == right) {
            return nums[left]
        }
        //is sorted, because array contains duplicate, so cannot check if equals
        if (nums[left] < nums[right]) {
            return nums[left]
        }
        //compare left and right side
        val mid = left + (right - left) / 2
        val leftSide = findMin(nums, left, mid)
        val rightSide = findMin(nums, mid + 1, right)
        return Math.min(leftSide, rightSide)
    }
}