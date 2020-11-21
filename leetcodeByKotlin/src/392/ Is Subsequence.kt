package LeetCode_392

/**
 * 392. Is Subsequence
https://leetcode.com/problems/is-subsequence/description/

Given a string s and a string t, check if s is subsequence of t.
You may assume that there is only lower case English letters in both s and t.
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"
Return true.
 * */
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var x = 0
        var y = 0
        while (s.length > x && t.length > y) {
            if (s[x] == t[y]) {
                x++
            }
            y++
        }
        return x == s.length
    }
}