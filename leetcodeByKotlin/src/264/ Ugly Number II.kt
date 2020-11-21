package LeetCode_264

import java.util.*

/**
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:
1 is typically treated as an ugly number.
n does not exceed 1690.
 * */
class Solution {
    /*
      solution 1: bruce force, TLE, Time complexity:O(nlogn), Space complexity:O(1)
    * solution 2: Min Heap, Time complexity:O(nlogn), Space complexity:O(n);
    * */
    fun nthUglyNumber(n: Int): Int {
        //solution 1
        /*var i = n
        var num = 1
        while (n > 0) {
            if (isUgly(num)) {
                i--
            }
            if (i == 0) {
                break
            }
            num++
        }
        return num*/

        //solution 2
        val factorsList = listOf(2, 3, 5)
        val queue = PriorityQueue<Long>()
        var result = 1L
        queue.offer(result)
        for (i in 0 until n) {
            result = queue.poll()
            for (factor in factorsList) {
                val uglyNum = result * factor
                if (!queue.contains(uglyNum)) {
                    queue.offer(uglyNum)
                }
            }
        }
        return result.toInt()
    }

    private fun isUgly(num_: Int): Boolean {
        var num = num_
        val factorsList = listOf(2, 3, 5)
        for (factor in factorsList) {
            while (num % factor == 0) {
                num /= factor
            }
        }
        return num == 1
    }
}