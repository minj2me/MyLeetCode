package LeetCode_329

import java.util.*

/**
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
Input: nums =
[
[9,9,4],
[6,6,8],
[2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
Input: nums =
[
[3,4,5],
[3,2,6],
[2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * */
class Solution {
    /*
    * solution:BFS + Memorization;
    * Time complexity:O(mn), every neighbor access 4 times (constant time);
     * Space complexity:O(mn);
    * */
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix == null || matrix.isEmpty()) {
            return 0
        }
        var result = 1
        val direction = intArrayOf(0, 1, 0, -1, 0)
        val m = matrix.size
        val n = matrix[0].size
        val dp = Array(m, { IntArray(n) })
        for (i in 0 until m) {
            for (j in 0 until n) {
                //with memorization, below is O(1)
                if (dp[i][j] > 0) {
                    continue
                }
                //Pair to save x,y
                val queue = LinkedList<Pair<Int, Int>>()
                queue.offer(Pair(i, j))
                var count = 1
                while (queue.isNotEmpty()) {
                    //keep tracking this node's path
                    count++
                    val size = queue.size
                    for (k in 0 until size) {
                        val current = queue.poll()
                        //check it 4 directions
                        /*
                        * get the new direction like:
                        * x,y+1
                        * x,y-1
                        * x-1,y
                        * x+1,y
                        * */
                        for (d in 0 until 4) {
                            val x = current.first + direction[d]
                            val y = current.second + direction[d + 1]
                            /*
                            * check if need to update:
                            * 1. x,y cannot cross the boundary;
                            * 2. the neighbor value should be grater than current value;
                            * 3. the dp value of neighbor should be less than the dp value of current;
                            * */
                            if (x < 0 || y < 0 || x >= m || y >= n ||
                                matrix[x][y] <= matrix[current.first][current.second] || count <= dp[x][y]) {
                                continue
                            }
                            dp[x][y] = count
                            result = Math.max(result, count)
                            queue.offer(Pair(x, y))
                        }
                    }
                }
            }
        }
        return result
    }
}