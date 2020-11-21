package LeetCode_153

/**
 * 153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Return the minimum element of this array.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1. 1 <= nums.length <= 5000
2. -5000 <= nums[i] <= 5000
3. All the integers of nums are unique.
4. nums is sorted and rotated at some pivot
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
        //is sorted
        if (nums[left] <= nums[right]) {
            return nums[left]
        }
        //compare left and right side
        val mid = left + (right - left) / 2
        val leftSide = findMin(nums, left, mid)
        val rightSide = findMin(nums, mid+1, right)
        return Math.min(leftSide, rightSide)
    }
}