/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/description/
 * https://www.cnblogs.com/grandyang/p/4550604.html
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
    let max = 0;
    for (let i = 0; i < matrix.length; i++) {
        let arr = new Array(matrix[i].length).fill(0);
        for (let j = i; j < matrix.length; j++) {
            for (let k = 0; k < matrix[j].length; k++) {
                if (matrix[j][k] == "1") {
                    //console.log("matrix[" + j + "][" + k + "]");
                    //++arr[k];
                    arr[k] = arr[k] + 1;
                }
            }
            max = Math.max(this.getSquareArea(arr, j - i + 1), max);
        }
        // console.log("scan from next floor");
    }
    return max;
};
var getSquareArea = function (arr, k) {
    // console.log("arr:"+arr);
    // console.log("k:"+k);
    if (arr.length < k)
        return 0;
    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] != k)
            count = 0;
        else
            count++;
        if (count == k)
            return k * k;
    }
    return 0;
};