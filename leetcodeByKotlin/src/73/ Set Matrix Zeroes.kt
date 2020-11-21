package LeetCode_73

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
Example 1:
Input:
[
[1,1,1],
[1,0,1],
[1,1,1]
]
Output:
[
[1,0,1],
[0,0,0],
[1,0,1]
]
 * */
class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        //method 1: Time complexity: O(mn), Space complexity:O(m+n)
        val x = matrix.size
        val y = matrix[0].size
        val rows = BooleanArray(x)
        val cols = BooleanArray(y)
        //check if need to put 1 or not
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (matrix[i][j] == 0) {
                    rows[i] = true
                    cols[j] = true
                }
            }
        }
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (rows[i] or cols[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}