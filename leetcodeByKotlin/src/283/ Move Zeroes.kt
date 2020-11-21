package LeetCode_283

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * Given an array nums,
 * write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * */
class Solution {
    /*
    * solution: loop to check the element if 0 or not and use index to reset the position of element in array,
    * Time:O(n), Space:O(1)
    * */
    //algorithm 1: move zero to the end
    fun moveZeroes(nums: IntArray): Unit {
        var index = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[index++] = nums[i]
            }
        }
        for (i in index until nums.size) {
            nums[i] = 0
        }
    }

    //algorithm 2: move zero to the front
    fun moveZeroesToFront(nums: IntArray): Unit {
        val n = nums.size - 1
        var index = nums.size - 1
        for (i in n downTo 0) {
            if (nums[i] != 0) {
                nums[index--] = nums[i]
            }
        }
        for (i in index downTo 0) {
            nums[i] = 0
        }
    }
}