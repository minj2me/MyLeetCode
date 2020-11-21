package LeetCode_395

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:
Input:
s = "aaabb", k = 3
Output:
3
The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:
Input:
s = "ababbc", k = 2
Output:
5
The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * */
class Solution {
    /*
    * solution: Divide and Conquer, find out the break potion of string and compare the length of the valid string,
    * Time complexity:O(n^2), Space complexity:O(1)
    * */
    fun longestSubstring(s: String, k: Int): Int {
        if (s == "") {
            return 0
        }
        val n = s.length
        //because just lowercase letters
        val map = IntArray(26)
        for (c in s) {
            map[c - 'a']++
        }
        var currentStringOk = true
        for (c in s) {
            if (map[c - 'a'] < k) {
                currentStringOk = false
            }
        }
        if (currentStringOk) {
            return s.length
        }
        var result = 0
        var start = 0
        var end = 0
        while (end < n) {
            //if appearance time of current char less than k, find out the substring and go to compare
            if (map[s[end] - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, end), k))
                //set the start to the index of break point
                start = end + 1
            }
            end++
        }
        //some case that: if end pointer had at the end position, but start pointer haven't at same position, so need to check
        result = Math.max(result, longestSubstring(s.substring(start), k))
        return result
    }
}