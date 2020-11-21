package LeetCode_37

/**
 * 37. Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
1.Each of the digits 1-9 must occur exactly once in each row.
2.Each of the digits 1-9 must occur exactly once in each column.
3.Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
4.Empty cells are indicated by the character '.'.

Note:
The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 * */
class Solution {
    /*
    * solution: Backtracking, Time complexity:O(2^n), Space complexity:O(n)
    * */

    var retVal: Array<CharArray>? = null

    fun solveSudoku(board: Array<CharArray>): Unit {
        help(board, 0, 0)
    }

    private fun help(board: Array<CharArray>, x_: Int, y_: Int) {
        var x = x_
        var y = y_
        if (y > 8) {
            //scan next col
            x++
            y = 0
        }
        //till to the last row
        if (x == 9) {
            retVal = board
            return
        }
        if (board[x][y] == '.') {
            for (i in '1'..'9') {
                if (isValid(board, x, y, i)) {
                    board[x][y] = i
                    help(board, x, y + 1)
                    if (retVal != null) {
                        return
                    }
                    board[x][y] = '.'
                }
            }
        } else {
            help(board, x, y + 1)
        }
    }

    private fun isValid(board: Array<CharArray>, x: Int, y: Int, char: Char): Boolean {
        return isValidInRowAndCol(board, x, y, char) && isValidInSquare(board, x, y, char)
    }

    private fun isValidInRowAndCol(board: Array<CharArray>, x: Int, y: Int, char: Char): Boolean {
        for (i in 0 until 9) {
            if (board[x][i] == char || board[i][y] == char) {
                return false
            }
        }
        return true
    }

    private fun isValidInSquare(board: Array<CharArray>, x: Int, y: Int, char: Char): Boolean {
        val startX = 3 * (x / 3)
        val startY = 3 * (y / 3)
        val endX = startX + 2
        val endY = startY + 2
        for (i in startX..endX) {
            for (j in startY..endY) {
                if (board[i][j] == char) {
                    return false
                }
            }
        }
        return true
    }
}