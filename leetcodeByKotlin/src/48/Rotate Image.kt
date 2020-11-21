package LeetCode_48

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
 * https://www.cnblogs.com/grandyang/p/4389572.html
 *
You are given an n x n 2D matrix representing an image.Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
[7,4,1],
[8,5,2],
[9,6,3]
]

1  2  3                 7  2  1                  7  4  1

4  5  6      -->        4  5  6　　 -->  　       8  5  2　　

7  8  9                 9  8  3　　　　　         9  6  3

a. 1,3,9,7,
b. 2,6,8,4

val matrix = Array(3) { IntArray(3) }
for (i in 0..2) {
for (j in 0..2) {
when (i) {
0 -> {
matrix[i][j] = j + 1
}
1 -> {
matrix[i][j] = j + 4
}
2 -> {
matrix[i][j] = j + 7
}
}
}
}
 * */

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty() || matrix[0].isEmpty())
            return
        val n = matrix.size
        for (i in 0..(n / 2 - 1)) {
            for (j in i..n - 2 - i) {
                val temp = matrix[i][j]
                println("temp:" + temp)
                println("matrix[n-1-j][i]:" + matrix[n - 1 - j][i])
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = temp
            }
        }
    }
}

