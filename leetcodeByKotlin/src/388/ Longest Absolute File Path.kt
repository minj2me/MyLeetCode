package LeetCode_388

import java.util.*
/**
 * 388. Longest Absolute File Path
 * https://leetcode.com/problems/longest-absolute-file-path/description/
 *
 * We will represent the file system as a string where "\n\t" mean a subdirectory of the main directory,
 * "\n\t\t" means a subdirectory of the subdirectory of the main directory and so on.
 * Each folder will be represented as a string of letters and/or digits.
 * Each file will be in the form "s1.s2" where s1 and s2 are strings of letters and/or digits.
For example,
the file system above is represented as "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".
Given a string input representing the file system in the explained format,
return the length of the longest absolute path to a file in the abstracted file system.
If there is no file in the system, return 0.

Constraints:
1. 1 <= input.length <= 104
2. input may contain lower-case or upper-case English letters, a new line character '\n',
a tab character '\t', a dot '.', a space ' ' or digits.
 * */
class Solution {
    /*
    * solution: Stack, save all the length of candidate in stack, Time complexity:O(n), Space complexity:O(n)
    * */
    fun lengthLongestPath(input: String): Int {
        var result = 0
        //save all the length
        val stack = Stack<Int>()
        val stringList = input.split("\n")
        for (path in stringList) {
            //last index of \t is current line's level
            val level = path.lastIndexOf("\t") + 1
            //try to find its parent, when stack size == level, the pop one is parent
            while (stack.size > level) {
                stack.pop()
            }
            val parent = if (stack.isEmpty()) 0 else stack.peek() + 1
            //push a new candidate
            val newLen = parent + path.length - level
            stack.push(newLen)
            //if is file
            if (path.contains(".")) {
                result = Math.max(result, newLen)
            }
        }
        return result
    }

}