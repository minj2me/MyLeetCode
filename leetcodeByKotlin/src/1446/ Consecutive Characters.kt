package LeetCode_1446

/**
 * 1446. Consecutive Characters
 * https://leetcode.com/problems/consecutive-characters/description/
 *
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
Return the power of the string.

Example 1:
Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Constraints:
1 <= s.length <= 500
s contains only lowercase English letters.
 * */
class Solution {
    /*
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun maxPower(s: String): Int {
        if (s == null || s.isEmpty()) {
            return 0
        }
        var max = 1
        var currentMax = 1
        for (right in 0 until s.length - 1) {
            //check two character if equal
            if (s[right] == s[right + 1]) {
                currentMax++
                max = Math.max(max, currentMax)
            } else {
                currentMax = 1
            }
        }
        return max
    }
}