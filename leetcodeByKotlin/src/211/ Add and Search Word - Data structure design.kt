package LeetCode_211

/**
 * 211. Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * Design a data structure that supports the following two operations:
=void addWord(word)
=bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.
 * */

class Trie {
    var end = false
    var children = arrayOfNulls<Trie>(26)
}

class WordDictionary() {
    /*
    * solution: Trie Tree,
    * */

    var root: Trie? = null

    /** Initialize your data structure here. */
    init {
        root = Trie()
    }

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var node = root
        //while (k < word.length) {
        for (ch in word) {
            val pos = ch - 'a'
            if (node?.children!![pos] == null) {
                node.children!![pos] = Trie()
            }
            node = node.children!![pos]
        }
        node?.end = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }

    private fun dfs(word: String, pos: Int, root: Trie?): Boolean {
        if (root == null) {
            return false
        }
        if (pos == word.length) {
            return root.end
        }
        val ch = word[pos]
        println("ch:$ch")
        if (ch == '.') {
            //if meet '.', need search all children
            for (child in root.children!!) {
                if (child != null && dfs(word, pos + 1, child)) {
                    return true
                }
            }
        } else {
            return dfs(word, pos + 1, root.children!![ch - 'a'])
        }
        return false
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */