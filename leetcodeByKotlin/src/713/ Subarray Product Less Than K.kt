package LeetCode_713

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/description/
 *
 * Your are given an array of positive integers nums.
Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * */
class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var product = 1
        var result = 0
        var left = 0
        for (i in 0 until nums.size) {
            product *= nums[i]
            //also need check left ,for example case:[1,2,3] and k:0, it wont jump out from for loop
            while (product >= k && left <= i) {
                product /= nums[left]
                left++
            }
            result += i - left + 1
        }
        return result
    }
}