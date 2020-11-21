package LeetCode_189

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
Follow up:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * */
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        //avoid step large than n
        val step = k % n
        //reverse all
        reverse(nums, 0, n - 1)//=>7,6,5,4,3,2,1
        //reverse left part,
        reverse(nums, 0, step - 1)//=>5,6,7,4,3,2,1
        //reverse right part,
        reverse(nums, step, n - 1)//=>5,6,7,1,2,3,4
        //nums.forEach { print("$it,") }
    }

    private fun reverse(nums: IntArray, i_: Int, j_: Int) {
        var i = i_
        var j = j_
        while (i < j) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
    }
}