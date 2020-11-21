package LeetCode_64

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:
Input:
[
[1,3,1],
[1,5,1],
[4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * */
class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid == null) {
            return 0
        }
        val x = grid.size
        if (x == 0) {
            return 0
        }
        val y = grid[0].size
        //dfs with memoization
        //val resArray = Array(x) { IntArray(y) }
        //return dfs(grid, x - 1, y - 1, resArray)

        //can try dp
        val dp = Array(x) { IntArray(y) }
        dp[0][0] = grid[0][0]
        //init first row
        for (i in 1..x) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        }
        //init first column
        for (j in 1..y) {
            dp[0][j] = dp[0][j - 1] + grid[0][j]
        }
        for (i in 1 until x) {
            for (j in 1 until y) {
                //The path to reach (m, n) must be through one of the 2 ways:
                //(m-1, n) or (m, n-1).
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
            }
        }
        return dp[x-1][y-1]
    }

    private fun dfs(grid: Array<IntArray>, x: Int, y: Int, resArray: Array<IntArray>): Int {
        //because just can move from down or right, so current min sum = grid[x][y] + Math.min(x-1,y-1)
        if (x == 0 && y == 0) {
            return grid[x][y]
        }
        if (x < 0 || y < 0) {
            return Int.MAX_VALUE
        }
        if (resArray[x][y] > 0) {
            //get from saved before
            return resArray[x][y]
        }
        resArray[x][y] = grid[x][y] + Math.min(dfs(grid, x - 1, y, resArray), dfs(grid, x, y - 1, resArray))
        return resArray[x][y]
    }
}