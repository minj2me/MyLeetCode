package LeetCode_489

/**
 * 489. Robot Room Cleaner
 * (Prime)
 * Given a robot cleaner in a room modeled as a grid.
Each cell in the grid can be empty or blocked.
The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
Design an algorithm to clean the entire room using only the 4 given APIs shown below.
interface Robot {
// returns true if next cell is open and robot moves into the cell.
// returns false if next cell is obstacle and robot stays on the current cell.
boolean move();
// Robot will stay on the same cell after calling turnLeft/turnRight.
// Each turn will be 90 degrees.
void turnLeft();
void turnRight();
// Clean the current cell.
void clean();
}
Example:
Input:
room = [
[1,1,1,1,1,0,1,1],
[1,1,1,1,1,0,1,1],
[1,0,1,1,1,1,1,1],
[0,0,0,1,0,0,0,0],
[1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.

Notes:
1. The input is only given to initialize the room and the robot's position internally.You must solve this problem "blindfolded".
In other words, you must control the robot using only the mentioned 4 APIs,
without knowing the room layout and the initial robot's position.
2. The robot's initial position will always be in an accessible cell.
3. The initial direction of the robot will be facing up.
4. All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
5. Assume all four edges of the grid are all surrounded by wall.
 * */

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    fun move(): Boolean

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft()

    fun turnRight()
    // Clean the current cell.
    fun clean()
}

/*
* solution: DFS + Backtracking, Time complexity:O(mn), Space complexity:O(mn)
* */
class Solution {

    val directions = intArrayOf(0, 1, 0, -1, 0)

    fun cleanRoom(robot: Robot) {
        val visited = HashSet<String>()
        //start from 0,0 and facing up
        dfs(robot, 0, 0, directions[0], visited)
    }

    private fun dfs(robot: Robot, x: Int, y: Int, direction: Int, visited: HashSet<String>) {
        //execute clean while reach some place
        robot.clean()
        val key = "$x-$y"
        visited.add(key)
        //try 4 directions in clockwise: 0->up, 1->right, 2->down, 3->left
        for (i in 0 until 4) {
            //keep cur in 0-4
            val cur = (i + direction) % 4
            val newX = x + directions[cur]
            val newY = y + directions[cur + 1]
            //check new x,y if not visited and can move to
            if (!visited.contains("$newX-$newY") && robot.move()) {
                dfs(robot, newX, newY, cur, visited)
                //do below like backtracking
                //turn 180 degree to back to former cell
                robot.turnRight()
                robot.turnRight()
                robot.move()
                //turn 180 degree to back to init facing direction
                robot.turnRight()
                robot.turnRight()
            }
            //when after doing up to the end
            //update robot facing direction to right, because init is facing up
            robot.turnRight()
        }
    }
}