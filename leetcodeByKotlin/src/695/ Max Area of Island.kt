package LeetCode_695

import java.util.*

/**
 * 695. Max Area of Island
 *
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,1,1,0,1,0,0,0,0,0,0,0,0],
[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],
[0,0,0,0,0,0,0,0,0,0,1,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6.
Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50.
 * */
class Solution {
    /*
    * solution : DFS and BFS, find out the largest connected component,
    * Time complexity:O(mn), Space complexity:O(mn)
    * */
    var max = 0
    var currentMax = 0
    val directions = intArrayOf(0, 1, 0, -1, 0)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid == null || grid.isEmpty()) {
            return 0
        }
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                //find out island
                if (grid[i][j] == 1) {
                    //dfs
                    //start to check current position's connected component
                    /*currentMax = 0
                    dfs(grid, i, j)*/

                    max = Math.max(max, bfs(grid, i, j))
                }
            }
        }
        return max
    }

    /**
     * dfs
     * */
    private fun dfs(grid: Array<IntArray>, x: Int, y: Int) {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size || grid[x][y] != 1) {
            return
        }
        //mark part of island visited not to visit next time
        grid[x][y] = -1
        currentMax++
        //check 4 directions
        dfs(grid, x + 1, y)
        dfs(grid, x - 1, y)
        dfs(grid, x, y + 1)
        dfs(grid, x, y - 1)

        max = Math.max(max, currentMax)
    }

    private fun bfs(grid: Array<IntArray>, x: Int, y: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val queue = LinkedList<Pair<Int, Int>>()
        //because we start from 1,so current area is 1
        var currentArea = 1
        grid[x][y] = -1//set to visited
        queue.offer(Pair(x, y))
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            for (d in 0 until 4) {
                val newX = cur.first + directions[d]
                val newY = cur.second + directions[d + 1]
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 1) {
                    continue
                }
                currentArea++
                grid[newX][newY] = -1
                queue.offer(Pair(newX, newY))
            }
        }
        return currentArea
    }
}