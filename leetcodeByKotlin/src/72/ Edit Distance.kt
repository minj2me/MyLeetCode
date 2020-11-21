package LeetCode_72

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
1.Insert a character
2.Delete a character
3.Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 * */
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        //method 1:Time complexity is O(3^m), Space complexity is O(m*n),
        //because has overlapping sub problems, for example editDistance(str1,str2,1,1) will call more time
        val m = word1.length
        val n = word2.length
        //return editDistance(word1, word2, m, n)
        //method 2: dp, Time complexity is O(m*n), Space complexity is O(m*n),
        return editDistanceDP(word1, word2, m, n)
    }

    private fun editDistanceDP(str1: String, str2: String, m: Int, n: Int): Int {
        val dp = Array(m + 1) { Array(n + 1, { 0 }) }
        /*
        There are following two different ways to store the values so that these values can be reused:
        * a) Memoization (Top Down)
          b) Tabulation (Bottom Up)
          https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
        * */
        //fill dp array by bottom up manner
        for (i in 0 .. m) {
            for (j in 0 .. n) {
                //if first string is empty,
                if (i == 0) {
                    dp[i][j] = j
                } else if (j == 0) {
                    //the second string is empty,
                    dp[i][j] = i
                } else if (str1[i - 1] == str2[j - 1]) {
                    //if last character of two string are same, ignore last character
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + Math.min(
                        //insert and remove
                        Math.min(dp[i][j-1], dp[i-1][j])
                        //replace
                        , dp[i - 1][j - 1]
                    )
                }
            }
        }
        return dp[m][n]
    }

    private fun editDistance(str1: String, str2: String, m: Int, n: Int): Int {
        //if first string is empty,
        //the only option is insert into all chars of second string into the first
        if (m == 0) {
            return n
        }
        if (n == 0) {
            return m
        }
        //if last character of two string are same, ignore last character
        if (str1[m - 1] == str2[n - 1]) {
            return editDistance(str1, str2, m - 1, n - 1)
        }
        //compute minimum cost for all three operations
        return 1 + Math.min(
            //insert and remove
            Math.min(editDistance(str1, str2, m, n - 1), editDistance(str1, str2, m - 1, n)),
            //replace
            editDistance(str1, str2, m - 1, n - 1)
        )
    }
}