/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/description/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
    //76 ms
    if (word == "")
        return false;
    let m = board.length, n = board[0].length;
    for (let x = 0; x < m; x++) {
        for (let y = 0; y < n; y++) {
            //result = existHelper(board,x,y,0,word,matchedWrod);
            if (search(board, x, y, 0, word)) {
                return true;
            }
        }
    }
    //console.log(result);
    return false;
};

var search = function (board, x, y, index, word) {
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index))
        return false;
    if (index == word.length - 1)
        return true;
    //search left,top,right,bottom
    let temp = board[x][y];
    board[x][y] = '#';
    let result =
        search(board, x - 1, y, index + 1, word) ||
        search(board, x, y - 1, index + 1, word) ||
        search(board, x + 1, y, index + 1, word) ||
        search(board, x, y + 1, index + 1, word);
    board[x][y] = temp;//backtracking,set back the temp
    return result
}