/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 * https://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

/**
* @param {number[][]} matrix
* @return {number[]}
*/
var spiralOrder = function (matrix) {
    if (matrix.length == 0)
        return [];
    let result = [];
    let row = matrix.length;
    let col = matrix[0].length;
    let x = 0, y = 0;
    while (row > 0 && col > 0) {
        if (row == 1) {
            for (let i = 0; i < col; i++) {
                result.push(matrix[x][y++]);
            }
            break;
        } else if (col == 1) {
            for (let i = 0; i < row; i++) {
                result.push(matrix[x++][y]);
            }
            break;
        }

        //fix circel
        //top, move right
        for (let i = 0; i < col - 1; i++) {
            result.push(matrix[x][y++]);
        }
        //right, move down
        for (let i = 0; i < row - 1; i++) {
            result.push(matrix[x++][y]);
        }
        //bottom, move left
        for (let i = 0; i < col - 1; i++) {
            result.push(matrix[x][y--]);
        }
        //left, move top
        for (let i = 0; i < row - 1; i++) {
            result.push(matrix[x--][y]);
        }

        x++;
        y++;
        row = row - 2;
        col = col - 2;
    }
    console.log(result);
    return result;
};