package LeetCode_505

import java.util.*

/**
 * 505. The Maze II
 * (Prime)
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
 * When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination.
The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
If the ball cannot stop at the destination, return -1.
The maze is represented by a binary 2D array.
1 means the wall and 0 means the empty space.
You may assume that the borders of the maze are all walls.
The start and destination coordinates are represented by row and column indexes.

Example 1:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)
Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * */
class Solution {
    /*
    * solution: BFS
    * */
    fun shortestDistance(maze: Array<IntArray>, start: IntArray?, destination: IntArray?): Int {
        if (maze == null || start == null || destination == null) {
            return -1
        }
        if (maze.isEmpty() || start.isEmpty() || destination.isEmpty()) {
            return -1
        }
        val m = maze.size
        val n = maze[0].size
        //save step for each position
        val steps = Array(m, { IntArray(n) { Int.MAX_VALUE } })
        //starting position
        val startingX = start[0]
        val startingY = start[1]
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(startingX, startingY))
        //step for the start
        steps[startingX][startingY] = 0
        //help to check 4 directions
        val directions = intArrayOf(0, 1, 0, -1, 0)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            val x = cur.first
            val y = cur.second
            for (d in 0 until 4) {
                var newX = x + directions[d]
                var newY = y + directions[d + 1]
                var step = steps[x][y]
                //go through one direction to the end
                while (isValid(newX, newY, maze)) {
                    newX += directions[d]
                    newY += directions[d + 1]
                    step++
                }
                //came across tha block, step back
                newX -= directions[d]
                newY -= directions[d + 1]
                //find out the shortest distance
                if (step < steps[newX][newY]) {
                    steps[newX][newY] = step
                    queue.offer(Pair(newX, newY))
                }
            }
        }
        return if (steps[destination[0]][destination[1]] == Int.MAX_VALUE) -1 else steps[destination[0]][destination[1]]
    }

    private fun isValid(x: Int, y: Int, maze: Array<IntArray>): Boolean {
        if (x >= 0 && x < maze.size && y >= 0 && y < maze[0].size && maze[x][y] == 0) {
            return true
        }
        return false
    }
}