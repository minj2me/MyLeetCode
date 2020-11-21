package LeetCode_1021

import java.util.*

/**
 * 1021. Remove Outermost Parentheses
 * https://leetcode.com/problems/remove-outermost-parentheses/
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string concatenation.
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B,
with A and B nonempty valid parentheses strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k,
where P_i are primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Example 1:
Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:
Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:
Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 * */
class Solution {
    /*
    * solution: Stack, heep to keep tracking ( or ) if outermost,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun removeOuterParentheses(S: String): String {
        if (S == "") {
            return ""
        }
        val stack = Stack<Char>()
        val sb = StringBuilder()
        for (c in S) {
            if (c == '(') {
                //if stack not empty and current is (, this one is not outermost, add into result
                if (stack.isNotEmpty()) {
                    sb.append(c)
                }
                stack.push(c)
            } else {
                stack.pop()
                if (stack.isNotEmpty()){
                    sb.append(c)
                }
            }
        }
        return sb.toString()
    }
}