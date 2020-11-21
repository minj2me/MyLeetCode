package LeetCode_36

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
1.Each row must contain the digits 1-9 without repetition.
2.Each column must contain the digits 1-9 without repetition.
3.Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
==A Sudoku board (partially filled) could be valid but is not necessarily solvable.
==Only the filled cells need to be validated according to the mentioned rules.
==The given board contain only digits 1-9 and the character '.'.
==The given board size is always 9x9.
 * */
class Solution {
    /*
    * solution: HashSet, Time complexity:O(9*9), Space complexity:O(9)
    * */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        /*
        * for example:
        * [
          ["5","3",".",".","7",".",".",".","."],
          ["6",".",".","1","9","5",".",".","."],
          [".","9","8",".",".",".",".","6","."],
          ["8",".",".",".","6",".",".",".","3"],
          ["4",".",".","8",".","3",".",".","1"],
          ["7",".",".",".","2",".",".",".","6"],
          [".","6",".",".",".",".","2","8","."],
          [".",".",".","4","1","9",".",".","5"],
          [".",".",".",".","8",".",".","7","9"]
        ]
        * */
        val set = HashSet<Char>()
        val size = board.size
        val n = board[0].size
        for (i in 0 until size) {
            set.clear()
            //check the rows like:
            //["5","3",".",".","7",".",".",".","."],
            for (j in 0 until n) {
                val char = board[i][j]
                if (char != '.' && set.contains(char)) {
                    return false
                }
                set.add(char)
            }
            set.clear()

            //check the cols like:
            //["5","6",".","8","4","7",".",".","."],
            for (j in 0 until n) {
                val char = board[j][i]
                if (char != '.' && set.contains(char)) {
                    return false
                }
                set.add(char)
            }
            set.clear()

            //check each 3x3 sub-boxes
            /*like:
            * ["5","3",".",".","7",".",".",".","."],
              ["6",".",".","1","9","5",".",".","."],
              [".","9","8",".",".",".",".","6","."],
              ==>
              ["5","3",".","6",".",".",".","9","8"],
            * */
            val x = i / 3 * 3
            val y = i % 3 * 3
            for (j in 0 until n) {
                val char = board[x + j / 3][y + j % 3]
                if (char != '.' && set.contains(char)) {
                    return false
                }
                set.add(char)
            }
        }
        return true
    }
}