package LeetCode_804

/**
 * 804. Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/description/
 * https://www.cnblogs.com/grandyang/p/9338988.html
 * */
class Solution {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val array = arrayOf(
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        )
        val set = HashSet<String>()
        for (word in words) {
            var t = ""
            for (c in word) {
                //println(array[c-'a'])
                t += array[c - 'a']
            }
            //println("t:$t")
            set.add(t)
        }
        return set.size
    }
}