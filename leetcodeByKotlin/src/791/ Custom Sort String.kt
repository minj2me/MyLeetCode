package LeetCode_791

/**
 * 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted.
More specifically, if x occurs before y in S, then x should occur before y in the returned string.
Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

Note:
S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
 * */
class Solution {
    /*
    * problem: sort T like order of S;
    * solution: array; Time complexity:O(m+n) Space complexity:O(n)
    * 1. calculate the frequency of each character in T by map
    * 2. scan character in S, check it if in T as well, if true then append into result and remove it from map
    * 3. the rest of map are characters in T, but not in S, append into result
    * */
    fun customSortString(S: String, T: String): String {
        val result = StringBuilder()
        val map = IntArray(26)

        for (c in T){
            //lowercase letters only
            map[c-'a']++
        }

        for (c in S){
            while (map[c-'a']>0){
                result.append(c)
                map[c-'a']--
            }
        }

        for (c in 'a'..'z'){
            while (map[c-'a']>0){
                result.append(c)
                map[c-'a']--
            }
        }

        return result.toString()
    }
}