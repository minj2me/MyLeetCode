package LeetCode_345

/**
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 * */
class Solution {
    /*
   * Time:O(n), Space:O(1)
   * */
    fun reverseVowels(s: String): String {
        if (s == null || s.isEmpty()) {
            return ""
        }
        val vowels = "aeiouAEIOU"
        val chars = s.toCharArray()
        val n = s.length
        var i = 0
        var j = n - 1
        while (i < j) {
            //keep checking if meet vowel from two side, if no, moving two pointer
            while (i < j && !vowels.contains(chars[i])) {
                i++
            }
            while (i < j && !vowels.contains(chars[j])) {
                j--
            }
            //when meet vowel, exchange it
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
        return String(chars)
    }
}