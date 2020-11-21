package LeetCode_1143

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters.
(eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Constraints:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 * */
class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        //return dp(text1, text2)
        val dp = Array(m + 1) { IntArray(n + 1) { -1 } }
        return dp2(text1, text2, m, n, dp)
    }

    /**
     * solution 1:dfs, Time complexity:O(2^n), Space complexity:O(n*m)
     * TLE
     * */
    private fun dfs(str1: String, str2: String, m: Int, n: Int): Int {
        if (m == 0 || n == 0) {
            return 0
        }
        if (str1[m - 1] == str2[n - 1]) {
            return 1 + dfs(str1, str2, m - 1, n - 1)
        } else {
            return Math.max(dfs(str1, str2, m - 1, n), dfs(str1, str2, m, n - 1))
        }
    }

    /*
    * solution 2: DP: Memorization, Top-Down; Time complexity(mn), Space complexity:O(mn)
    * */
    private fun dp2(str1: String, str2: String, m: Int, n: Int, dp: Array<IntArray>): Int {
        if (m == 0 || n == 0) {
            return 0
        }
        if (dp[m][n] >= 0) {
            return dp[m][n]
        }
        var ans = 0
        if (str1[m - 1] == str2[n - 1]) {
            ans = 1 + dp2(str1, str2, m - 1, n - 1, dp)
        } else {
            ans = Math.max(dp2(str1, str2, m - 1, n, dp), dp2(str1, str2, m, n - 1, dp))
        }
        dp[m][n] = ans
        return ans
    }

    /**
     * solution 2:dynamic programing (dp)
     * Time complexity:O(m*n), Space complexity:O(m*n)
     * */
    private fun dp(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        //fill first row
        for (col in 0 until n) {
            //because we set the element in first row and first cols is ""
            //so with "", the common length is 0, the same as below dp[row][0]
            dp[0][col] = 0
        }
        //fill first col
        for (row in 0 until m) {
            //because we set the element in first row and first cols is ""
            dp[row][0] = 0
        }
        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[m][n]
    }
}