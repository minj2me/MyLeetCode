package LeetCode_10

/**
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'.Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * */
class Solution {
    /*
    * solution: recursion, Time complexity:O(n*n), Space complexity:O(n*n)
    * n is min(s.length, p.length)
    * */
    fun isMatch(s: String, p: String): Boolean {
        if (p == null || p.isEmpty()) {
            return s.isEmpty()
        }
        if (s == p) {
            return true
        }
        if (p.length >= 2 && p[1] == '*') {
            //if p's second character is *, so p can match any number of character before *
            if (isMatch(s, p.substring(2))) {
                //check remaining character
                return true
            }
            //otherwise, check first character match or not
            if (s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')) {
                return isMatch(s.substring(1), p)
            }
        } else if (s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')) {
            //need check character one by one
            return isMatch(s.substring(1), p.substring(1))
        }
        return false
    }

    /*private var memo: BooleanArray? = null
    private fun dfs(sChar: CharArray, pChar: CharArray, i: Int, j: Int): Boolean {
        if (memo!![i + 1]) {
            return true
        }
        if (i == -1 && j == -1) {
            memo!![i + 1] = true
            println("return true")
            return true
        }
        println("i:$i")
        println("j:$j")
        var isFirstMatching = false
        //check the first character

        if (i >= 0 && j >= 0 && (sChar[i] == pChar[j] || pChar[j] == '.'
                    || (pChar[j] == '*' && (pChar[j - 1] == pChar[i] || pChar[j - 1] == '.')))
        ) {
            isFirstMatching = true
        }
        println("isFirstMatching:$isFirstMatching")
        if (j >= 1 && pChar[j] == '*') {
            //check s[0..i] and p[0..j-2]
            val zero = dfs(sChar, pChar, i, j - 2)
            println("zero:$zero")
            //check s[0..i-1] and p[0..j]
            val match = isFirstMatching && dfs(sChar, pChar, i - 1, j)
            println("match:$match")
            if (zero || match) {
                memo!![i + 1] = true
            }
            return memo!![i + 1]
        }

        //check s[0..i-1] and p[0..j-1]
        if (isFirstMatching && dfs(sChar, pChar, i - 1, j - 1)) {
            memo!![i + 1] = true
        }
        return memo!![i + 1]
    }*/
}