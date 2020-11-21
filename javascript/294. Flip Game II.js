/**
 *  * Lock by leetcode
 * 294. Flip Game II
 * https://www.lintcode.com/problem/flip-game-ii/description
 * https://www.cnblogs.com/grandyang/p/5226206.html
 * 
 * You are playing the following Flip Game with your friend: 
 * Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
Write a function to determine if the starting player can guarantee a win.

Example
Given s = "++++", return true.

Explanation:
The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Challenge
Derive your algorithm's runtime complexity.
 */
/**
 * @param s: the given string
 * @return: if the starting player can guarantee a win
 */
const canWin = function (s) {
    if (s == "")
        return false;
    for (let i = 1; i < s.length; i++) {
        if (s[i] == "+" && s[i - 1] == "+" && !canWin(s.substring(0, i - 1) + "--" + s.substring(i + 1))) {
            //if there is a flip which makes the other player lose, the first play wins
            return true;
        }
    }
    return false;
}
