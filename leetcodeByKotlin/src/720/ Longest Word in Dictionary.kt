package LeetCode_720

/**
 * 720. Longest Word in Dictionary
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 *
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

Note:
All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 * */
class Solution {
    /*
    * solution: HashSet, put every string in Set, then bruce force with pruning to check string if in Set;
    * Time complexity:O(n*l), Space complexity:O(n)
    * */
    fun longestWord(words: Array<String>): String {
        val set = HashSet<String>()
        for (word in words) {
            set.add(word)
        }
        var result = ""
        for (word in words) {
            //pruning, word > result mean word's lexicographically larger than result
            if (word.length < result.length || (word.length == result.length && word > result)) {
                continue
            }
            var valid = true
            var prefix = ""
            var i = 0
            while (valid && i < word.length) {
                prefix += word[i]
                if (!set.contains(prefix)) {
                    valid = false
                }
                i++
            }
            if (valid) {
                result = word
            }
        }
        return result
    }
}