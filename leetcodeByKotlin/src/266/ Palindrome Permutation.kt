package LeetCode_266

/**
 * 266. Palindrome Permutation
 * (prime)
 * https://www.lintcode.com/problem/palindrome-permutation/description
 *
 *Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Example 3:
Input: "carerac"
Output: true
 * */
class Solution {
    /*
    * solution: HashMap, Time complexity:O(n), Space complexity:O(n);
    * permutation mean can be discontinuous
    * */
    fun canPermutePalindrome(s: String): Boolean {
        //key:c, value:occurrence count
        val map = HashMap<Char, Int>()
        for (c in s) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }
        /*
        * check if Palindrome, 2 situation:
        * 1. odd count is 0;
          2. length of s is odd and odd count is 1;(for example:"carerac")
        * */
        var oddCount = 0
        for (m in map) {
            if (m.value % 2 == 1) {
                oddCount++
            }
        }
        return oddCount == 0 || (s.length % 2 == 1 && oddCount == 1)
    }
}