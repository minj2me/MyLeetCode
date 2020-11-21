package LeetCode_844

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/description/
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
 * */
class Solution {
    fun backspaceCompare(S: String, T: String): Boolean {
        val l1 = S.length
        val l2 = T.length
        if (l1 == 0 && l2 == 0) {
            return true
        }
        return check(S) == check(T)
    }

    private fun check(s: String): String {
        val sb = StringBuilder()
        for (c in s) {
            if (c == '#') {
                if (sb.isNotEmpty()) {
                    sb.deleteCharAt(sb.length - 1)
                }
            } else {
                sb.append(c)
            }
        }
        //println(sb.toString())
        return sb.toString()
    }
}