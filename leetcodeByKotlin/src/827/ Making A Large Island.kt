package LeetCode_827

import java.util.*
import kotlin.collections.HashMap

/**
 * 827. Making A Large Island
 * https://leetcode.com/problems/making-a-large-island/
 *
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:
Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * */
class Solution {
    /*
    * Solution: DFS,BFS,HashMap,HashSet, Time complexity:O(mn), Space complexity:O(mn);
    * 1. DFS to find out the large island and save every island'id in map and mapping size of island,
    * 2. BFS to determine what's max island size is when we change zeros to ones, and we use HashSet to help us sum up the
    * island with same unique ID,
    * */
    fun largestIsland(grid: Array<IntArray>): Int {
        if (grid == null || grid.isEmpty()) {
            return 0
        }
        var max = 0
        //because grid has contains 0,1
        var isLandId = 2
        //key: islandId, value:size the island
        val map = HashMap<Int, Int>()
        val m = grid.size
        val n = grid[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                //when we meet island, start to find the island size
                if (grid[i][j] == 1) {
                    val size = islandSize(grid, i, j, isLandId)
                    //keep update the max area
                    max = Math.max(max,size)
                    //mapping the islandId and its area size
                    map.put(isLandId, size)
                    //increase the islandId to ensure have unique id
                    isLandId++
                }
            }
        }
        //start bfs
        val queue = LinkedList<Pair<Int, Int>>()
        //4 directions
        val directions = intArrayOf(0, 1, 0, -1, 0)
        //queue to save all non island
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    queue.offer(Pair(i, j))
                }
            }
        }
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            val set = HashSet<Int>()
            //temp init is 1, because this can be change into 1
            var temp = 1
            for (d in 0 until 4) {
                val x = cur.first + directions[d]
                val y = cur.second + directions[d + 1]
                if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y]==0) {
                    continue
                }
                val value = grid[x][y]
                if (!set.contains(value)) {
                    set.add(value)
                    temp += map.get(value) ?: 0
                }
            }
            max = Math.max(max, temp)
        }
        return max
    }

    private fun islandSize(grid: Array<IntArray>, i: Int, j: Int, islandId: Int): Int {
        if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] != 1) {
            return 0
        }
        //set this position to current islandId
        grid[i][j] = islandId
        //calculate 4 directions
        val left = islandSize(grid, i-1, j, islandId)
        val right = islandSize(grid, i+1, j, islandId)
        val top = islandSize(grid, i, j-1, islandId)
        val bottom = islandSize(grid, i, j+1, islandId)
        return left + right + top + bottom + 1
    }
}
