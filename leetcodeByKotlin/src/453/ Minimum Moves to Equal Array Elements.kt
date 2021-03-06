package LeetCode_453

/**
 * 453. Minimum Moves to Equal Array Elements
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * https://www.cnblogs.com/grandyang/p/6053827.html
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * */
class Solution {
    fun minMoves(nums: IntArray): Int {
        var result = 0
        //find out the smallest one
        val min = nums.min()
        //accumulative the different between each num and the small one
        for (i in nums) {
            result += (i - min!!)
        }
        return result
    }
}