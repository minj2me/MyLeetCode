package LeetCode_694

import java.util.*
import kotlin.collections.HashSet

/**
 * 694. Number of Distinct Islands
 * (Prime)
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
Count the number of distinct islands.
An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.

Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
1
11
are considered different island shapes, because we do not consider reflection / rotation.

Note: The length of each dimension in the given grid does not exceed 50.
 * */
class Solution {
    /*
    * solution: bfs, count the number of island, then remove the same sharp via HashSet,
    * Time complexity:O(mn), Space complexity:O(mn)
    * */

    val set = HashSet<ArrayList<Int>>()
    val directions = intArrayOf(0, 1, 0, -1, 0)

    fun numDistinctIslands(grid: Array<IntArray>): Int {
        if (grid == null || grid.isEmpty()) {
            return 0
        }
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j)
                }
            }
        }
        return set.size
    }

    private fun bfs(grid: Array<IntArray>, x: Int, y: Int) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(x, y))
        //set as visited
        grid[x][y] = -1
        //list for save index of directions
        val list = ArrayList<Int>()
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            for (d in 0 until 4) {
                val newX = cur.first + directions[d]
                val newY = cur.second + directions[d + 1]
                if (newX < 0 || newY < 0 || newX >= grid.size || newY >= grid[0].size || grid[newX][newY] != 1) {
                    continue
                }
                //set as visited
                grid[newX][newY] = -1
                queue.offer(Pair(newX, newY))
                list.add(d)
            }
        }
        set.add(list)
    }
}