package LeetCode_680

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * */
class Solution {
    //Time complexity:O(n)
    fun validPalindrome(s: String): Boolean {
        val n = s.length
        var l = 0
        var r = n-1
        while (l < r && s[l] == s[r]) {
            l++
            r--
        }
        //if left,right char is not equal, either delete one char in left or delete one char in right and check again
        return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)
    }

    private fun isPalindrome(str: String, l_: Int, r_: Int): Boolean {
        var l = l_
        var r = r_
        while (l < r) {
            if (str[l] != str[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }
}