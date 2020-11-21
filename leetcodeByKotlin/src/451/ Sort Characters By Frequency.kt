package LeetCode_451

import java.lang.StringBuilder

/**
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * */
class Solution {
    fun frequencySort(s: String): String {
        val map = HashMap<Int, Char>()
        val countMap = HashMap<Int, Int>()
        for (item in s) {
            val key = item - 'A'
            map.put(key, item)
            /*if (countMap.get(key) == null) {
                countMap.put(key, 1)
            } else {
                countMap.set(key, countMap.get(key)!! + 1)
            }*/
            countMap.put(key,countMap.getOrDefault(key,0)+1)
        }
        //!!use priority queue to improve
        val result = countMap.toList().sortedWith(object : Comparator<Pair<Int, Int>> {
            override fun compare(o1: Pair<Int, Int>?, o2: Pair<Int, Int>?): Int = when {
                o1!!.second < o2!!.second -> 1
                o1!!.second == o2!!.second -> 0//if (o1!!.first > o2!!.first) 1 else -1
                else -> -1
            }
        }).toMap()
        val sb = StringBuilder()
        for (entry in result) {
            //print("Key: " + entry.key)
            //println(" Value: " + entry.value)
            //print(map.get(entry.key))
            for (i in 0 until entry.value) {
                sb.append(map.get(entry.key))
            }
        }
        //print(sb.toString())
        return sb.toString()
    }
}