package LeetCode_81

/**
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

[1,3,1,1,1]
3
true

Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
 * */
class Solution {
    /*
    * solution: Binary Search, Time:O(logn), Space:O(1)
    * */
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) {
                return true
            }
            //if num[left..mid] first subarray is sorted
            /*
         * for example: 2,5,6,0,0,1,2, nums[left]=2, nums[mid]=0, so right hand side is sorted, we search in this area,
         * otherwise search in left hand side
         * */
            if (nums[left] < nums[mid]) {
                //if target=0, nums[left]=2, nums[mid]=0,
                if (nums[left] <= target && target <= nums[mid]) {
                    //search in left side
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                /*
                * we keep moving the left pointer, avoid the duplicate issue,
                * for example: 1,3,1,1,1
                * */
                left++
            }
        }
        return false
    }
}