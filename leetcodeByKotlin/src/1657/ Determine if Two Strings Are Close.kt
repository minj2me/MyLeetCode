package LeetCode_1657

/**
 * 1657. Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 *
 * Two strings are considered close if you can attain one from the other using the following operations:
1. Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
2. Operation 2: Transform every occurrence of one existing character into another existing character,
and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.
Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Example 1:
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:
Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"

Example 4:
Input: word1 = "cabbba", word2 = "aabbss"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.

Constraints:
1. 1 <= word1.length, word2.length <= 105
2. word1 and word2 contain only lowercase English letters.
 * */
class Solution {
    /*
    * solution: Array+HashSet, two string must has same characters and same frequency of characters,
    * Time:O(n), Space:O(n)
    * */
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }
        //contain only lowercase English letters, so use 26 is ok
        val aMap = IntArray(26)
        val bMap = IntArray(26)
        val aSet = HashSet<Char>()
        val bSet = HashSet<Char>()
        for (c in word1) {
            aMap[c - 'a']++
            aSet.add(c)
        }
        for (c in word2) {
            bMap[c - 'a']++
            bSet.add(c)
        }
        aMap.sort()
        bMap.sort()
        return (aMap contentEquals bMap) && aSet==bSet
    }
}