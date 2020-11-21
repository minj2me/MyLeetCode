package LeetCode_1428

/**
 * 1428. Leftmost Column with at Least a One
 * (locked by leetcode)
(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
You can't access the Binary Matrix directly.

You may only access the matrix using a BinaryMatrix interface:
BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.

Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
Also, any solutions that attempt to circumvent the judge will result in disqualification.
For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

Example 1:
Input: mat = [[0,0],[1,1]]
Output: 0
 * */

class BinaryMatrix {
    /*
        [[0,0,0],
         [0,1,0],
         [0,1,1]]
    * */
    private val ROW = 3
    private val COL = 3
    private val matrix = Array(ROW) { IntArray(COL) }

    init {
        //For each individual row of the matrix, this row is sorted in non-decreasing order.
        matrix[0] = intArrayOf(0, 0, 1)
        matrix[1] = intArrayOf(0, 0, 0)
        matrix[2] = intArrayOf(1, 1, 1)
    }

    fun get(row: Int, col: Int): Int {
        return matrix[row][col]
    }

    fun dimensions(): List<Int> {
        val list = ArrayList<Int>(2)
        list.add(ROW)
        list.add(COL)
        return list
    }

}

class Solution {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        /*
        * solution 1: binary search, Time complexity:O(row*log col)
        * */
        val list = binaryMatrix.dimensions()
        val rows = list.get(0)
        val cols = list.get(1)
        var minCol = Int.MAX_VALUE
        /*
        * solution 1: binary search, Time complexity:O(row*log col)
        * */
        /*for (row in 0 until rows) {
            minCol = Math.min(minCol, findFirstOne(row, cols, binaryMatrix))
        }
        return if (minCol == Int.MAX_VALUE) -1 else minCol
        */

        /*
        * solution 2
        * */
        val result = findFirstOne2(rows, cols, binaryMatrix)
        print(result)
        return result
    }

    private fun findFirstOne(row: Int, cols: Int, binaryMatrix: BinaryMatrix): Int {
        var left = 0
        var right = cols - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (binaryMatrix.get(row, mid) == 1) {
                //if found out 1 in middle, we continue search left side, because we need find the left most one
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun findFirstOne2(row: Int, cols: Int, binaryMatrix: BinaryMatrix): Int {
        var i = 0
        var j = cols - 1
        var lastMostOne = -1
        //start scan from right top
        while (i < row && j >= 0) {
            if (binaryMatrix.get(i, j) == 0) {
                i++ //scan next row
            } else {
                //keep moving to left
                lastMostOne = j
                j--
            }
        }
        return lastMostOne
    }
}