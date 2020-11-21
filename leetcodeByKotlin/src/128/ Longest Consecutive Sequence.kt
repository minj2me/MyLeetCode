package LeetCode_128

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * */
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (item in nums) {
            set.add(item)
        }
        var res = 0
        for (num_ in nums) {
            var num = num_
            //find out the lower bound
            var left = 0
            //if left one of current num not exist, scan in set to find out the upper bound
            if (!set.contains(num - 1)) {
                while (set.contains(num++)) {
                    left++
                }
                res = Math.max(res, left)
            }
        }
        return res
    }
}