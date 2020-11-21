package LeetCode_616

import java.util.*
import kotlin.collections.HashSet

/**
 * 616. Add Bold Tag in String
 * (Prime)
 * Given a string s and a list of strings dict,
 * you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict.
 * If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag.
 * Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 *
Example 1:
Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"

Example 2:
Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

Note:
1. The given dict won't contain duplicates, and its length won't exceed 100.
2. All the strings in input have length in range [1, 1000].
 * */
class Solution {
    /*
    * solution: use array to record current latter if need bold;
    * Time complexity:O(n^3), Space complexity:O(n+d)
    * n=s.length
    * d=words.size
    * */
    fun addBoldTag(words: List<String>, s: String): String {
        val set = HashSet<String>()
        set.addAll(words)
        val n = s.length
        //1 represent need bold
        val bolded = IntArray(n)

        /*checking each sub-string
            * for example: aabcd, checking order like:
            * 1. a,aa,aab,aabc,aabcd
            * 2. a,ab,abc,abcd
            * 3. b,bc,bcd
            * 4. c,cd,d
            * */
        for (i in 0 until n) {
            for (j in 1 .. n - i) {
                if (set.contains(s.substring(i, i+j))) {
                    //0,1,1,1,0,
                    Arrays.fill(bolded, i, i + j, 1)
                }
            }
        }

        //set the result by boled array
        val sb = StringBuilder()
        for (i in 0 until n) {
            if (bolded[i] == 1 && (i == 0 || bolded[i - 1] != 1)) {
                sb.append("<b>")
            }
            sb.append(s[i])
            //add </b> in the last, so check if(i==n-1)
            if (bolded[i] == 1 && (i == n - 1 || bolded[i + 1] != 1)) {
                sb.append("</b>")
            }
        }
        return sb.toString()
    }
}