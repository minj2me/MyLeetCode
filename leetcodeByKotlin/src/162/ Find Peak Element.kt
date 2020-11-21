package LeetCode_162

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
or index number 5 where the peak element is 6.

Follow up: Your solution should be in logarithmic complexity.
 * */
class Solution {
    /*
    * solution 1: new array, Time complexity:O(n), Space complexity:O(n)
    * solution 2: binary search, Time complexity:O(logn), Space complexity:O(1)
    * */
    fun findPeakElement(nums: IntArray): Int {
        //solution 1
        //because may imagine that nums[-1] = nums[n] = -∞, so put -∞ at head and tail
        val newArray = IntArray(nums.size + 2)
        //srcPos = 0, destPost=1, mean insert nums into newArray from pos 0 and end of pos 1
        //if nums is: 1,2,3,1, so newArray now is: 0,1,2,3,1,0,
        System.arraycopy(nums, 0, newArray, 1, nums.size)
        //newArray.forEach{ print("$it,")}
        // put -∞ at head and tail of array
        newArray.set(0, Int.MIN_VALUE)
        newArray.set(newArray.size - 1, Int.MIN_VALUE)
        for (i in 1 until newArray.size - 1) {
            //if num greater than its neighbors, return it's index
            if (newArray[i] > newArray[i - 1] && newArray[i] > newArray[i + 1]) {
                return i
            }
        }

        //solution 2:
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            //keep check if mid is valid bound and if nums[mid] greater than its neighbors
            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 >= nums.size || nums[mid] > nums[mid + 1])) {
                return mid
            } else if (nums[mid] < nums[mid + 1]) {
                //the large one in right side, fo find in right side
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return 0
    }
}