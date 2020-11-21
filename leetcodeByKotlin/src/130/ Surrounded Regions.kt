package LeetCode_130

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 * */

//DFS
class Solution {
    private var row = 0
    private var col = 0

    fun solve(board: Array<CharArray>): Unit {
        //printBoard(board)
        row = board.size
        if (row == 0) {
            return
        }
        col = board[0].size

        //just scan and handle border
        for (i in 0 until row) {
            dfs(board, i, 0)
            dfs(board, i, col - 1)
        }

        for (y in 0 until col) {
            dfs(board, 0, y)
            dfs(board, row - 1, y)
        }

        //change G to O is the result
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
                if (board[i][j] == 'G') {
                    board[i][j] = 'O'
                }
            }
        }
        //printBoard(board)
    }

    private fun dfs(board: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O') {
            return
        }
        board[x][y] = 'G'
        dfs(board, x - 1, y)
        dfs(board, x + 1, y)
        dfs(board, x, y - 1)
        dfs(board, x, y + 1)
    }

    private fun printBoard(board: Array<CharArray>) {
        val row = board.size
        val col = board[0].size
        for (i in 0 until row) {
            for (j in 0 until col) {
                print(board[i][j] + ",")
            }
            println()
            println("======")
        }
    }
}