package LeetCode_227

import java.util.*

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces.
The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5
 * */
class Solution {
    fun calculate(s: String): Int {
        val n = s.length
        val stack = Stack<Int>()
        var num = 0
        var sign = '+'
        for (i in s.indices) {
            val cur = s[i]
            if (cur.isDigit()) {
                num = num * 10 + (cur.toInt() - '0'.toInt())
            }
            //i==n-1, means when it comes to tail of string, need to do the last calculation.
            if (!cur.isDigit() && cur != ' ' || i == n - 1) {
                when (sign) {
                    '+' -> stack.push(num)
                    '-' -> stack.push(-num)
                    '*' -> stack.push(stack.pop() * num)
                    '/' -> stack.push(stack.pop() / num)
                }
                sign = cur
                //reset num after calculation
                num = 0
            }
        }
        return stack.sum()
    }
}