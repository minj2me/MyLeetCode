package LeetCode_934

import java.util.*

/**
 * 934. Shortest Bridge
 * https://leetcode.com/problems/shortest-bridge/description/
 *
 * In a given 2D binary array A, there are two islands.
 * (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Example 1:
Input: A =
[[0,1],
[1,0]]
Output: 1

Constraints:
2 <= A.length == A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
 * */
class Solution {
    /**
     * solution: DFS+BFS;
     * Time complexity:O(mn), every neighbor access 4 times (constant time); Space complexity:O(mn)
     * 1.use DFS or BFS to find one island and color all the nodes as 2
     * 2.use BFS to find the shortest path from any node with color 2 to any node with color 1
     * */
    fun shortestBridge(A: Array<IntArray>): Int {
        val x = A.size
        val y = A[0].size
        //pair to save x,y
        val queue = LinkedList<Pair<Int, Int>>()
        for (i in 0 until x) {
            for (j in 0 until y) {
                if (A[i][j] == 1) {
                    //find out the starting point
                    helper(A, i, j, queue)
                    break
                }
            }
            //if find out the starting point, break it, avoid update all to 2
            if (queue.size > 0) {
                break
            }
        }
        //2.bfs to expand all node
        val direction = intArrayOf(0, 1, 0, -1, 0)
        var step = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (k in 0 until size) {
                val cur = queue.poll()
                for (d in 0 until 4) {
                    /*
                    * get the new direction like:
                    * x,y+1
                    * x,y-1
                    * x-1,y
                    * x+1,y
                    * */
                    val x = cur.first + direction[d]
                    val y = cur.second + direction[d + 1]
                    if (x < 0 || y < 0 || x >= A.size || y >= A[0].size || A[x][y] == 2) {
                        continue
                    }
                    if (A[x][y] == 1) {
                        return step
                    }
                    if (A[x][y] == 0) {
                        A[x][y] = 2
                    }
                    queue.offer(Pair(x, y))
                }
            }
            step++
        }
        return -1
    }

    private fun helper(A: Array<IntArray>, x: Int, y: Int, queue: LinkedList<Pair<Int, Int>>) {
        if (x < 0 || y < 0 || x >= A.size || y >= A[0].size || A[x][y] != 1) {
            return
        }
        A[x][y] = 2
        queue.offer(Pair(x, y))
        helper(A, x, y + 1, queue)
        helper(A, x, y - 1, queue)
        helper(A, x + 1, y, queue)
        helper(A, x - 1, y, queue)
    }
}