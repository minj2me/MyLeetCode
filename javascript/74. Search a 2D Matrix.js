/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

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

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
    let m = matrix.length;
    if (m == 0)
        return false;
    //let res = [];
    let n = matrix[0].length;
    for (let i = 0; i < m; i++) {
        //res[i] = new Array();
        for (let j = 0; j < n; j++) {
            //res.push(matrix[i][j]);
            if (matrix[i][j] == target)
                return true;
        }
    }
    return false;
    //console.log(res);
};