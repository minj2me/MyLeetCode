package LeetCode_30

/**
 * 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
 * in any order, and without any intervening characters. You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

Constraints:
1. 1 <= s.length <= 104
2. s consists of lower-case English letters.
3. 1 <= words.length <= 5000
4. 1 <= words[i].length <= 30
5. words[i] consists of lower-case English letters.
 * */
class Solution {
    /*
    * solution: Sliding Window, HashMap,
    * Time complexity:O(n*l), Space complexity:O(n), l is length of s, n is count of word
    * */
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (s == null || s.isEmpty() || words == null || words.isEmpty()) {
            return ArrayList()
        }
        //create map to save word and it's frequency
        val frequencyMap = HashMap<String, Int>()
        for (word in words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1)
        }

        val result = ArrayList<Int>()
        val wordLength = words[0].length
        val totalWordCount = words.size
        var i = 0
        //while (i <= s.length - wordLength * totalWordCount) {
        while (i < s.length) {
            //help to check the word if seen before
            val seedWord = HashMap<String, Int>()
            for (j in 0 until totalWordCount) {
                //check each word one by one
                val startIndex = i + j * wordLength
                var endIndex = startIndex + wordLength
                if (endIndex > s.lastIndex) {
                    endIndex = s.lastIndex+1
                }
                val curWord = s.substring(startIndex, endIndex)
                //if current word was not in words, break to next
                if (!frequencyMap.contains(curWord)) {
                    break
                }
                seedWord.put(curWord, seedWord.getOrDefault(curWord, 0) + 1)
                if (seedWord.get(curWord) ?: 0 > frequencyMap.getOrDefault(curWord, 0)) {
                    //handle case: capcapmap,cap's frequency in frequencyMap is 1, so just need the second 'cap'
                    break
                }
                //if j can go through the length of words, mean can cover all word in words, and i to result
                if (j + 1 == totalWordCount) {
                    result.add(i)
                }
            }
            i++
        }
        return result
    }
}