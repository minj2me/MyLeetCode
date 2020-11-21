package LeetCode_1365

import java.util.*

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Example 1:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * */
class Solution {
    /*
    * solution: binary search, Time complexity:O(nlogn), Space complexity:O(n)
    * */
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val copy = Arrays.copyOf(nums,nums.size)
        copy.sort()
        for (i in nums.indices) {
            result[i] = binarySearch(copy,nums[i])
        }
        return result
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] < target) {
                //search in right side
                left = mid + 1
            } else {
                //search in left side
                right = mid - 1
            }
        }
        //return index
        return left
    }
}