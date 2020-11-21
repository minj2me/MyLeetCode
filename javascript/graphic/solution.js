/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    let count = 0;
    if (grid == null || grid[0] == null)
        return 0;
    let m = grid.length, n = grid[0].length;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            //console.log("grid["+i+"]["+j+"]: "+grid[i][j]);      
            if (grid[i][j] == "0")
                continue;
            //如果是1,将它下沉,也check它上左右下
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

/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/description/
 * @param {number[][]} grid
 * @return {number}
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,1,1,0,1,0,0,0,0,0,0,0,0],
    [0,1,0,0,1,1,0,0,1,0,1,0,0],
    [0,1,0,0,1,1,0,0,1,1,1,0,0],
    [0,0,0,0,0,0,0,0,0,0,1,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 return 6
 */
var maxAreaOfIsland = function (grid) {
    //96ms
    let m = grid.length, n = grid[0].length;
    if (m == 0 || n == 0)
        return 0;
    let maxCount = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            // let count = maxAreaOfIslandDFS(grid, i, j);
            // if (count > maxCount)
            //     maxCount = count;
            maxCount = Math.max(maxCount, maxAreaOfIslandDFS(grid, i, j));
        }
    }
    console.log(maxCount);
    return maxCount;
};
var maxAreaOfIslandDFS = function (grid, x, y) {
    // if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0)
    //     return count_;
    // let count = count_;
    // if (grid[x][y] == 1) {
    //     grid[x][y] = 0;//mark it visited
    //     count++;
    //     //return the new count each time
    //     count = maxAreaOfIslandDFS(count, grid, x, y - 1);
    //     count = maxAreaOfIslandDFS(count, grid, x - 1, y);
    //     count = maxAreaOfIslandDFS(count, grid, x + 1, y);
    //     count = maxAreaOfIslandDFS(count, grid, x, y + 1);
    // }
    // return count;
    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0) {
        grid[x][y] = 0;
        return 1 + maxAreaOfIslandDFS(grid, x + 1, y) + maxAreaOfIslandDFS(grid, x - 1, y) + maxAreaOfIslandDFS(grid, x, y + 1) +
            maxAreaOfIslandDFS(grid, x, y - 1);
    }
    return 0;
};

/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/description/
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function (grid) {
    //256ms!!
    let m = grid.length, n = grid[0].length;
    if (m == 0 || n == 0)
        return 0;
    let perimeter = 0;
    for (let x = 0; x < m; x++) {
        for (let y = 0; y < n; y++) {
            if (grid[x][y] == 0)
                continue;
            //set had 4 default
            perimeter += 4;
            //只需判断上，左是否为1就可以了(我想因为坐标的原因，不要用右下来判断)，如是就减2；不用重复判断
            if (y > 0 && grid[x][y - 1] == 1)//上
                perimeter -= 2;
            if (x > 0 && grid[x - 1][y] == 1)
                perimeter -= 2;
        }
    }
    console.log(perimeter);
    return perimeter;
};

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
    if (word == "")
        return false;
    let m = board.length, n = board[0].length;
    for (let x = 0; x < m; x++) {
        for (let y = 0; y < n; y++) {
            if (search(board, x, y, 0, word)) {
                return true;
            }
        }
    }
    //console.log(result);
    return false;
};
var search = function (board, x, y, index, word) {
    if (x < 0 || y < 0 || x >= board.length ||
        y >= board[0].length || board[x][y] != word.charAt(index))
        return false;
    console.log("index:" + index);
    console.log("word.length:" + word.length);
    //found the last chat of the word
    if (index == word.length - 1)
        return true;
    //search left,top,right,bottom
    let temp = board[x][y];
    board[x][y] = '#';//set visited
    let result = search(board, x - 1, y, index + 1, word) ||
        search(board, x, y - 1, index + 1, word) ||
        search(board, x + 1, y, index + 1, word) ||
        search(board, x, y + 1, index + 1, word);
    board[x][y] = temp;//reset for next scan
    //console.log(board);
    return result;
};