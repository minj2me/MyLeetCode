package LeetCode_127

import java.util.*
import kotlin.collections.HashSet

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/description/
 *
 * Given two words (beginWord and endWord), and a dictionary’s word list,
 * find the length of shortest transformation sequence from beginWord to endWord,
 * such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *For example:
 * beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(n*26^L), Space complexity:O(n*26^L),
    * because deep if depend on L, L is the length of beginWord
    * */
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val dict = HashSet<String>()
        for (word in wordList) {
            dict.add(word)
        }
        if (!dict.contains(endWord)) {
            return 0
        }
        val queue = LinkedList<String>()
        //add into queue
        queue.offer(beginWord)
        var step = 0
        while (queue.isNotEmpty()) {
            step++
            for (size in queue.size downTo 0 + 1) {
                //retrieves and removes the head (first element) of this list.
                val word = queue.poll()
                val wordLength = word.length
                val chars = word.toCharArray()
                for (i in 0 until wordLength) {
                    val ch = chars[i]
                    //try every latter
                    for (c in 'a'..'z') {
                        if (ch == c) {
                            continue
                        }
                        chars[i] = c//replace each latter for compare, for example hit->ait
                        val t = String(chars)
                        if (t.equals(endWord)) {//if can change to endWord
                            return step + 1
                        }
                        if (!dict.contains(t)) {
                            //if the word not in dict, no need enqueue for check next time
                            continue
                        }
                        //if had checked, remove it
                        dict.remove(t)
                        //add to queue for scan next time
                        queue.offer(t)
                    }//end for
                    //set back the latter for next loop, for example current is zit, set back to hit
                    //because next loop will scan start hat to hzt
                    chars[i] = ch
                }//end for
            }
        }
        return 0
    }

    //bfs Pseudocode
    /*
    * queue.push(start)
    * step = 0
    * while (queue.isNotEmpty()){
    *   step++
    *   size = queue.size
    *   //scan current level
    *   while (size-->0){
    *       node = queue.pop()
    *       //从node开始扩展
    *       new_nodes = expand(node)
    *       if (goal in new_nodes){
    *           return step++
    *       }
    *       queue.append(new_nodes)
    *   }
    * }
    * return NOT_FOUND
    * */
}