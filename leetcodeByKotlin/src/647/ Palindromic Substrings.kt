package LeetCode_647

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:
1. The input string length won't exceed 1000.
 * */
class Solution {
    /*
    * solution: check the palindrome of odd length palindromic substring and even length palindromic substring,
    * for example: aabaa, checking:
     loop 1. center on a and aa, scan to left and right,
     2. center on a and ab, scan to left and right,
     3. center on b and ba, scan to left and right,

    * Time complexity:O(n^2), Space complexity:O(1)
    * */

    private var count = 0

    fun countSubstrings(s: String): Int {
        if (s == null || s.isEmpty()) {
            return 0
        }
        for (i in s.indices) {
            //check odd length
            checkPalindrome(s, i, i)
            //check even length
            checkPalindrome(s, i, i + 1)
        }
        return count
    }

    private fun checkPalindrome(string: String, i_: Int, j_: Int) {
        var i = i_
        var j = j_
        while (i >= 0 && j < string.length && string[i] == string[j]) {
            //if substring is palindrome
            count++
            //to trace string in left direction
            i--
            //to trace string in right direction
            j++
        }
    }
}