package LeetCode_200

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
 * */
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '0') {
                    continue
                }
                result++
                dfs(grid, i, j)
            }
        }
        return result
    }

    private fun dfs(grid: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= grid.size || y >= grid[0].size) {
            return
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0'
            dfs(grid, x + 1, y)
            dfs(grid, x - 1, y)
            dfs(grid, x, y + 1)
            dfs(grid, x, y - 1)
        }
    }
}