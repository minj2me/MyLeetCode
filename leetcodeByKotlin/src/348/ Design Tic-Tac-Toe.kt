package LeetCode_348

/**
 * 348. Design Tic-Tac-Toe
 * (Lock by leetcode)
 * https://www.lintcode.com/problem/design-tic-tac-toe/description
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:
1. A move is guaranteed to be valid and is placed on an empty block.
2. Once a winning condition is reached, no more moves is allowed.
3. A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * */
class Solution {
    var matrix: Array<IntArray>? = null
    var rows: IntArray? = null
    var cols: IntArray? = null
    var dia1 = 0
    var dia2 = 0
    var n = 0

    fun TicTacToe(n: Int) {
        this.n = n
        matrix = Array(n, { IntArray(n) })
        rows = IntArray(n)
        cols = IntArray(n)
    }

    fun move2(row: Int, col: Int, player: Int): Int {
        val value = if (player == 1) 1 else -1
        rows!![row] += value
        cols!![col] += value
        //diagonal from top left to right bottom
        if (row == col) {
            dia1++
        }
        //diagonal from top right to left bottom
        if (col == n - row - 1) {
            dia2++
        }

        if (Math.abs(rows!![row]) == n ||
            Math.abs(cols!![col]) == n ||
            Math.abs(dia1) == n ||
            Math.abs(dia2) == n) {
            return player
        }

        return 0
    }

    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
    fun move(row: Int, col: Int, player: Int): Int {
        /*
        * solution 1:Time complexity: O(n*n), Space complexity:O(n*n)
        * */
        val localMatrix = matrix
        localMatrix!![row][col] = player
        //check row
        var win = true
        for (i in localMatrix.indices) {
            if (localMatrix[row][i] != player) {
                win = false
                break
            }
        }
        if (win) {
            return player
        }

        //check columns
        win = true
        for (i in localMatrix.indices) {
            if (localMatrix[i][col] != player) {
                win = false
                break
            }
        }
        if (win) {
            return player
        }

        //check back diagonal
        win = true
        for (i in localMatrix.indices) {
            if (localMatrix[i][i] != player) {
                win = false
                break
            }
        }
        if (win) {
            return player
        }

        //check forward diagonal
        win = true
        for (i in localMatrix.indices) {
            if (localMatrix[i][localMatrix.size - i - 1] != player) {
                win = false
                break
            }
        }
        if (win) {
            return player
        }

        return 0
    }
}