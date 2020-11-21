package LeetCode_63

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 * https://www.youtube.com/watch?v=8v-dX6ato_Y
 * */
class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        if (obstacleGrid == null || obstacleGrid.size == 0) {
            return 0
        }
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0
        }
        val dp = Array(m + 1) { IntArray(n + 1) }
        dp[0][0] = 1//robot init location
        //there are only column
        for (i in 1 until m) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0
            } else {
                dp[i][0] = dp[i - 1][0]//the value of the top
            }
        }
        //there are only row
        for (j in 1 until n) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0
            } else {
                dp[0][j] = dp[0][j - 1]//the value of the left
            }
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        return dp[m - 1][n - 1]
    }
}