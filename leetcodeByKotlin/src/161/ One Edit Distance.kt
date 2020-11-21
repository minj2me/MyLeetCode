package LeetCode_161

/**
 * 161. One Edit Distance
 * https://www.lintcode.com/problem/one-edit-distance/description
 *
Given two strings S and T, determine if they are both one edit distance apart.
One ediit distance means doing one of these operation:

insert one character in any position of S
delete one character in S
change one character in S to other character

Example 1:
Input: s = "aDb", t = "adb"
Output: true

Example 2:
Input: s = "ab", t = "ab"
Output: false
Explanation:
s=t ,so they aren't one edit distance apart
 * */
class Solution {
    /*
    * Solution: Two pointer, Time complexity:O(n), Space complexity:O(1)
    * */
    fun isOneEditDistance(s: String, t: String): Boolean {
        if (s == t) {
            return false
        }
        var diffCount = 0
        val l1 = s.length
        val l2 = t.length
        if (Math.abs(l1 - l2) > 1) {
            return false
        }
        var i = 0
        var j = 0
        while (i < l1 && j < l2) {
            if (s[i] == t[j]) {
                i++
                j++
            } else {
                diffCount++
                if (diffCount > 1) {
                    return false
                }
                //if length of one string is more,
                //then only possible edit is remove a character
                if (l1 > l2) {
                    i++
                } else if (l1 < l2) {
                    j++
                } else {
                    i++
                    j++
                }
            }
        }
        //check if last character extra in any string
        if (i < l1 || j < l2) {
            diffCount++
        }
        return diffCount == 1
    }
}