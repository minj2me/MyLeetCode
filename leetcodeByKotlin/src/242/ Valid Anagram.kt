package LeetCode_242

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 * Given two strings s and t , write a function to determine if t is an anagram of s.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
 * */
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val arr = IntArray(26)
        // 记录字母在第一个单词中出现的次数
        for (c in s) {
            arr[c.toInt() - 'a'.toInt()]++
        }
        // 减去字母在第二个单词中出现的次数
        for (c in t) {
            arr[c.toInt() - 'a'.toInt()]--
        }
        // 如果某个计数器不为0，则返回false
        for (i in arr) {
            if (i != 0) {
                return false
            }
        }
        return true
    }
}