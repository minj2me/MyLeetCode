package LeetCode_34

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
 * */
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val res = IntArray(2)
        res[0] = -1
        res[1] = -1
        //find the value in the left
        var left = 0
        var right = nums.size - 1
        var mid = 0
        while (left <= right) {
            mid = left + (right - left) / 2
            if (nums[mid] >= target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        //find the value in the right
        var left2 = 0
        var right2 = nums.size - 1
        var mid2 = 0
        while (left2 <= right2) {
            mid2 = left2 + (right2 - left2) / 2
            if (nums[mid2] > target) {
                right2 = mid2 - 1
            } else {
                left2 = mid2 + 1
            }
        }
        if (left > right2) {
            //not found
            return res
        }
        res[0] = left
        res[1] = right2
        return res
    }

}