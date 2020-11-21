package LeetCode_208

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * */

class Trie() {
    private var root: TrieNode? = null

    class TrieNode {
        var children = arrayOfNulls<TrieNode>(26)
        var isWord = false
    }

    /** Initialize your data structure here. */
    init {
        root = TrieNode()
    }

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var p = root
        for (c in word) {
            val index = c.toInt() - 'a'.toInt()
            if (p?.children?.get(index) == null) {
                p?.children?.set(index, TrieNode())
            }
            p = p?.children?.get(index)
        }
        //mark last node as leaf
        p?.isWord = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        val node = find(word)
        return node != null && node.isWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        val node = find(prefix)
        return node != null
    }

    private fun find(prefix: String): TrieNode? {
        var p = root
        for (c in prefix) {
            val index = c.toInt() - 'a'.toInt()
            if (p?.children?.get(index) == null) {
                return null
            }
            p = p?.children?.get(index)
        }
        return p
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */