package LeetCode_1640

import java.util.*

/**
 * 1640. Check Array Formation Through Concatenation
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 *
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct.
 * Your goal is to form arr by concatenating the arrays in pieces in any order.
 * However, you are not allowed to reorder the integers in each array pieces[i].
Return true if it is possible to form the array arr from pieces. Otherwise, return false.

Example 1:
Input: arr = [85], pieces = [[85]]
Output: true

Example 2:
Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
 * */
class Solution {
    /*
    * solution: check every item in pieces if sublist of arr,
    * m = arr.size
    * n = pieces.size
    * Time complexity: O(n*(m-max(pieces[i]))*max(pieces[i])), Space complexity: O(1)
    * */
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val list = arr.toList()
        for (item in pieces) {
            val index = Collections.indexOfSubList(list, item.toList())
            if (index == -1) {
                return false
            }
        }
        return true
    }
}