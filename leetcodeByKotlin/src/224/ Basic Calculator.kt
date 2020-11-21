package LeetCode_224

import java.util.*

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:
Input: "1 + 1"
Output: 2

Example 2:
Input: " 2-1 + 2 "
Output: 3

Example 3:
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 * */
class Solution {
    /*
    * solution: Stack, Time:O(n), Space:O(n)
    * */

    private val operator = listOf("+", "-")

    fun calculate(s: String): Int {
        val stack = Stack<String>()
        var i = s.length - 1
        //scan from right to left
        while (i >= 0) {
            if (s[i] == ' ') {
                //if space, skip it
                i--
                continue
            }
            if (s[i] == ')' || s[i] == '+' || s[i] == '-') {
                stack.push(s[i].toString())
            } else if (s[i] == '(') {
                val sum = getSum(stack)
                //pop the right parentheses
                stack.pop()
                //push current sum in stack
                stack.push(sum.toString())
            } else {
                val intSB = StringBuilder()
                //pick out the digit, for example:10
                while (i >= 0 && s[i].isDigit()) {
                    intSB.insert(0, s[i--])
                }
                //prevent lose some operator, so need go back, for example: 2-1 + 2
                i++
                //push current sum in stack
                stack.push(intSB.toString())
            }
            i--
        }
        //result = getSum(stack)
        return getSum(stack)
    }

    private fun getSum(stack: Stack<String>): Int {
        var sign = "+"
        var total = 0
        while (stack.isNotEmpty() && stack.peek() != "(" && stack.peek() != ")") {
            if (stack.peek() in operator) {
                sign = stack.pop()
            } else {
                //when meet digit
                val temp = stack.pop().toInt()
                //check need + or -
                total += if (sign == "+") temp else -temp
            }
        }
        return total
    }

}