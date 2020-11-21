package LeetCode_20

import java.util.*

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
 * */

class Solution {
    /*
    * solution 1: Stack, Time:O(n), Space:O(n)
    * */
    fun isValid(s: String): Boolean {
        val charStack = Stack<Char>()
        for (ch in s){
            if (ch=='(' || ch=='[' || ch=='{'){
                charStack.push(ch)
            } else {
                //如果({[都没进来
                if (charStack.size==0)
                    return false
                //keep tracking if parentheses match
                if (ch!=')' && charStack.lastElement()=='(')
                    return false
                if (ch!=']' && charStack.lastElement()=='[')
                    return false
                if (ch!='}' && charStack.lastElement()=='{')
                    return false
                charStack.pop()
            }
        }
        return charStack.isEmpty()
    }
}