package LeetCode_259

/**
 * 259. 3Sum Smaller
 * (Prime)
 * Given an array of n integers nums and a target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
Example:
Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]
 * */
class Solution {
    /*
    * solution: sort array and two pointer, Time:O(n^2), Space:O(1)
    * */
    fun threeSumSmaller(nums: IntArray, target: Int): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }
        nums.sort()
        var result = 0
        val n = nums.size
        for (i in nums.indices) {
            var left = i + 1
            var right = n - 1
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    /*
                    * for example array is :1,2,.,..5; target:9, if 1,2,5 is valid triplets, because array is sorted,
                    * so the element at the left of 5(right pointer) and at the right of 2(left pointer) are all valid.
                    * */
                    result += right - left
                    left++
                } else {
                    right--
                }
            }
        }
        return result
    }
}