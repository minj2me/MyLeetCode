package LeetCode_358

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 358. Rearrange String k Distance Apart
 * (Prime)
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
All input strings are given in lowercase letters.
If it is not possible to rearrange the string, return an empty string "".

Example 1:
Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least distance 3 from each other.

Example 2:
Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.

Example 3:
Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.
 * */
class Solution {
    /*
    * solution: HashMap + Priority Queue, Time complexity:O(nlogn), Space complexity:O(n)
    * 1. calculate frequency of each letter
    * 2. put all letter into Priority Queue by most freq
    * 3. take out most freq letter one by one to make the answer
    * */
    fun rearrrangeString(s: String, k: Int): String {
        if (k == 0) {
            return s
        }
        val map = HashMap<Char, Int>()
        for (c in s) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }
        //set the max heap, store pair, first is frequency, second is char
        val queue = PriorityQueue<Pair<Int, Char>> { a, b ->
            if (b.first == a.first) {
                a.second - b.second
            } else {
                b.first - a.first
            }
        }
        map.forEach { char, freq ->
            queue.add(Pair(freq, char))
        }
        val sb = StringBuilder()
        while (queue.isNotEmpty()) {
            //take out first k element
            val n = Math.min(k, queue.size)
            val temp = ArrayList<Pair<Int, Char>>()
            for (i in 0 until n) {
                val cur = queue.remove()
                val char = cur.second
                var freq = cur.first
                sb.append(char)
                //check if need put in queue again
                freq--
                if (freq != 0) {
                    temp.add(Pair(freq, char))
                }
            }
            //check if can same characters at least distance k, if cannot return ""
            if (n < k && temp.isNotEmpty()) {
                return ""
            }
            //then put some back to queue
            for (item in temp) {
                queue.add(item)
            }
        }
        return sb.toString()
    }
}