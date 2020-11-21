package LeetCode_301

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/**
 * 301. Remove Invalid Parentheses
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(2^n), Space complexity:O(2^n)
    * */
    fun removeInvalidParentheses(s: String): List<String> {
        val result = ArrayList<String>()
        val visited = HashSet<String>()
        val queue = LinkedList<String>()
        queue.offer(s)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (visited.contains(cur)) {
                continue
            }
            visited.add(cur)
            if (isValidParenthese(cur)) {
                result.add(cur)
            }
            //if found in this level, no need to loop again
            if (result.size != 0) {
                continue
            }
            for (i in cur.indices) {
                if (cur[i] == '(' || cur[i] == ')') {
                    /*
                    check every children
                    * for example:()())(),
                    * children: remove first '('=>)())()
                    * remove the second:')'=>(())()
                    * */
                    val children = cur.substring(0, i) + cur.substring(i + 1, cur.length)
                    queue.offer(children)
                }
            }
        }
        //println(result)
        return result
    }

    private fun isValidParenthese(s: String): Boolean {
        var count = 0
        for (c in s) {
            if (c == '(') {
                count++
            } else if (c == ')') {
                count--
            }
            if (count < 0) {
                return false
            }
        }
        return count == 0
    }
}