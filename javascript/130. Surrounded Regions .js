/**
 * 130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/description/

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */

/**
* @param {character[][]} board
* @return {void} Do not return anything, modify board in-place instead.
*/
var solve = function (board) {
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            //just scan four borders
            if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O')
                solveDEF(board, i, j);
        }
    }
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] == 'O')
                board[i][j] = 'X';
            if (board[i][j] == '$')
                board[i][j] = 'O';
        }
    }
    //console.log(board);
    return board;
};

var solveDEF = function (board, x, y) {
    if (board[x][y] == 'O') {
        // console.log("x:"+x);
        // console.log("y:"+y);
        board[x][y] = '$';
        if (x > 0 && board[x - 1][y] == 'O') {
            console.log("x>0");
            this.solveDEF(board, x - 1, y);
        }
        if (y < board[x].length - 1 && board[x][y + 1] == 'O') {
            console.log("y< board[x].length - 1");
            this.solveDEF(board, x, y + 1);
        }
        if (x < board.length - 1 && board[x + 1][y] == 'O') {
            console.log("x< board.length - 1");
            this.solveDEF(board, x + 1, y);
        }
        if (y > 0 && board[x][y - 1] == 'O') {
            console.log("y>0");
            this.solveDEF(board, x, y - 1);
        }
    }
}