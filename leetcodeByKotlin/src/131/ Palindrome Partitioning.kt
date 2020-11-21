package LeetCode_131

/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
["aa","b"],
["a","a","b"]
]
 * */
class Solution {
    private val result = ArrayList<ArrayList<String>>()
    /*
    * backtracking, Time complexity:O(2^n), Space complexity:O(n)
    * */
    fun partition(s: String): List<List<String>> {
        backtracking(0, s, ArrayList())
        return result
    }

    private fun backtracking(start: Int, s: String, cur: ArrayList<String>) {
        val n = s.length
        if (start == n) {
            val temp = ArrayList<String>(cur)
            result.add(temp)
            return
        }
        for (i in start until n) {
            //if s[start,i] is not palindrome, just go to s[start,i+1]
            if (!isPalindrome(s, start, i)) {
                continue
            }
            cur.add(s.substring(start,i+1))
            backtracking(i + 1, s, cur)
            cur.removeAt(cur.size - 1)
        }
    }

    private fun isPalindrome(s: String, i_: Int, j_: Int): Boolean {
        var i = i_
        var j = j_
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }
}