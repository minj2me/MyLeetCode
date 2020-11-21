package LeetCode_1092

import java.lang.StringBuilder

/**
 * 1092. Shortest Common Supersequence
 * https://leetcode.com/problems/shortest-common-supersequence/description/
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1092-shortest-common-supersequence/
 *
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 * If multiple answers exist, you may return any of them.
(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

Note:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
 * */
class Solution {
    /*
    * solution:dp, Time complexity:O(mn), Space complexity:O(mn)
    * 1.find the longest common sub sequence of two string
    * 2.insert non-lcs characters to the lcs find below
    * */
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val resSb = StringBuilder()
        //find the longest common sub sequence of two string
        val dp = getLcsDP(str1, str2)
        //insert non-lcs characters to the lcs find below
        var i = str1.length
        var j = str2.length
        val commonSb = StringBuilder()
        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--
            } else {
                commonSb.append(str1[i - 1])
                i--
                j--
            }
        }
        val newString = commonSb.toString().reversed()

        val newLen = newString.length
        val len1 = str1.length
        val len2 = str2.length
        i = 0
        j = 0
        for (k in 0 until newLen) {
            while (i < len1 && str1[i] != newString[k]) {
                resSb.append(str1[i++])
            }
            while (j < len2 && str2[j] != newString[k]) {
                resSb.append(str2[j++])
            }
            resSb.append(newString[k])
            i++
            j++
        }
        while (i < len1) {
            resSb.append(str1[i++])
        }
        while (j < len2) {
            resSb.append(str2[j++])
        }
        return resSb.toString()
    }

    private fun getLcsDP(str1: String, str2: String): Array<IntArray> {
        val m = str1.length
        val n = str2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp
    }
}