package LeetCode_62

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
 * */
class Solution {
    /*
    * solution: DP, Top-Down, Memorization, Time complexity:O(mn), Space complexity:O(mn)
    * we go back from 'Finish' position, current position just care about it's left one and top one
    * */
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        return topDownSolution(m, n, dp)
    }

    private fun topDownSolution(x: Int, y: Int, dp: Array<IntArray>): Int {
        //if reach 'Start' position
        if (x == 0 || y == 0) {
            return 0
        }
        //because we start from Finish to Start, so if i and j == 1,mean reach start
        //find out one solution
        if (x == 1 && y == 1) {
            return 1
        }
        if (dp[x][y] > 0) {
            return dp[x][y]
        }
        var res = 0
        for (i in 0 until x) {
            for (j in 0 until y) {
                //because we is go back ward, so can move left or top
                val topPath = topDownSolution(x, y - 1, dp)
                val leftPath = topDownSolution(x - 1, y, dp)
                res = topPath + leftPath
            }
        }
        dp[x][y] = res
        return res
    }
}