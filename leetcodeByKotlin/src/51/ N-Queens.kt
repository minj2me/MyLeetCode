package LeetCode_51

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/description/
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
and an empty space respectively.

Example:

Input: 4
Output: [
[".Q..",  // Solution 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // Solution 2
"Q...",
"...Q",
".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * */
class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = ArrayList<ArrayList<String>>()
        val board = Array(n) { Array(n, { "." }) }
        backtracking(result, board, 0)
        for (i in 0 until result.size) {
            println(result[i])
        }
        return result
    }

    private fun backtracking(result: ArrayList<ArrayList<String>>, board: Array<Array<String>>, colIndex: Int) {
        if (colIndex == board.size) {
            val list = ArrayList<String>()
            for (i in board.indices) {
                val sb = StringBuilder()
                for (item in board[i]) {
                    sb.append(item)
                    //print("$item,")
                }
                list.add(0, sb.toString())
            }
            //print(list)
            result.add(list)
            return
        }
        for (i in board.indices) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = "Q"
                backtracking(result, board, colIndex + 1)
                board[i][colIndex] = "."
            }
        }
    }

    // x == i 同一行
    // x + j == y + i (y -x == j - i,斜率1,在同一条直线上) 同一主斜行
    // x + y == i + j(x-i=-(y-j),斜率-1,在同一条直线上) 同一副斜行
    private fun isValid(board: Array<Array<String>>, x: Int, y: Int): Boolean {
        for (i in board.indices) {
            // 判断放置第j列的时候，是否与前面的冲突，
            // 不需要判断y == j（循环j<y），只是与前面的进行比较
            for (j in 0 until y) {
                // same as if(board[i][j] == 'Q'
                //&& (Math.abs(x - i) == Math.abs(y - j) || x == i))
                if (board[i][j] == "Q" && (x - y == i - j || x + y == i + j || x == i)) {
                    return false
                }
            }
        }
        return true
    }
}