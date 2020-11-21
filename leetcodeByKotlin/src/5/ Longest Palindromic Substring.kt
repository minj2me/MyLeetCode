package LeetCode_5

/**
 * 5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
 * */
class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty() || s.length == 1) {
            return s
        }
        var longest = ""
        val length = s.length
        for (i in 0 until length) {
            val s1 = getPalindrome(s, i, i)
            if (longest.length < s1.length) {
                longest = s1
            }
            val s2 = getPalindrome(s, i, i + 1)
            if (longest.length < s2.length) {
                longest = s2
            }
        }
        //println(longest)
        return longest
    }

    private fun getPalindrome(s: String, i_: Int, j_: Int): String {
        var i = i_
        var j = j_
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            //scan from middle to left
            i--
            //scan from middle to right
            j++
        }
        return s.substring(i+1, j)
    }
}