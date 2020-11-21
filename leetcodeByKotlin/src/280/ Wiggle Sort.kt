package LeetCode_280

/**
 * 280. Wiggle Sort
 * (locked by leetcode)
 * https://www.lintcode.com/problem/wiggle-sort/description
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:
Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]

Please complete the problem in-place.
 * */
class Solution {
    fun wiggleSort(nums: IntArray) {
        for (i in 1 until nums.size) {
            //follow by this situation: nums[0] <= nums[1] >= nums[2] <= nums[3]
            //so if i is even and and nums[i] > nums[i-1], swap this two num and
            //if if i is odd and nums[i] < nums[i-1], swap this two num also
            if (i % 2 == 0 && nums[i] > nums[i - 1] || i % 2 != 0 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1)
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}