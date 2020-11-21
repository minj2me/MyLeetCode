package LeetCode_1358

/**
 * 1358. Number of Substrings Containing All Three Characters
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are
"abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

Constraints:
1. 3 <= s.length <= 5 x 10^4
2. s only consists of a, b or c characters.
 * */
class Solution {
    /*
    * solution: Sliding window, Time complexity:O(n), Space complexity:O(1)
    * */
    fun numberOfSubstrings(s: String): Int {
        if (s == null || s.isEmpty()) {
            return 0
        }
        var result = 0
        //count the appearance of a,b,c
        val counter = IntArray(3)
        var left = 0
        var right = 0
        //the a,b,c count of substring
        var curCount = 0
        val n = s.length
        while (right < n) {
            val c = s[right]
            counter[c - 'a']++
            //if counter contains all a,b,c, reduce the window size
            while (left < n && counter[0] > 0 && counter[1] > 0 && counter[2] > 0) {
                curCount++
                val c2 = s[left]
                counter[c2 - 'a']--
                left++
            }
            //add to result
            result += curCount
            right++
        }
        return result
    }
}