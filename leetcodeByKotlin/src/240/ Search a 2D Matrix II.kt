package LeetCode_240

/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example:
Consider the following matrix:
[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 * */
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        //定义两个指针 x and y；x指向第0行,y指向最大的列,开始时指向右上角元素
        var x = 0
        var y = matrix[0].size - 1
        while (true) {
            if (matrix[x][y] == target) {
                return true
            } else if (matrix[x][y] < target) {
                //表示要找下一行
                x++
            } else {
                //表示向左找
                y--
            }
            //check the border
            if (x >= matrix.size || y < 0) {
                break
            }
        }
        return false
    }
}