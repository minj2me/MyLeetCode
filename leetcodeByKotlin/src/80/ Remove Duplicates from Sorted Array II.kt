package LeetCode_80

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,1,2,2,3],
Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It doesn't matter what you leave beyond the returned length.
 * */
class Solution {
    /*
    solution: for loop to check i and each two number, Time complexity:O(n), Space complexity:O(1)
    * */
    fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        for (num in nums) {
            //if current num large than prev two numbers, mean current number is new one after two duplicates
            if (index < 2 || num > nums[index - 2]){
                nums[index++] = num
            }
        }
        return index
    }
}