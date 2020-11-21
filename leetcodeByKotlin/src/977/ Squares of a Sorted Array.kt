package LeetCode_977

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
 * also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
 * */
class Solution {
    fun sortedSquares(A: IntArray): IntArray {
        val result = A.map { num -> num * num }.toIntArray()
        result.sort()
        return result
    }
}