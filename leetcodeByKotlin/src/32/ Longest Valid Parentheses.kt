package LeetCode_32

import java.util.*

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * https://www.cnblogs.com/springfor/p/3869495.html
 * https://www.cnblogs.com/grandyang/p/4424731.html
 *
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

Example 3:
()(())
 * */
class Solution {
    fun longestValidParentheses(s: String): Int {
        val stack = Stack<Int>()
        var start = 0
        var result = 0
        for (i in 0 until s.length) {
            if (s[i].equals('(')) {
                stack.push(i)
            } else {
                if (stack.isEmpty()) {
                    start = i + 1
                } else {
                    stack.pop()
                    if (stack.isEmpty()) {
                        result = Math.max(i - start + 1, result)
                    } else {
                        result = Math.max(i - stack.peek(), result)
                    }
                }
            }
        }
        return result
    }
}