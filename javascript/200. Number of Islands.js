/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 */
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    // 88 ms
    let count = 0;
    if (grid == null || grid[0] == null)
        return 0;
    let m = grid.length, n = grid[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == "0")
                continue;
            count++;
            numIslandsDFS(grid, i, j);
        }
    }
    console.log(count);
    return count;
};
var numIslandsDFS = function (grid, i, j) {
    if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
        return;
    if (grid[i][j] == "1") {
        grid[i][j] = "0";
        //check top,left,right,bottom
        numIslandsDFS(grid, i, j - 1);
        numIslandsDFS(grid, i - 1, j);
        numIslandsDFS(grid, i + 1, j);
        numIslandsDFS(grid, i, j + 1);
    }
};