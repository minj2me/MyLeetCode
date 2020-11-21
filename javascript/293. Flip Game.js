/**
 * Lock by leetcode
 * 293. Flip Game
 * https://www.lintcode.com/problem/flip-game/description
 * 
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
 * you and your friend take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example
Given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
 */

/**
* @param s: the given string
* @return: all the possible states of the string after one valid move
*/
const generatePossibleNextMoves = function (s) {
  let result = [];
  for (let i = 1; i < s.length; i++) {
    if (s[i] == "+" && s[i - 1] == "+") {
      //s.substring 如果省略stop参数，那么返回的子串会一直到字符串的结尾
      result.push(s.substring(0, i - 1) + "--" + s.substring(i + 1));
    }
  }
  return result;
}