package LeetCode_792

/**
 * 792. Number of Matching Subsequences
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :

Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]

Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * */
class Solution {

    //use HashSet to improve, 500ms; if not, 1500ms
    val pass = HashSet<String>()
    val noPass = HashSet<String>()

    fun numMatchingSubseq(S: String, words: Array<String>): Int {
        /**
         *
         * Java中将一个字符与对应Ascii码互转
         * 1 byte = 8bit 可以表示 0-127
        0-9对应Ascii 48-57
        A-Z 65-90
        a-z 97-122
        第33～126号(共94个)是字符，其中第48～57号为0～9十个阿拉伯数字
         * */
        var result = 0
        for (word in words) {
            if (pass.contains(word) || noPass.contains(word)) {
                if (pass.contains(word)) {
                    result++
                }
                continue
            }
            if (letterInStr(word, S)) {
                result++
            }
        }
        return result
    }

    /**
     * 这个我们可以采用双指针的方法，一个指针i指向word，一个指针j指向S，
     * 当s[i] == t[j]的时候，i++, j++。
     * 当s[i] != t[j]的时候，j++；
     * 最后再判断指针i时候到达了word末尾。
     * */
    private fun letterInStr(word: String, S: String): Boolean {
        val letters = word.toCharArray()
        val ss = S.toCharArray()
        var i = 0
        var j = 0
        while (i < letters.size && j < ss.size) {
            if (letters[i] == ss[j]) {
                i++
            }
            j++
        }
        if (i == letters.size) {
            pass.add(word)
        } else {
            noPass.add(word)
        }
        return i == letters.size
    }
}