package LeetCode_745

/**
 * 745. Prefix and Suffix Search
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 *
Given many words, words[i] has weight i.
Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix).
It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1

Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.
 * */

/*
* solution 1: HashMap, Time complexity:O(n*len^3 + n*len), Space complexity:O(n*len^3)
* n is number of words, len is the max length of word
* */
class WordFilter(words: Array<String>) {
    //key is string form: perfix_suffix, value is Index
    val map = HashMap<String, Int>()

    init {
        buildMap(words)
    }

    /*
    * build map by word,
    * for example: apple can generate the key: a_e, ap_le, app_ple, appl_pple, apple_apple
    * */
    private fun buildMap(words: Array<String>) {
        var index = 0
        for (word in words) {
            val len = word.length
            val perfixs = Array<String>(len + 1, { "" })
            val suffixs = Array<String>(len + 1, { "" })
            for (i in 0 until len) {
                perfixs[i + 1] = perfixs[i] + word[i]
                suffixs[i + 1] = word[len - i - 1] + suffixs[i]
            }
            //put perfixs and suffixs input map
            for (perfix in perfixs) {
                for (suffix in suffixs) {
                    //HashMap can replace and value if the same key
                    map.put(perfix + "_" + suffix, index)
                }
            }
            index++
        }
    }

    fun f(prefix: String, suffix: String): Int {
        val key = prefix + "_" + suffix
        if (map.containsKey(key)) {
            return map.get(key)!!
        }
        return -1
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */