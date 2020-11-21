package LeetCode_71

import java.util.*

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/description/
 *
 * Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 * */
class Solution {
    fun simplifyPath(path: String): String {
        if (path.equals("")) {
            return path
        }
        val stack = Stack<String>()
        val list = path.split("/")
        for (item in list) {
            if (item != "." && item != ".." && item != "") {
                stack.push(item)
            } else if (stack.isNotEmpty() && item == "..") {
                stack.pop()//remove the top element while meet two point
            }
        }
        return "/" + stack.joinToString("/")
    }
}