package LeetCode_490

import java.util.*
import kotlin.collections.HashSet

/**
 * 490. The Maze
 * (Prime)
 * https://www.lintcode.com/problem/the-maze/description
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
 * When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
The maze is represented by a binary 2D array.
1 means the wall and 0 means the empty space.
You may assume that the borders of the maze are all walls.
The start and destination coordinates are represented by row and column indexes.

Example 1:
Input:
map =
[
[0,0,1,0,0],
[0,0,0,0,0],
[0,0,0,1,0],
[1,1,0,1,1],
[0,0,0,0,0]
]
start = [0,4]
end = [3,2]
Output:
false
 * */
class Solution {
    /*
    * solution:BFS, let the node go through one direction to end and check if can reach destination,
    * Time complexity:O(mn), Space complexity:O(mn)
    * */
    fun hasPath(maze: Array<IntArray>, start: IntArray?, destination: IntArray?): Boolean {
        if (maze == null || start == null || destination == null) {
            return false
        }
        if (maze.isEmpty() || start.isEmpty() || destination.isEmpty()) {
            return false
        }
        val visited = HashSet<String>()
        val directions = intArrayOf(0, 1, 0, -1, 0)
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(start[0], start[1]))
        visited.add("${start[0]}-${start[1]}")
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            val x = cur.first
            val y = cur.second
            //check if reach to the destination, return result if can
            if (x == destination[0] && y == destination[1]) {
                return true
            }
            //check 4 directions
            for (d in 0 until 4) {
                var newX = x + directions[d]
                var newY = y + directions[d + 1]
                //go through one direction to the end
                while (isValidPath(newX, newY, maze)) {
                    newX += directions[d]
                    newY += directions[d + 1]
                }
                //move back a step
                newX -= directions[d]
                newY -= directions[d + 1]
                //put into queue to check in next level
                if (!visited.contains("$newX-$newY")) {
                    visited.add("$newX-$newY")
                    queue.offer(Pair(newX, newY))
                }
            }
        }
        return false
    }

    private fun isValidPath(x: Int, y: Int, maze: Array<IntArray>): Boolean {
        if (x >= 0 && x < maze.size && y >= 0 && y < maze[0].size && maze[x][y] == 0) {
            return true
        }
        return false
    }
}