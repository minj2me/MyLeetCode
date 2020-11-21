package LeetCode_3

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * https://www.youtube.com/watch?v=3IETreEybaA
 *
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        //solution 3: Sliding window, Time complexity:O(n), Space complexity:O(256)
        if (s==null || s.isEmpty()){
            return 0
        }
        val map = IntArray(256)
        var left = 0
        var right = 0
        var counter = 0
        var result = 0
        while (right < s.length) {
            val c = s[right]
            map[c.toInt()]++
            if (map[c.toInt()] > 1) {
                //meet repeat letter
                counter++
            }
            right++
            while (counter > 0) {
                //while meet repeat letter, moving the left pointer to maintain new size
                val c = s[left]
                if (map[c.toInt()] > 1) {
                    counter--
                }
                map[c.toInt()]--
                left++
            }
            result = Math.max(result, right - left)
        }
        return result

        //solution 1
        //time complexity:O(n*n)
        //space complexity:O(n)
        /*val length = s.length
        for (i in 0 until length) {
            val sb = StringBuilder()
            var subI = i
            while (subI < length) {
                if (sb.toString().indexOf(s[subI]) == -1) {
                    //if not found the char in substring, add it up
                    sb.append(s[subI])
                } else {
                    break
                }
                subI++
            }
            result = Math.max(result, sb.toString().length)
        }*/

        //solution 2, ArrayList
        /*var max = 0
        var left = 0
        var right = 0
        val length = s.length
        val set = ArrayList<Char>(length)
        while (right < length) {
            if (!set.contains(s[right])){
                set.add(s[right])
                right++
                max = Math.max(max,set.size)
            } else {
                set.remove(s[left])
                left++
            }
        }
        return max*/
    }
}