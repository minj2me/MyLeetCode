package LeetCode_448

/**
 * 448. Find All Numbers Disappeared in an Array
 *https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime?
You may assume the returned list does not count as extra space.

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]
 * */
class Solution {
    /*
    * solution: match up index in the array to find out he miss one
    * */
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (num in nums) {
            val index = Math.abs(num) - 1
            if (nums[index] > 0) {
                nums[index] *= -1
            }
        }
        //after above, fro example:[2,5,3,1,1]=>[-2,-5,-3,1,-1]
        val result = ArrayList<Int>()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                result.add(i + 1)
            }
        }
        return result
    }
}