/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/description/
 * https://www.cnblogs.com/grandyang/p/4539768.html
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
    let wordSet = new Set();
    for (let i = 0; i < wordList.length; i++) {
        wordSet.add(wordList[i]);
    }
    if (!wordSet.has(beginWord) && !wordSet.has(endWord))
        return 0;
    //console.log(wordSet);
    let visit = {}, tempNode = null;
    let charArr = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
    let tempStr = "", curStr = "";
    let q = [];
    let curNode = new node(beginWord, 1);
    visit[curNode.str] = true;
    q.push(curNode);

    while (q.length > 0) {
        curNode = q.shift();
        curStr = curNode.str;
        console.log("curStr:" + curStr);
        for (let i = 0; i < beginWord.length; i++) {
            for (let j = 0; j < charArr.length; j++) {
                if (charArr[j] == curStr.charAt(i))
                    continue;
                tempStr = curStr.substring(0, i) + charArr[j] + curStr.substring(i + 1, beginWord.length);
                if (tempStr == endWord)
                    return curNode.step + 1;
                if (wordSet.has(tempStr) && !visit.hasOwnProperty(tempStr)) {
                    visit[tempStr] = true;
                    tempNode = new node(tempStr, curNode.step + 1);
                    q.push(tempNode);
                }
            }
        }
    }
    return 0;
};
