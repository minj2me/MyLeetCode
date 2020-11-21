package LeetCode_554

/**
 * 554. Brick Wall
 * https://leetcode.com/problems/brick-wall/
 *
 * There is a brick wall in front of you.
 * The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the least bricks.
The brick wall is represented by a list of rows.
Each row is a list of integers representing the width of each brick in this row from left to right.
If your line go through the edge of a brick, then the brick is not considered as crossed.
You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:
Input:
[[1,2,2,1],
[3,1,2],
[1,3,2],
[2,4],
[3,1,2],
[1,3,1,1]]
Output: 2
 * */
class Solution {
    /*
    * solution: HashMap, calculate the break point of every row,
    * we split the wall from where the breakpoint occur most time, this must cross least brick,
    * Time complexity: O(mn), Space complexity:O(m)
    * */
    fun leastBricks(wall: List<List<Int>>): Int {
        if (wall == null || wall.isEmpty()) {
            return 0
        }
        //key: the breakpoint occur in which; value: breakpoint occur times
        val map = HashMap<Int, Int>()
        for (list in wall) {
            var width = 0
            for (i in 0 until list.size - 1) {//no need count the last brick
                width += list[i]
                //the brick count of current width
                val count = map.getOrDefault(width, 0)
                //update it
                map.put(width, count + 1)
            }
        }
        /*
        * {1=3, 2=1, 3=3, 4=4, 5=2} mean:
        * breakpoint in width 1 occur 3 times,
        * breakpoint in width 2 occur 1 time,
        * breakpoint in width 3 occur 3 time,
        * breakpoint in width 4 occur 4 time,
        * breakpoint in width 5 occur 2 time,
        * */
        //the maximum breakpoint
        var maxCount = 0
        for (item in map) {
            maxCount = Math.max(item.value, maxCount)
        }
        return wall.size - maxCount
    }
}