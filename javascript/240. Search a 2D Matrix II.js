/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

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
 */
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
    if (matrix.length == 0)
        return false;
    if (matrix[0].length == 0)
        return false;
    /**
     * 我们观察题目中给的那个例子，我们可以发现有两个位置的数字很有特点，左下角和右上角的数。
     * 左下角的18，往上所有的数变小，往右所有数增加，那么我们就可以和目标数相比较，如果目标数大，就往右搜，
     * 如果目标数小，就往上搜
     */
    let x = matrix.length - 1, y = 0;//左下角的数
    //console.log(matrix[x][y]);
    while (true) {
        if (matrix[x][y] > target) {
            //need search to up
            x--;
        } else if (matrix[x][y] < target) {
            //need search to right
            y++;
        } else
            return true;
        //check the border
        if (x < 0 || y >= matrix[0].length)
            break;

    }
    return false;
};