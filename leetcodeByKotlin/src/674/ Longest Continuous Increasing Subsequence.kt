package LeetCode_674

/**
 * 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 * https://www.youtube.com/watch?v=jSvoE-_Yhs4
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * */
class Solution {
    /*
    * solution: two pointer, Time:O(n), Space:O(1)
    * */
    fun findLengthOfLCIS(nums: IntArray): Int {
        var max = 0
        var right = 0
        //because will handle the array size is 1, so i cannot begin with 1
        for (i in nums.indices) {
            //if not increasing, update the right pointer
            if (i > 0 && nums[i - 1] >= nums[i]) {
                right = i
            }
            max = Math.max(max, i - right + 1)
        }
        return max
    }
}