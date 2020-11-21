package LeetCode_316

import java.lang.StringBuilder

/**
 * 316. Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 * https://www.youtube.com/watch?v=SrlvMmfG8sA
 *
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"

Example 2:

Input: "cbacdcbc"
Output: "acdb"
 * */
class Solution {
    fun removeDuplicateLetters(s: String): String {
        val count = IntArray(26)
        val used = BooleanArray(26)
        val sb = StringBuilder()

        for (c in s) {
            //get every latter's appear count
            count[c.toInt() - 'a'.toInt()]++
        }

        for (c in s) {
            count[c.toInt() - 'a'.toInt()]--//because checking if same latter will be appear later,so need reduce it
            if (used[c.toInt() - 'a'.toInt()]) {
                continue
            }
            //compared order with string had append in sb
            while (sb.length > 0 &&
                //if last one in sb bigger than current c
                (sb.get(sb.length - 1).toInt() - 'a'.toInt() > c.toInt()-'a'.toInt()) &&
                //still have same latter at behind
                (count[sb.get(sb.length - 1).toInt() - 'a'.toInt()] > 0)
            ) {
                used[sb.get(sb.length - 1).toInt() - 'a'.toInt()] = false
                sb.deleteCharAt(sb.length - 1)
            }
            sb.append(c)
            used[c.toInt() - 'a'.toInt()] = true
        }
        return sb.toString()
    }
}