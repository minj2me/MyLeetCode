package LeetCode_516

/**
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.

Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters.
 * */
class Solution {

    /*
    * There are 2 solutions, evolve from Bruce Force to DP
    * */
    fun longestPalindromeSubseq(s: String): Int {
        //return solution1(s, 0, s.length - 1)
        val n = s.length
        val dp = Array(n + 1) { IntArray(n + 1) { -1 } }
        return solution2(s, 0, n - 1, dp)
    }

    /*
    * solution 1: Bruce Force, TLE, Time complexity:O(2^n), Space complexity:O(n)
    * */
    private fun solution1(s: String, i: Int, j: Int): Int {
        //there only one character
        if (i == j) {
            return 1
        }
        //there only two character
        if (s[i] == s[j] && (i + 1 == j)) {
            return 2
        }
        //if first and last match
        if (s[i] == s[j]) {
            //add 2 because there are have 2 character are equal
            return solution1(s, i + 1, j - 1) + 2
        }
        //if first and last do not match
        return Math.max(solution1(s, i + 1, j), solution1(s, i, j - 1))
    }

    /*
    * solution 2: DP, Top-Down, Memorization, Time complexity:O(n*n), Space complexity:O(n*n)
    * */
    private fun solution2(s: String, i: Int, j: Int, dp: Array<IntArray>): Int {
        if (i == j) {
            return 1
        }
        if (s[i] == s[j] && (i + 1 == j)) {
            return 2
        }
        if (dp[i][j] >= 0) {
            return dp[i][j]
        }
        var res = 0
        //if first and last match
        if (s[i] == s[j]) {
            //add 2 because there are have 2 character are equal
            res = solution2(s, i + 1, j - 1, dp) + 2
        } else {
            res = Math.max(solution2(s, i + 1, j, dp), solution2(s, i, j - 1, dp))
        }
        dp[i][j] = res
        return res
    }
}