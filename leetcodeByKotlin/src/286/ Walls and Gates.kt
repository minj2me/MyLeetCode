package LeetCode_286

import java.util.*

/**
 * 286. Walls and Gates
 * (Prime)
 *
 * You are given a m x n 2D grid initialized with these three possible values.
1. -1 - A wall or an obstacle.
2. 0 - A gate.
3. INF - Infinity means an empty room.
We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate.
If it is impossible to reach a gate, it should be filled with INF.

Example:
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
0  -1 INF INF

After running your function, the 2D grid should be:
3  -1   0   1
2   2   1  -1
1  -1   2  -1
0  -1   3   4
 * */
class Solution {
    /*
    * Solution 1: DFS, Time complexity:O(m^2*n^2), Space complexity:O(4^n)
    * Solution 2: BFS, Time complexity:O(mn), Space complexity:O(mn)
    * */
    fun fillEmptyRoom(grid: Array<IntArray>) {
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    //dfs(i, j, 0, grid)
                    //each node go through via bfs from starting point
                    bfs(Pair(i, j), grid)
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                print("${grid[i][j]},")
            }
            println()
        }
    }

    private fun dfs(x: Int, y: Int, count: Int, grid: Array<IntArray>) {
        //return when reach gate,wall,or confirm min distance
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size || grid[x][y] < count) {
            return
        }
        grid[x][y] = count
        //expand 4 directions
        dfs(x + 1, y, count + 1, grid)
        dfs(x - 1, y, count + 1, grid)
        dfs(x, y + 1, count + 1, grid)
        dfs(x, y - 1, count + 1, grid)
    }

    private fun bfs(pair: Pair<Int, Int>, grid: Array<IntArray>) {
        val directions = intArrayOf(0, 1, 0, -1, 0)
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(pair)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            //expand 4 directions
            for (i in 0 until 4) {
                val x = cur.first + directions[i]
                val y = cur.second + directions[i + 1]
                //return when reach gate,wall,or confirm min distance
                if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].size || grid[x][y] < grid[cur.first][cur.second] + 1) {
                    continue
                }
                //update new distance to x,y
                grid[x][y] = grid[cur.first][cur.second] + 1
                queue.offer(Pair(x, y))
            }
        }
    }
}