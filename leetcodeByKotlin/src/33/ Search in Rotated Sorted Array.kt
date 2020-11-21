package LeetCode_33

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 * */
class Solution {
    /*
    * solution 1: recursion
    * solution 2: binary search
    * */
    fun search(nums: IntArray, target: Int): Int {
        if (nums == null || nums.isEmpty()) {
            return -1
        }
        //solution 1
        //try to find the pivot point,then divide a array into two sub-arrays and call binary search
        //return searchHelp(nums, target, 0, nums.size - 1)

        //solution 2:
        var left = 0
        var right = nums.size - 1
        val first = nums[0]
        while (left <= right) {
            val mid = left + (right - left) / 2
            val value = nums[mid]
            if (value == target) {
                return mid
            }
            val imBig = value >= first
            val targetBig = target >= first
            /*
            * for example: 4,5,6,7,0,1,2, value=7, target=0, first=4,
            * */
            if (imBig == targetBig) {
                //searching in big number part: 4,5,6,7
                if (value < target) {
                    //search in right hand side, because we search target
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                //searching in small number part: 0,1,2, for example value=1, target=0,
                if (value < target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }
        return -1
    }

    private fun searchHelp(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) {
            return -1
        }
        val mid = (left + right) / 2
        if (nums[mid] == target) {
            return mid
        }
        //if num[left..mid] first subarray is sorted
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target <= nums[mid]) {
                return searchHelp(nums, target, left, mid - 1)
            }
            return searchHelp(nums, target, mid + 1, right)
        }
        //if num[left..mid] first subarray is not sorted, num[mid+1,right] must be sorted
        if (target >= nums[mid] && target <= nums[right]) {
            return searchHelp(nums, target, mid + 1, right)
        }
        return searchHelp(nums, target, left, mid - 1)
    }
}