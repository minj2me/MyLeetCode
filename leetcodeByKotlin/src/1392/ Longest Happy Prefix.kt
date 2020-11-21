package LeetCode_1392

/**
 * 1392. Longest Happy Prefix
 * https://leetcode.com/problems/longest-happy-prefix/
 *
 * A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
Given a string s. Return the longest happy prefix of s .
Return an empty string if no such prefix exists.

Example 1:
Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel").
The largest prefix which is also suffix is given by "l".

Example 2:
Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 * */
class Solution {
    /*
    * solution: KMP, find a prefix which also is a suffix,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun longestPrefix(s: String): String {
        if (s == null || s.isEmpty()) {
            return ""
        }
        val lpsTable = createLPSTable(s)
        val last = lpsTable[lpsTable.lastIndex]
        return if (last == 0) "" else s.substring(0, last)
    }

    /**
     * Create LPS table or pi table
     * */
    private fun createLPSTable(string: String): IntArray {
        var i = 1//i for scan string
        var j = 0//j from scan patten
        val m = string.length
        val lps = IntArray(m)
        lps[0] = 0//lps[0] is always 0
        //loop for i = 1 to m-1
        while (i < m) {
            if (string[i] == string[j]) {
                //if two char are same, move i,j
                lps[i] = j + 1
                i++
                j++
            } else {
                /*
                * if not the same, 2 situation:
                * 1. if (j==0), then cannot move j to left, move i to right, and update lps[i]
                * 2. if (j>0), move j to table[j-1]
                * */
                if (j == 0) {
                    lps[i] = j
                    i++
                } else {
                    j = lps[j - 1]
                }
            }
        }
        return lps
    }
}