package LeetCode_125

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

Constraints:
s consists only of printable ASCII characters.
 * */
class Solution {
    /*
    * solution: two pointer, Time complexity:O(n), Space complexity:O(n)
    * */
    fun isPalindrome(s: String): Boolean {
        val newString = StringBuilder()
        for (c in s) {
            if (c.isLetter() || c.isDigit()) {
                newString.append(c)
            }
        }
        val i = 0
        val j = newString.length-1
        return checkPalindrome(newString.toString(),i,j)
    }

    private fun checkPalindrome(s: String, i_: Int, j_: Int): Boolean {
        var i = i_
        var j = j_
        while (i < j) {
            if (s[i].toLowerCase() != s[j].toLowerCase()) {
                return false
            }
            i++
            j--
        }
        return true
    }
}