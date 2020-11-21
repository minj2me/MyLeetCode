/**
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/description/
 * 
 * Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, 
switching the row and column indices of the matrix.


Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 

Note:

1 <= A.length <= 1000
1 <= A[0].length <= 1000
 */
/**
 * @param {number[][]} A
 * @return {number[][]}
 */
var transpose = function (A) {
    //init 
    let m = A.length, n = A[0].length;
    // console.log("m:"+m);
    // console.log("n:"+n);
    let res = new Array();
    for (let i = 0; i < n; i++) {
        res[i] = new Array();
        for (let j = 0; j < m; j++) {
            res[i][j] = 0;
        }
    }
    //console.log(res);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // console.log("A[" + i + "][" + j + "]: " + A[i][j]);
            // console.log("res[" + j + "][" + i + "]: " + res[j][i]);
            res[j][i] = A[i][j];
        }
    }
    console.log(res);
    return res;
};