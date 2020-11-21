package LeetCode_26

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
 * */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums==null || nums.isEmpty()){
            return 0
        }
        val n = nums.size
        val tempArray = IntArray(n)
        var j = 0
        for (i in 0 until n-1){
            if (nums[i]!=nums[i+1]){
                tempArray[j++] = nums[i]
            }
        }
        //add the last element, because it not save in loop for
        tempArray[j++] = nums[n-1]
        //modify original array
        for (i in 0 until j){
            nums[i] = tempArray[i]
        }
        //return new size of array
        return j
    }
}