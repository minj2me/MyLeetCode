package LeetCode_676

/**
 * 676. Implement Magic Dictionary
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 *
 * Implement a magic directory with buildDict, and search methods.
For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
For the method search, you'll be given a word, and judge whether if you modify exactly
one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False

Note:
1. You may assume that all the inputs are consist of lowercase letters a-z.
2. For contest purpose, the test data is rather small by now.
You could think about highly efficient algorithm after the contest.
3. Please remember to RESET your class variables declared in class MagicDictionary,
as static/class variables are persisted across multiple test cases. Please see here for more details.
 * */
class MagicDictionary() {
    /*
    * solution: Array
    * */

    /** Initialize your data structure here. */
    var newDict: Array<String>? = null

    /** Build a dictionary through a list of words */
    fun buildDict(dict: Array<String>) {
        newDict = dict
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    fun search(word: String): Boolean {
        if (newDict == null) {
            return false
        }
        for (string in newDict!!) {
            if (word.length == string.length) {
                var diffCount = 0
                val wordCharArray = word.toCharArray()
                for (i in wordCharArray.indices) {
                    if (word[i] != string[i]) {
                        diffCount++
                    }
                    if (diffCount > 1) {
                        break
                    }
                }
                if (diffCount == 1) {
                    return true
                }
            }
        }
        return false
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dict)
 * var param_2 = obj.search(word)
 */