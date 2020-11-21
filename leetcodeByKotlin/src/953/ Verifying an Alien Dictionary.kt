package LeetCode_953

/**
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * */
class Solution {
    /*
    * Time complexity is O(m*n), m is array length, n is word length
    * Space complexity is O(1)
    * */
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        //for char and its index
        val map = HashMap<Char, Int>()
        for (i in order.indices) {
            map.put(order[i], i)
        }
        //check each char in every word
        for (i in 0 until words.size - 1) {
            if (!check(words[i],words[i+1],map)){
                return false
            }
        }
        return true
    }

    private fun check(word1: String, word2: String, map: HashMap<Char, Int>):Boolean {
        var j = 0
        val word1Length = word1.length
        val word2Length = word2.length
        while (j < word1Length && j < word2Length) {
            val index1 = map.get(word1[j])!!
            val index2 = map.get(word2[j])!!
            if (index1 < index2) {
                return true
            } else if (index1 > index2) {
                return false
            }
            j++
        }
        return word1Length <= word2Length
    }
}