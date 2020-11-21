package LeetCode_126

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 126. Word Ladder II
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
Only one letter can be changed at a time Each transformed word must exist in the word list.
Note that beginWord is not a transformed word.

Note:
1. Return an empty list if there is no such transformation sequence.
2. All words have the same length.
3. All words contain only lowercase alphabetic characters.
4. You may assume no duplicates in the word list.
5. You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output:
[
["hit","hot","dot","dog","cog"],
["hit","hot","lot","log","cog"]
]
 * */
class Solution {
    /*
    * solution: BFS+DFS, bfs to create graph, dfs to find all path
    * */
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val result = ArrayList<List<String>>()
        //use set can quick search word
        val dict = HashSet<String>()
        for (word in wordList) {
            dict.add(word)
        }
        if (!dict.contains(endWord)) {
            return result
        }
        dict.remove(beginWord)
        dict.remove(endWord)
        /*
        * steps: key is word, value is the step, save the shortest step can become to this word,
        * for example beginWord, the shortest path from beginWord to beginWord is 1
        * */
        val steps = HashMap<String, Int>()
        steps.put(beginWord, 1)

        /*
        *parents: key is word, value is the list that contains words can transform to key,
        *can help us backtracking to create paths
        * */
        val parents = HashMap<String, ArrayList<String>>()

        val queue = LinkedList<String>()
        queue.offer(beginWord)
        var step = 0
        //if found out result in current level
        var found = false

        while (queue.isNotEmpty() && !found) {
            step++
            //take out all words from current level
            for (i in queue.size downTo 1) {
                val word = queue.pop()
                val chars = word.toCharArray()
                for (i in chars.indices) {
                    val ch = chars[i]
                    //check every letter
                    for (c in 'a'..'z') {
                        if (c == ch) {
                            continue
                        }
                        //change current word by replace the letter
                        chars[i] = c
                        val currentWord = String(chars)
                        if (currentWord == endWord) {
                            //println("currentWord:$currentWord")
                            //found out one result, set currentWord is become from word
                            //for example:["hot","dot","dog","lot","log","cog"]
                            //map is: lot=[hot], lot's parent is hot, meaning lot was became from hot
                            if (!parents.contains(currentWord)){
                                parents.put(currentWord, ArrayList())
                            }
                            parents.get(currentWord)?.add(word)
                            found = true
                        } else {
                            //not a new word, but other transform with the same number of step
                            if (steps.contains(currentWord) && step < steps.getOrDefault(currentWord,0)) {
                                if (!parents.contains(currentWord)){
                                    parents.put(currentWord, ArrayList())
                                }
                                parents.get(currentWord)?.add(word)
                            }
                        }
                        if (!dict.contains(currentWord)) {
                            continue
                        }
                        dict.remove(currentWord)
                        queue.offer(currentWord)
                        steps.put(currentWord, steps.getOrDefault(word,0)+1)
                        //steps.put(word, steps.getOrDefault(currentWord,0)+1)
                        //currentWord is a new word, so need set it parent
                        if (!parents.contains(currentWord)){
                            parents.put(currentWord, ArrayList())
                        }
                        parents.get(currentWord)?.add(word)
                    }
                    //set back the latter for next loop, for example current is zit, set back to hit
                    //because next loop will scan start hat to hzt
                    chars[i] = ch
                }
            }
        }
        //println("parents all:${parents}")
        //start to found all path
        if (found){
            val cur = ArrayList<String>()
            //we search from end to start
            cur.add(endWord)
            dfs(endWord, beginWord, parents, cur, result)
        }
        println(result)
        return result
    }

    private fun dfs(word:String, beginWord: String, parents:HashMap<String, ArrayList<String>>, cur:ArrayList<String>, result:ArrayList<List<String>>){
        println("word:$word")
        if (word == beginWord){
            //reverse it, because dfs is do it from end to start
            cur.reverse()
            val temp = ArrayList<String>(cur)
            result.add(temp)
            return
        }
        for (w in parents.get(word)!!){
            cur.add(w)
            dfs(w, beginWord, parents, cur, result)
            cur.removeAt(cur.lastIndex)
        }
    }
}