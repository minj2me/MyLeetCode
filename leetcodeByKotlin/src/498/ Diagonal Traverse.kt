package LeetCode_498

import java.util.*

/**
 * 498. Diagonal Traverse
 * https://leetcode.com/problems/diagonal-traverse/
 *
Given a matrix of M x N elements (M rows, N columns),
return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
 * */
class Solution {
    /*
    * solution: scan matrix and insert into queue
    * 1. scan length: m+n-1
    * 2. up right when even index
    * 3. down right when odd index
    * Time complexity:O(mn), Space complexity:O(mn)
    * */
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix == null || matrix.isEmpty()) {
            return IntArray(0)
        }
        val row = matrix.size
        val col = matrix[0].size
        val diagonals = Array<LinkedList<Int>>(row + col - 1) { LinkedList() }
        for (i in 0 until row) {
            for (j in 0 until col) {
                val key = i + j
                val num = matrix[i][j]
                if (key % 2 == 0) {
                    //up right, insert into head of queue
                    diagonals[key].offerFirst(num)
                } else {
                    //down right, insert into tail of queue
                    diagonals[key].offer(num)
                }
            }
        }
        //set the result
        val result = IntArray(row * col)
        var index = 0
        for (item in diagonals) {
            for (num in item) {
                result[index] = num
                index++
            }
        }
        return result
    }
}