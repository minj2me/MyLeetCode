package LeetCode_1046

import java.util.*

/**
 * 1046. Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/description/
 * */
class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        //set the max heap
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }
        for (stone in stones) {
            maxHeap.add(stone)
        }
        while (maxHeap.size >= 2) {
            val s1 = maxHeap.poll()
            val s2 = maxHeap.poll()
            if (s1 != s2) {
                maxHeap.add(Math.abs(s1 - s2))
            }
        }
        return if (maxHeap.isEmpty()) 0 else maxHeap.poll()
    }
}