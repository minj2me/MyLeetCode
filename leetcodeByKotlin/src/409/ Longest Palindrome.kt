package LeetCode_409

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 *
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1

Example 3:
Input: s = "bb"
Output: 2

Constraints:
1. 1 <= s.length <= 2000
2. s consits of lower-case and/or upper-case English letters only.
 * */
class Solution {
    /*
    * solution: array, calculate the odd count, Time complexity:O(n), Space complexity:O(128)
    * */
    fun longestPalindrome(s: String): Int {
        val array = IntArray(128)
        //'a': ascii is 97
        //'A': ascii is 65
        for (c in s) {
            if (c - 'a' >= 97) {
                //a..z
                array[c - 'a']++
            } else {
                //A..Z
                array[c - 'A']++
            }
        }
        //scan array, calculate the odd count
        var oddCount = 0
        for (i in array.indices) {
            if (array[i] % 2 != 0) {
                oddCount++
            }
        }
        if (oddCount > 1) {
            /*
            * for example: abccccdd, a,b the number of occurrence time is odd, so we can build these string:
            * dccaccd or dccbccd, both length are 7
            * */
            return s.length - oddCount + 1
        } else {
            //here main all char can use to build
            return s.length
        }
    }
}