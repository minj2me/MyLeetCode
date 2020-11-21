package LeetCode_279

import java.util.*

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
class Solution2 {
    /*
    * solution:bfs+HashSet, lets say n as root of tree, scan level by level, find out the shortest path to 0,there would be the answer,
    * what is prefect square number: 1,4,9,16,25...
    * Time complexity:O(n*sqrt(n)), Space complexity:O(n)
    * */
    fun numSquares(n: Int): Int {
        if (n == 0) {
            return 0
        }
        val visited = HashSet<Int>()
        var level = 0
        val queue = LinkedList<Int>()
        queue.offer(n)
        visited.add(n)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.pop()
                if (cur == 0) {
                    return level
                }
                //put the square root of cur into queue for next level
                val sqrt = Math.sqrt(cur.toDouble())
                for (num in 1..sqrt.toInt()) {
                    val newNum = cur - num * num
                    if (visited.contains(newNum)){
                        continue
                    }
                    queue.offer(newNum)
                    visited.add(newNum)
                }
            }
            level++
        }
        return level
    }
}