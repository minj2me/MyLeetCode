package LeetCode_1119

/**
 * 1119. Remove Vowels from a String
 * (Prime)
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
Example 1:
Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"

Example 2:
Input: "aeiou"
Output: ""

Note:
1. S consists of lowercase English letters only.
2. 1 <= S.length <= 1000
 * */
class Solution {
    /*
    * Time:O(n), Space:O(1)
    * */
    fun removeVowels(s: String): String {
        val vowels = "aeiou"
        val sb = StringBuilder()
        for (c in s){
            if (vowels.contains(c)){
                continue
            }
            sb.append(c)
        }
        return sb.toString()
    }
}