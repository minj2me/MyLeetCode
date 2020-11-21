package LeetCode_560

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
 * */
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var result = 0
        val n = nums.size
        //solution 1: O(n*n)
        /*for (i in 0 until n) {
            var num = nums[i]
            if (num == k) {
                result++
            }
            for (j in i + 1 until n) {
                num += nums[j]
                if (num == k) {
                    result++
                }
            }
        }*/

        //solution 2: prefixSum, Time Complexity: O(n), Space Complexity: O(n)
        val map = HashMap<Int, Int>()
        //key：prefixSum value
        //value：number of appeared of the prefixSum value
        //set 0 appeared 1 time
        map.put(0,1)
        var prefixSum = 0
        for (num in nums) {
            prefixSum += num
            result += map.getOrDefault(prefixSum - k, 0)
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1)
        }
        return result
    }
}