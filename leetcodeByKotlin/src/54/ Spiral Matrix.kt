package LeetCode_54

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
Example 1:
Input:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
 * */
class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = ArrayList<Int>()
        var rowStart = 0
        var rowEnd = matrix.size - 1
        var colStart = 0
        var colEnd = matrix[0].size - 1
        while (true) {
            //row, left to right
            for (j in colStart..colEnd) {
                result.add(matrix[rowStart][j])
            }
            rowStart++
            if (rowStart > rowEnd) {
                break
            }

            //down
            for (i in rowStart..rowEnd) {
                result.add(matrix[i][colEnd])
            }
            colEnd--
            if (colStart > colEnd) {
                break
            }

            //right to left
            for (j in colEnd downTo colStart) {
                result.add(matrix[rowEnd][j])
            }
            rowEnd--
            if (rowStart > rowEnd) {
                break
            }

            //up
            for (i in rowEnd downTo rowStart){
                result.add(matrix[i][colStart])
            }
            colStart++
            if (colStart > colEnd) {
                break
            }
        }
        println(result)
        return result
    }
}