package LeetCode_394

import java.util.*

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/description/
 *
 * Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for
those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
 * */
class Solution {
    /*
    * solution: two stack, one for save Int, and one for save letter,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun decodeString(s: String): String {
        val intStack = Stack<Int>()
        val stringStack = Stack<String>()
        var i = 0
        var res = ""
        while (i < s.length) {
            val c = s[i]
            if (c.isDigit()) {
                //keep checking the digits of current number, for example: 32c, need get 32
                var number = 0
                while (s[i].isDigit()) {
                    number = number * 10 + (s[i]-'0')
                    i++
                }
                intStack.add(number)
            } else if (c == '[') {
                //if opening brackets, save the string create before,
                //for example: 3[a2[c]], need save string create from a2[c]
                stringStack.add(res)
                res = ""
                i++
            } else if (c == ']') {
                //set up the result string, for example a2[c], append a first
                val sb = StringBuilder()
                sb.append(stringStack.pop())
                //get loop count from intStack
                val count = intStack.pop()
                for (j in 0 until count) {
                    sb.append(res)//like acc
                }
                //update the res
                res = sb.toString()
                i++
            } else {
                //if a letter
                res += c
                i++
            }
        }
        return res
    }
}