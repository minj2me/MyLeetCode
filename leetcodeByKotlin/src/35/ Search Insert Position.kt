package LeetCode_35

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 * */
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        //method 1
        /*for (i in 0 until nums.size) {
            if (nums[i] == target || nums[i] > target) {
                return i
            }
        }
        return nums.size*/

        //method 2: binary search
        if (target < nums[0]) {
            return 0
        }
        if (target > nums[nums.size - 1]) {
            return nums.size
        }
        val pos = binarySearch(nums, target)
        if (nums[pos] == target) {
            return pos
        } else {
            //if not found, return the position where it will get insert
            return pos + 1
        }
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var pos = 0
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) shr 1//shr 1 == /2
            if (nums[mid] <= target) {
                pos = mid
                left = mid + 1
            } else {
                right = mid - 1
            }

        }
        return pos
    }
}