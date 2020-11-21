package LeetCode_334

/**
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:
Input: [1,2,3,4,5]
Output: true

Example 2:
Input: [5,4,3,2,1]
Output: false
 * */
class Solution {
    /*
    * solution: Greedy, keep tracking min1 and min2;
    * Time complexity:O(n), Space complexity:O(1);
    * */
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }
        //the smallest one
        var min1 = Int.MAX_VALUE
        //the second smallest
        var min2 = Int.MAX_VALUE
        for (num in nums) {
            if (num > min2) {
                return true
            } else if (num < min1) {
                min1 = num
            } else if (num > min1 && num < min2) {
                min2 = num
            }
        }
        return false
    }
}