package LeetCode_994

import java.util.*

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 *
 * In a given grid, each cell can have one of three values:
the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.
 * */
class Solution {
    /*
    * solution: bfs, check every position in grid
    * Time complexity: O(mn), Space complexity: O(mn)
    * */
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid == null || grid.isEmpty()) {
            return 0
        }
        val m = grid.size
        val n = grid[0].size
        val directions = intArrayOf(0, 1, 0, -1, 0)
        var freshCount = 0
        val queue = LinkedList<Pair<Int, Int>>()
        var time = 0
        //save all rotten orange and count fresh orange
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 2) {
                    queue.offer(Pair(i, j))
                } else if (grid[i][j] == 1) {
                    freshCount++
                }
            }
        }
        //use freshCount>0 to avoid do one more useless loop
        while (queue.isNotEmpty() && freshCount > 0) {
            //increase time at each level
            time++
            //the size of rotten orange of current level
            val size = queue.size
            for (i in 0 until size) {
                //get the rotten orange
                val cur = queue.pop()
                //checking 4 directions of cur
                for (d in 0 until 4) {
                    val x = cur.first + directions[d]
                    val y = cur.second + directions[d + 1]
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue
                    }
                    //set new x,y to rotten
                    grid[x][y] = 2
                    //reduce freshCount
                    freshCount--
                    //put into queue for next level
                    queue.offer(Pair(x, y))
                }
            }
        }
        return if (freshCount == 0) time else -1
    }
}