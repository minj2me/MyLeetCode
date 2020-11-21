package LeetCode_931

/**
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
A falling path starts at any element in the first row, and chooses one element from each row.
The next row's choice must be in a column that is different from the previous row's column by at most one.

Example 1:
Input:
[
[1,2,3],
[4,5,6],
[7,8,9]
]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.

Constraints:
1. 1 <= A.length == A[0].length <= 100
2. -100 <= A[i][j] <= 100
 * */
class Solution {
    /*
    * solution : DP, Bottom-Up, for example array is:
    * [
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ]
       fill new array from second row, the value of current i,j is: current value + min(A[i-1][j], A[i-1][j+1])
        [1,2,3],
        [5,6,8],//<-this row after fill by: 4+min(1,2), 5+min(1,min(2,3)), 6+min(2,3)
        [12,13,15],//<-this row after fill by: 7+min(5,6), 8+min(5,min(6,8)), 9+min(6,8)
        result is minimum in last row

        Time complexity:O(nn), Space complexity:O(1)
    * */
    fun minFallingPathSum(A: Array<IntArray>): Int {
        if (A == null || A.isEmpty()) {
            return 0
        }
        val n = A.size
        if (n == 1) {
            return A[0][0]
        }
        for (i in 1 until n) {//start from second row
            for (j in 0 until n) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1])
                } else if (j == n - 1) {
                    A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j])
                } else {
                    A[i][j] += Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j + 1], A[i - 1][j]))
                }
            }
        }
        var result = Int.MAX_VALUE
        for (cols in 0 until n) {
            result = Math.min(result, A[n - 1][cols])
        }
        return result
    }
}