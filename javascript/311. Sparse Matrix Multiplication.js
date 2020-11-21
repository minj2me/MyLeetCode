/**
 * Lock by Leetcode
 * 
 * 311. Sparse Matrix Multiplication
 * https://www.lintcode.com/problem/sparse-matrix-multiplication/description
 * 
 * Given two Sparse Matrix A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */
/**
 * @param A: a sparse matrix
 * @param B: a sparse matrix
 * @return: the result of A * B
 * 
 *  i x k 的矩阵A乘以一个 k x j 的矩阵B会得到一个 i x j 大小的矩阵C
 */
const multiply = function (A, B) {
    //init martix (二维数组)
    let res = new Array();
    for (let i = 0; i < A.length; i++) {
        res[i] = new Array();
        for (let j = 0; j < B[0].length; j++) {
            res[i][j] = 0;
        }
    }
    // console.log(res);
    for (let i = 0; i < A.length; i++) {
        for (let j = 0; j < A[0].length; j++) {
            if (A[i][j] != 0) {
                //不重复计算0乘0，我们首先遍历A数组，要确保A[i][k]不为0，才继续计算
                for (let k = 0; k < B[0].length; k++) {
                    //B矩阵的第k行，如果B[j][k]不为0，我们累加结果矩阵res[i][k] += A[i][j] * B[j][k];
                    if (B[j][k] != 0) {
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
    }
    //console.log(res);
    return res;
}

