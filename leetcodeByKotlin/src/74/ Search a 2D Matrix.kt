package LeetCode_74

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
[1,   3,  5,  7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
target = 3
Output: true
 * */
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        //定义两个指针 x and y；x指向第0行,y指向最大的列,开始时指向右上角元素
        var x = 0
        var y = matrix[0].size - 1
        while (x < matrix.size && y >= 0) {
            if (matrix[x][y] == target) {
                return true
            } else if (matrix[x][y] < target) {
                //表示要找下一行
                x++
            } else {
                //表示向左找
                y--
            }
        }
        return false
    }
}