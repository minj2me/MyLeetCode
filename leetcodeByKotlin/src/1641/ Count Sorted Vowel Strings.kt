package LeetCode_1641

/**
 * 1641. Count Sorted Vowel Strings
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 *
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

Example 1:
Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:
Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Example 3:
Input: n = 33
Output: 66045

Constraints:
1 <= n <= 50
 * */
class Solution {
    /*
    * solution 1: dfs + backtracking, Time complexity:O(n!), Space complexity:O(n!)
    * solution 2: math, Time complexity:O(n), Space complexity:O(1)
    * */

    private var result = 0
    private val vowels = arrayOf("a", "e", "i", "o", "u")

    fun countVowelStrings(n: Int): Int {
        dfs(0, n, ArrayList())
        return result
    }

    //solution 1
    private fun dfs(index: Int, n: Int, cur: ArrayList<String>) {
        if (cur.size == n) {
            result++
            return
        }
        for (i in index until 5) {
            //check letter's order
            if (cur.isNotEmpty() && cur.get(cur.lastIndex) > vowels[i]) {
                continue
            }
            cur.add(vowels[i])
            dfs(index, n, cur)
            cur.removeAt(cur.lastIndex)
        }
    }

    //solution 2
    private fun math(n_: Int):Int {
        var n = n_
        var a = 1
        var e = 1
        var i = 1
        var o = 1
        var u = 1
        while (n > 1) {
            // add new char before prev string
            a = (a + e + i + o + u)//a, e, i, o, u -> aa, ae, ai, ao, au
            e = (e + i + o + u)
            i = (i + o + u)
            o = (o + u)
            u = u
            n--
        }
        return a + e + i + o + u
    }
}