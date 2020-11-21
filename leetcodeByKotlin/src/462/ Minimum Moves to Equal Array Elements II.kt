package LeetCode_462

/**
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * https://www.cnblogs.com/grandyang/p/6089060.html
 *
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * */
class Solution {
    fun minMoves2(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var result = 0
        while (l < r) {
            result += nums[r] - nums[l]
            l++
            r--
        }
        return result
    }
}