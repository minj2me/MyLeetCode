package LeetCode_767

import java.util.*
import kotlin.collections.HashMap

/**
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
If possible, output any possible result.  If not possible, return the empty string.

Example 1:
Input: S = "aab"
Output: "aba"

Example 2:
Input: S = "aaab"
Output: ""

Note:
S will consist of lowercase letters and have length in range [1, 500].
 * */
class Solution {
    fun reorganizeString(S: String): String {
        val map = HashMap<Char, Int>()
        for (c in S) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }
        val maxHeap = PriorityQueue<Pair<Char, Int>> { a, b -> b.second-a.second }
        for (m in map) {
            //if some latter's appeared frequency lager than half of S
            if (m.value > (S.length + 1) / 2) {
                return ""
            }
            val pair = Pair(m.key, m.value)
            maxHeap.offer(pair)
        }
        val result = StringBuilder()
        //two characters that are adjacent to each other
        while (maxHeap.size >= 2) {
            var top1 = maxHeap.poll()
            var top2 = maxHeap.poll()
            result.append(top1.first)
            result.append(top2.first)
            //because Pair, like most data classes, is immutable, so we use copy to change it's value
            var count = top1.second
            var count2 = top2.second
            count--
            count2--
            top1 = top1.copy(second = count)
            top2 = top2.copy(second = count2)
            if (top1.second > 0) {
                maxHeap.offer(top1)
            }
            if (top2.second > 0) {
                maxHeap.offer(top2)
            }
        }
        //check if some one left
        if (maxHeap.isNotEmpty()) {
            result.append(maxHeap.poll().first)
        }
        return result.toString().reversed()
    }
}