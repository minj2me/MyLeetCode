/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/description/
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */

var root=null;

/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
    let m = board.length, n = board[0].length;
    let res=[];
    let map = new Map();
    var trie =new Trie();
    //var trie = Object.create(Trie).createNew()
    var trie =  Object.create(Trie.prototype);
    for (let w of words)
        trie.insert(w);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            search(board, i, j, "", trie,map)
        }
    }
    for (let m of map){
        res.push(m[0]);
    }
    return res;
};
var search = function (board, x, y, str, trie,map) {
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
        return;
    str = str + board[x][y];
    if (!trie.startsWith(str))
        return;
    if (trie.search(str)) {
        if (!map.has(str))
            map.set(str,str);
    }
        //set.push(str);
    let temp = board[x][y];
    board[x][y] = "#";
        search(board, x + 1, y, str, trie,map);
        search(board, x, y + 1, str, trie,map);
        search(board, x - 1, y, str, trie,map);
        search(board, x, y - 1, str, trie,map);
    board[x][y] = temp;
};

/** 
  * Your Trie object will be instantiated and called as such:
  * var obj = Object.create(Trie).createNew()
  * obj.insert(word)
  * var param_2 = obj.search(word)
  * var param_3 = obj.startsWith(prefix)
  */

var TireNode = function () {
    let isEnd = false;//links = {};
    //try array
    let arr = null;
    //Memory Limit Exceeded 
    return {
        getArr: function () {
            if (arr == null)
                arr = new Array(26);
            //console.log("arr:"+arr);
            return arr;
        },
        setEnd: function () {
            isEnd = true;
        },
        isEnd: function () {
            return isEnd;
        },
    };
};


/**
 * Initialize your data structure here.
 */
var Trie = function () {
    root = TireNode();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 * 
 */
Trie.prototype.insert = function (word) {
    let len = word.length;
    let node = root, ch;
    for (let i = 0; i < len; i++) {
        ch = word.charAt(i);
        let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        if (node.getArr()[index] == null || node.getArr()[index] == undefined) {
            let temp = new TireNode();
            node.getArr()[index] = temp;
            node = temp;
        } else
            node = node.getArr()[index];
    }
    node.setEnd();
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
    let node = searchPrefix(word);
    if (node == null)
        return false;
    else {
        if (node.isEnd())
            return true;
    }
    return false;

};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    //return searchPrefix(prefix) != null;
    let node = searchPrefix(prefix);
    return node == null ? false : true;
};

searchPrefix = function (prefix) {
    let len = prefix.length;
    let node = root, ch, index;
    for (let i = 0; i < len; i++) {
        ch = prefix.charAt(i);
        index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        //console.log("index:" + index);
        if (node.getArr()[index] != null)
            node = node.getArr()[index];
        else
            return null;
    }

    if (node == root)
        return null;

    return node;
};