package LeetCode_642

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 642. Design Search Autocomplete System
 * (Prime)
 * Design a search autocomplete system for a search engine.
 * Users may input a sentence (at least one word and end with a special character '#').
 * For each character they type except '#',
 * you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
Here are the specific rules:
1. The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
2. The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
3. If less than 3 hot sentences exist, then just return as many as you can.
4. When the input is a special character, it means the sentence ends, and in this case,
you need to return an empty list.

Your job is to implement the following functions:
The constructor function:
AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
The input is historical data. Sentences is a string array consists of previously typed sentences.
Times is the corresponding times a sentence has been typed. Your system should record these historical data.
Now, the user wants to input a new sentence.
The following function will provide the next character the user types:
List<String> input(char c): The input c is the next character typed by the user.
The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
Also, the previously typed sentence should be recorded in your system.
The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i".
Among them, "ironman" and "i love leetcode" have same hot degree.
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system.
And the following input will be counted as a new search.
 * */

/*
* solution: Trie + PriorityQueue
* */
class AutocompleteSystem constructor(sentences: Array<String>, times: Array<Int>) {

    var root: TrieNode? = null
    var perfix = ""

    init {
        root = TrieNode()
        for (i in sentences.indices) {
            add(sentences[i], times[i])
        }
    }

    private fun add(word: String, time: Int) {
        var cur = root
        for (ch in word) {
            var next = cur!!.children.get(ch)
            if (next == null) {
                next = TrieNode()
                cur.children.put(ch, next)
            }
            //establish root-children relationship
            cur = next
            cur.counts.put(word, cur.counts.getOrDefault(word, 0) + time)
        }
        cur?.isWord = true
    }

    class TrieNode {
        var children = HashMap<Char, TrieNode>()
        var counts = HashMap<String, Int>()
        var isWord = false
    }

    class Node(word_: String, count_: Int) {
        var word: String = ""
        var count = 0

        init {
            word = word_
            count = count_
        }
    }

    fun input(c: Char): List<String> {
        if (c == '#') {
            add(perfix, 1)
            perfix = ""
            return ArrayList()
        }
        perfix += c
        var cur = root
        for (ch in perfix) {
            val next = cur!!.children.get(ch)
            if (next == null) {
                return ArrayList()
            } else {
                cur = next
            }
        }
        val queue = PriorityQueue<Node> { a, b ->
            if (a.count == b.count) {
                a.word.compareTo(b.word)
            } else {
                b.count - a.count
            }
        }
        for (item in cur!!.counts) {
            queue.offer(Node(item.key, item.value))
        }
        val result = ArrayList<String>()
        var i = 0
        while (i < 3 && queue.isNotEmpty()) {
            result.add(queue.poll().word)
            i++
        }
        return result
    }
}
/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */