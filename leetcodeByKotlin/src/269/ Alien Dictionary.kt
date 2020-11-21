package LeetCode_269

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 269. Alien Dictionary
 * (Prime)
 * https://www.lintcode.com/problem/alien-dictionary/description
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.

Example 1:
Input:
[
"wrt",
"wrf",
"er",
"ett",
"rftt"
]
Output: "wertf"

Example 2:
Input:
[
"z",
"x"
]
Output: "zx"

Example 3:
Input:
[
"z",
"x",
"z"
]
Output: ""
Explanation: The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(ve), Space complexity:O(ve), v:node count, e:edge count
    * */
    fun alienOrder(words: Array<String?>?): String {
        if (words == null || words.isEmpty()) {
            return ""
        }
        val graph = HashMap<Char, HashSet<Char>>()
        val set = HashSet<Char>()
        //put word in set
        for (word in words) {
            for (i in word!!.indices) {
                set.add(word[i])
            }
        }
        //init graph and calculate the in-degree
        val indgree = IntArray(26)
        for (k in 1 until words.size) {
            val prev = words[k - 1] ?: ""
            val cur = words[k] ?: ""
            val minLen = Math.min(prev.length, cur.length)
            for (i in 0 until minLen) {
                val prevChar = prev[i]
                val curChar = cur[i]
                if (prevChar != curChar) {
                    if (!graph.containsKey(prevChar)){
                        graph.put(prevChar, HashSet())
                    }
                    if (!graph.get(prevChar)!!.contains(curChar)){
                        //all letters are in lowercase
                        indgree[curChar-'a']++
                    }
                    graph.get(prevChar)!!.add(curChar)
                }
            }
        }
        //println(graph)
        //println(set)
        //indgree.forEach{print("$it,")}
        val queue = LinkedList<Char>()
        for (i in indgree.indices){
            if (indgree[i]==0){
                val c = 'a'+i
                if (set.contains(c)){
                    queue.offer(c)
                }
            }
        }
        //println(queue)
        val sb = StringBuilder()
        while (queue.isNotEmpty()){
            val c = queue.poll()
            sb.append(c)
            //expending
            if (graph.containsKey(c)){
                val st = graph.get(c) as HashSet<Char>
                for (item in st){
                    indgree[item-'a']--
                    if (indgree[item-'a']==0){
                        queue.offer(item)
                    }
                }
            }
        }
        //println(sb.toString())
        return if(sb.length!=set.size) "" else sb.toString()
    }
}