/**
 * 554. Brick Wall
 * https://leetcode.com/problems/brick-wall/description/
 * https://www.cnblogs.com/grandyang/p/6697067.html
 * 
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. 
 * The bricks have the same height but different width. 
 * You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. 
Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. 
You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks

Input: [[1,2,2,1],
        [3,1,2],
        [1,3,2],
        [2,4],
        [3,1,2],
        [1,3,1,1]]

Output: 2

{1 => 3}
{3 => 3}
{5 => 2}
{4 => 4}
{2 => 1}
长度为4的断点出现4次，次数为最多，就是从这里切下损坏的板砖为最少
 */
/**
 * @param {number[][]} wall
 * @return {number}
 */
var leastBricks = function (wall) {
    let map = new Map();
    for (let i = 0; i < wall.length; i++) {
        let long = 0;
        //我们使用一个哈希表来建立每一个断点的长度和其出现频率之间的映射，这样只要我们从断点频率出现最多的地方劈墙，损坏的板砖一定最少
        //length-1是为了不计最后的边
        for (let j = 0; j < wall[i].length - 1; j++) {
            long += wall[i][j];
            if (map.get(long) == undefined)
                map.set(long, 1);
            else
                map.set(long, map.get(long) + 1);
        }
    }
    let max = 0;
    for (let m of map) {
        max = Math.max(max, m[1]);
    }
    return max;
};