package LeetCode_758

import java.util.*
import kotlin.collections.HashSet

/**
 * 758. Bold Words in String
 * (Prime)
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold.
 * Any letters between <b> and </b> tags become bold.
The returned string should use the least number of tags possible, and of course the tags should form a valid combination.
For example,
given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d".
Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Note:
words has length in range [0, 50].
words[i] has length in range [1, 10].
S has length in range [0, 500].
All characters in words[i] and S are lowercase letters.
 * */
class Solution {
    /*
    * solution: use array to record current latter if need bold;
    * Time complexity:O(n^3), Space complexity:O(n+d)
    * n=s.length
    * d=words.size
    * */
    fun boldWord(words: List<String>, s: String): String {
        val set = HashSet<String>()
        set.addAll(words)
        val n = s.length
        //1 represent need bold
        val bolded = IntArray(n)

        /*checking each sub-string
            * for example: aabcd, checking order like:
            * 1. a,aa,aab,aabc
            * 2. a,ab,abc
            * 3. b,bc, c
            * */
        for (i in 0 until n) {
            for (j in 1 .. n - i) {
                if (set.contains(s.substring(i, i + j))) {
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
            if (bolded[i] == 1 && (i==n-1 || bolded[i + 1] != 1)) {
                sb.append("</b>")
            }
        }
        //println(sb.toString())
        return sb.toString()
    }
}