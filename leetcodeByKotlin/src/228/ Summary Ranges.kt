package LeetCode_228

/**
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/description/
 * Given a sorted integer array without duplicates, return the summary of its ranges.
Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * */
class Solution {
    /*
    * solution: scan from left to right and check two number if continuous
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun summaryRanges(nums: IntArray): List<String> {
        val result = ArrayList<String>()
        var i = 0
        while (i < nums.size) {
            val num = nums[i]
            //if two number is continuous, index++
            while (i < nums.size - 1 && nums[i] + 1 == nums[i + 1]) {
                i++
            }
            if (num != nums[i]) {
                result.add("$num->${nums[i]}")
            } else {
                result.add("$num")
            }
            i++
        }
        return result
    }
}