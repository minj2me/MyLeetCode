/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function (obstacleGrid) {
    let result = new Array(1).fill(0);
    this.dfs(0, 0, obstacleGrid, result);
    return result[0];
};
var dfs = function (i, j, obstacleGrid, result) {
    let m = obstacleGrid.length, n = obstacleGrid[0].length;
    if (i >= m || j >= n)
        return;
    if (obstacleGrid[i][j] == 1)
        return;
    if ((i == m - 1) && (j == n - 1))
        result[0] += 1;
    this.dfs(i + 1, j, obstacleGrid, result);
    this.dfs(i, j + 1, obstacleGrid, result);
};