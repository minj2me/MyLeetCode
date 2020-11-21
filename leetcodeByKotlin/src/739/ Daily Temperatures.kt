package LeetCode_739

import java.util.*

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
your output should be [1, 1, 4, 2, 1, 1, 0, 0].
Note: The length of temperatures will be in the range [1, 30000].
Each temperature will be an integer in the range [30, 100].
 * */
class Solution {
    /*
    * solution: monotonic stack to help us to find the index of first large element,
    * if current T large than the stack one, calculate the range;
    * Time complexity:O(n), because each element just access one time;
    * Space complexity:O(n)
    * */
    fun dailyTemperatures(T: IntArray): IntArray {
        val result = IntArray(T.size)
        val stack = Stack<Int>()
        for (i in T.indices) {
            /*
            * for example: [73, 74]
            * found out 74 large than 73, set the result index is stack.peek(), value is subtraction of two index
            * */
            while (stack.isNotEmpty() && T[i] > T[stack.peek()]) {
                //if current one large than the stack one, pop it to help keep track next pair
                val idx = stack.pop()
                result[idx] = i - idx
            }
            stack.push(i)
        }
        return result
    }
}