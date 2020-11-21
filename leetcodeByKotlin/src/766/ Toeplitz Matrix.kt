package LeetCode_766

/**
 * 766. Toeplitz Matrix
 * https://leetcode.com/problems/toeplitz-matrix/description/
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Example 1:
Input:
matrix = [
[1,2,3,4],
[5,1,2,3],
[9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Example 2:
Input:
matrix = [
[1,2],
[2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.

Note:
matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].

Follow up:
1. What if the matrix is stored on disk,
 and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
2. What if the matrix is so large that you can only load up a partial row into the memory at once?
 * */
class Solution {
    /*
    * solution: Scan grid keep tracking current_row,current_col if equal current_row+1,current_col+1,
    * Time complexity: O(n^2), Space complexity: O(1)
    * for example:
    * matrix = [
        [1,2,3,4],
        [5,1,2,3],
        [9,5,1,2]
        ]
     check each 1 by increasing row and col
    *
    * */
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        val m = matrix.size
        val n = matrix[0].size
        for (i in 0 until m - 1) {
            for (j in 0 until n - 1) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false
                }
            }
        }
        return true
    }
}