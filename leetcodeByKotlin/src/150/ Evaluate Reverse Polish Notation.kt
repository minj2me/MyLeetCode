package LeetCode_150

import java.util.*

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:
Division between two integers should truncate toward zero.
The given RPN expression is always valid.
That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 * */
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        /*
        * Time complexity:O(n), Space complexity:O(1)
        * */
        val stack = Stack<Int>()
        val operators = listOf("+", "-", "*", "/")
        for (item in tokens) {
            if (item in operators) {
                val top2 = stack.pop()
                val top1 = stack.pop()
                var n = 0
                when (item) {
                    "+" -> {
                        n = top1 + top2
                    }
                    "-" -> {
                        n = top1 - top2
                    }
                    "*" -> {
                        n = top1 * top2
                    }
                    "/" -> {
                        n = top1 / top2
                    }
                }
                //push into stack to prepare for next calculate
                stack.push(n)
            } else {
                stack.add(item.toInt())
            }
        }
        return stack.peek()
    }
}