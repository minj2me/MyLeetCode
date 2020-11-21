package LeetCode_905

/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/description/
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.

You may return any answer array that satisfies this condition.


Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * */

class Solution {
    fun sortArrayByParity(A: IntArray): IntArray {
        /*val result = A.sortedBy { it % 2 }.toIntArray()
        for (item in result) {
            println(item)
        }*/
        return A.sortedBy { it % 2 }.toIntArray()
    }
}