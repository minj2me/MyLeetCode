package LeetCode_317

import java.util.*

/**
 * 317. Shortest Distance from All Buildings
 * (Prime)
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
1. Each 0 marks an empty land which you can pass by freely.
2. Each 1 marks a building which you cannot pass through.
3. Each 2 marks an obstacle which you cannot pass through.

Example:
Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
Output: 7
Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
the point (1,2) is an ideal empty land to build a house, as the total
travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building.
If it is not possible to build such house according to the above rules, return -1.
 * */
class Solution {
    /*
    *solution:BFS, do bfs for each building,
    * Time complexity:O(m^2*n^2), Space complexity:O(mn)
    * */
    fun shortestDistance(grid: Array<IntArray>?): Int {
        if (grid == null || grid.isEmpty()) {
            return -1
        }
        var buildingCount = 0
        val m = grid.size
        val n = grid[0].size
        //save distance of each x,y to building
        val distance = Array(m) { IntArray(n) }
        //save how many building x,y can reach
        val reach = Array(m) { IntArray(n) }
        //4 directions
        val direction = intArrayOf(0, -1, 0, 1, 0)
        for (i in 0 until m) {
            for (j in 0 until n) {
                //start bfs when meet building
                if (grid[i][j] == 1) {
                    buildingCount++
                    val queue = LinkedList<Pair<Int, Int>>()
                    val visited = Array(m) { BooleanArray(n) }
                    visited[i][j] = true
                    var level = 0
                    queue.offer(Pair(i, j))
                    while (queue.isNotEmpty()) {
                        val size = queue.size
                        for (i in 0 until size) {
                            val cur = queue.pop()
                            val curX = cur.first
                            val curY = cur.second
                            //update the distance for x,y
                            distance[curX][curY] += level
                            //update the count of reach to 1 for x,y
                            reach[curX][curY]++
                            for (d in 0 until 4) {
                                val nextX = curX + direction[d]
                                val nextY = curY + direction[d + 1]
                                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                                    visited[nextX][nextY] = true
                                    queue.offer(Pair(nextX, nextY))
                                }
                            }
                        }
                        level++
                    }
                }
            }
        }
        var shortest = Int.MAX_VALUE
        /*
        * checking each x,y is 0, if current reach count equal to total building count, compare for shortest one
        * */
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0 && reach[i][j] == buildingCount) {
                    shortest = Math.min(shortest, distance[i][j])
                }
            }
        }
        return if (shortest == Int.MAX_VALUE) -1 else shortest
    }
}