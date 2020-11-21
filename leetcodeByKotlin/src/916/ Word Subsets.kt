package LeetCode_916

/**
 * 916. Word Subsets
 *https://leetcode.com/problems/word-subsets/description/
 *
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
For example, "wrr" is a subset of "warrior", but is not a subset of "world".
Now say a word a from A is universal if for every b in B, b is a subset of a.
Return a list of all universal words in A.  You can return the words in any order.

Example 1:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]

Note:
1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 * */
class Solution {
    fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
        val result = ArrayList<String>()
        //for example B:"e","oo"
        //maxFrequency: 0,0,0,0,1,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,
        val maxFrequency = IntArray(26)
        for (str in B) {
            val strFrequency = countFrequency(str)
            for (i in 0 until 26) {
                maxFrequency[i] = Math.max(maxFrequency[i], strFrequency[i])
            }
        }

        for (word in A) {
            val strFrequency = countFrequency(word)
            //B:"e","oo"
            //if the word in set A that this word's letter e's occur frequency is not less than 1 and
            //o's occur frequency not less than 2, than add to result
            for (i in 0 until 26) {
                if (strFrequency[i] < maxFrequency[i]) {
                    break
                }
                if (i == 25) {
                    result.add(word)
                }
            }
        }
        //println(result)
        return result
    }

    private fun countFrequency(word: String): IntArray {
        val result = IntArray(26)
        for (c in word) {
            result[c - 'a']++
        }
        return result
    }
}