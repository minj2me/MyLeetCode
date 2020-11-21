package LeetCode_567

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
 * */
class Solution {
    /*
    * Solution: Sliding Window + Array;
    * Array save the frequency of each latter of s1, and keep tracking s2 to calculate the frequency of each latter of s2;
    * Time complexity:O(l1+l2), Space complexity:O(1)
    * */
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Array = IntArray(26)
        val s2Array = IntArray(26)
        for (c in s1) {
            s1Array[c - 'a']++
        }
        val s1Length = s1.length
        //because check if s2 contains, so loop length of s2
        for (i in s2.indices) {
            //when i larger than s1Length, keep tracking to compare with remove the first latter
            if (i - s1Length >= 0) {
                //reduce the appear count of number at index: i - s1Length
                //for example: "eidbaooo", s1Length==2, i==2, so reduce e's appear count
                s2Array[s2[i - s1Length] - 'a']--
            }
            s2Array[s2[i] - 'a']++
            if (s1Array contentEquals s2Array) {
                return true
            }
        }
        return false
    }
}