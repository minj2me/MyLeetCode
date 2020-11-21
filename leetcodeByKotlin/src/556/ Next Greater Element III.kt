package LeetCode_556

/**
 * 556. Next Greater Element III
 * https://leetcode.com/problems/next-greater-element-iii/description/
 * Given a positive 32-bit integer n,
 * you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n.
 * If no such positive 32-bit integer exists, you need to return -1.

Example 1:
Input: 12
Output: 21

Example 2:
Input: 21
Output: -1
 * */
class Solution {
    /*
    * solution:
    * 1. find the first decreasing number A from right to left,
    * for example: [7, 2, 3, 1, 5, 4, 3, 2, 0] num 1 is the first decreasing index
    * 2. find out the number just large than A, and swap it,
    *
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun nextGreaterElement(n: Int): Int {
        val nums = n.toString().toCharArray()
        var index = nums.size - 2
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--
        }
        if (index < 0) {
            return -1
        }
        //find out the number just large than A
        var largeIndex = nums.size - 1
        while (largeIndex > 0 && nums[largeIndex] <= nums[index]) {
            largeIndex--
        }
        swap(nums, index, largeIndex)
        //reverse the number to the right
        reverse(nums, index + 1)
        val result = String(nums).toLong()
        return if (result > Int.MAX_VALUE) -1 else result.toInt()
    }

    private fun swap(nums: CharArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun reverse(nums: CharArray, start: Int) {
        var i = start
        var j = nums.size-1
        while (i < j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
}