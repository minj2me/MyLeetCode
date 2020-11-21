package LeetCode_542

import java.util.*

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input:
[[0,0,0],
[0,1,0],
[0,0,0]]
Output:
[[0,0,0],
[0,1,0],
[0,0,0]]
 * */
class Solution {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray>? {
        if (matrix.isEmpty()) {
            return Array<IntArray>(0, { IntArray(0) })
        }
        val m = matrix.size
        val n = matrix[0].size

        val queue = LinkedList<IntArray>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    //save element zero which x,y is 0
                    val xyArray = IntArray(2)
                    xyArray[0] = i
                    xyArray[1] = j
                    queue.offer(xyArray)
                } else {
                    //set to maximum value
                    matrix[i][j] = Int.MAX_VALUE
                }
            }
        }

        //4 directions: up, down, left, right
        val dirs = Array(4) { IntArray(2) }
        dirs[0] = intArrayOf(-1, 0)
        dirs[1] = intArrayOf(1, 0)
        dirs[2] = intArrayOf(0, -1)
        dirs[3] = intArrayOf(0, 1)

        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            for (d in dirs) {
                val dx = cur[0] + d[0]
                val dy = cur[1] + d[1]
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                    continue
                }
                //the value from up,down,left,right
                val value = matrix[dx][dy]
                val temp = matrix[cur[0]][cur[1]] + 1
                println("value:$value")
                println("temp:$temp")
                //if value less than temp, mean has been updated before
                if (value <= temp) {
                    println("$value <= $temp")
                    continue
                }
                val xyArray = IntArray(2)
                xyArray[0] = dx
                xyArray[1] = dy
                queue.offer(xyArray)
                matrix[dx][dy] = temp
                println("matrix[$dx][$dy] = $temp")
            }
        }

        return matrix
    }
}