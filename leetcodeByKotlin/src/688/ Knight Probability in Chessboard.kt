package LeetCode_688


/**
 * 688. Knight Probability in Chessboard
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
A chess knight has 8 possible moves it can make, as illustrated below.
Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

Each time the knight is to move,
it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
The knight continues moving until it has made exactly K moves or has moved off the chessboard.
Return the probability that the knight remains on the board after it has stopped moving.

Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.

Note:
N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.
 * */
class Solution {
    /*
    * solution 1: recursion, TLE,
    * solution 2: DP, Top-Down, recursion+memorization, Time:O(k*n^2), Space:O(n^2)
    * */

    //8 directions
    val directions = arrayOf(
        //x,y
        intArrayOf(1, -2),
        intArrayOf(2, -1),
        intArrayOf(2, 1),
        intArrayOf(1, 2),
        intArrayOf(-1, 2),
        intArrayOf(-2, 1),
        intArrayOf(-2, -1),
        intArrayOf(-1, -2)
    )

    fun knightProbability(N: Int, K: Int, r: Int, c: Int): Double {
        val dp = Array(N, { Array(N) { DoubleArray(K + 1) } })
        val totalSolution = find(N, K, r, c, dp)
        //because every step has 8 directions, so k step is 8^k
        val result = totalSolution / Math.pow(8.0, K.toDouble())
        return result
    }

    private fun find(N: Int, K: Int, r: Int, c: Int, dp: Array<Array<DoubleArray>>): Double {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return 0.0
        }
        if (K == 0) {
            //find out one solution
            return 1.0
        }
        if (dp[r][c][K] != 0.0) {
            return dp[r][c][K]
        }
        var solution = 0.0
        for (i in directions.indices) {
            //sum up every solution
            solution += find(N, K - 1, r + directions[i][0], c + directions[i][1], dp)
        }
        dp[r][c][K] = solution
        return solution
    }
}