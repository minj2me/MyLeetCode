package LeetCode_14

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1. 0 <= strs.length <= 200
2. 0 <= strs[i].length <= 200
3. strs[i] consists of only lower-case English letters
 * */
class Solution {
    /*
    * solution: scanning array, Time:O(s), s is the sum of all characters in all string; Space:O(1)
    * */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs == null || strs.isEmpty()) {
            return ""
        }
        var first = strs[0]
        val n = strs.size
        for (i in 1 until n) {
            /*
            * if current word is not startWith first, remove the last letter in first to check again
            * for example first is flower then:
            * flowe, flow, flo, fl
            * */
            while (!strs[i].startsWith(first)) {
                first = first.substring(0, first.length - 1)
            }
        }
        return first
    }
}