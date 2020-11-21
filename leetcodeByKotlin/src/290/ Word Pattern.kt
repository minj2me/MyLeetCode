package LeetCode_290

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/description/
 *
 * Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
 * */
class Solution {
    fun wordPattern(pattern: String, str: String): Boolean {
        val size = pattern.length
        val words = str.split(" ")
        if (size != words.size) {
            return false
        }
        /**
         * "abba"
        "dog dog dog dog"
         * */
        val map = HashMap<Char, String>()
        for (i in 0 until size) {
            val key = pattern[i]
            if (map.containsKey(key)) {
                if (!map.get(key).equals(words[i])) {
                    return false
                }
            } else {
                if (map.containsValue(words[i])) {
                    //if value already in map, which mean it has matched other key, so return false
                    return false
                }
                map.put(key, words[i])
            }
        }
        return true
    }
}