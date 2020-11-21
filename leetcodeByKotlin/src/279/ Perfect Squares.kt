package LeetCode_279

import java.util.*
import kotlin.collections.HashSet

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

class Solution {
    /*
    * solution:bfs, lets say n as root of tree, scan level by level, find out the shortest path to 0,there would be the answer,
    * what is prefect square number: 1,4,9,16,25...
    * Time complexity:O(n*sqrt(n)), Space complexity:O(n)
    * */
    fun numSquares(n: Int): Int {
        if (n == 0) {
            return 0
        }
        val levels = IntArray(n + 1)
        val visited = HashSet<Int>()
        val queue = LinkedList<Int>()
        val start = 0
        //start from 0
        visited.add(start)
        queue.offer(start)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur == n) {
                println("levels[$cur]:${levels[cur]}")
                return levels[cur]
            }
            //Squares number set by i, start from 1
            var i = 1
            while (cur + i * i <= n) {
                val new = cur + i * i
                if (!visited.contains(new)) {
                    visited.add(new)
                    levels[new] = levels[cur] + 1
                    //push new for next level
                    queue.offer(new)
                }
                i++
            }
        }
        return levels[start]
    }
}