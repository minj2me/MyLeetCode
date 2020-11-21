package LeetCode_493

import java.util.*

/**
 * 493. Reverse Pairs
 * https://leetcode.com/problems/reverse-pairs/
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
You need to return the number of important reverse pairs in the given array.

Example1:
Input: [1,3,2,3,1]
Output: 2

Example2:
Input: [2,4,3,5,1]
Output: 3

Note:
1. The length of the given array will not exceed 50,000.
2. All the numbers in the input array are in the range of 32-bit integer.
 * */
class Solution {
    /*
    * solution 1: like merge sort, split array into two sub-array, and check left side if meet the condition,
    * Time complexity:O(nlogn), Space complexity:O(n)
    * */
    var result = 0

    fun reversePairs(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }
        mergeSort(nums, 0, nums.size - 1)
        return result
    }

    private fun mergeSort(nums: IntArray, left: Int, right: Int) {
        if (left < right) {
            val mid = left + (right - left) / 2
            mergeSort(nums, left, mid)
            mergeSort(nums, mid + 1, right)
            merge(nums, left, mid, right)
        }
    }

    private fun merge(nums: IntArray, left: Int, mid: Int, right: Int) {
        var i = left
        var j = mid + 1
        while (i <= mid && j <= right) {
            if (nums[i].toLong() <= 2 * nums[j].toLong()) {
                i++
            } else {
                //because array is sorted, so the index in left was meet the condition,
                //so other index in right of current index are meet the condition as well
                /*
                for example:
                left: 1,3,5,7 | right: 2,4,6,8
                (3,2),(5,2),(7,2) are Reverse Pairs
                */
                result += mid - i + 1
                j++
            }
        }
        //sort current range
        Arrays.sort(nums, left, right + 1)
    }
}