package LeetCode_84

import java.util.*

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * */
class Solution {
    /*
    * solution 1: brute force, Time complexity:O(n^2), Space complexity:O(1)
    * solution 2:Stack, Time complexity:O(n), Space complexity:O(n)
    * */
    fun largestRectangleArea(heights: IntArray): Int {
        var res = 0
        /*val n = heights.size
        for (i in 0 until n) {
            var minH = heights[i]
            //keep tracking it left hand side, find out the minimum height to calculate area
            for (j in i downTo 0) {
                minH = Math.min(minH, heights[j])
                //area = width * min_height
                val area = minH * (i - j + 1)
                res = Math.max(area, res)
            }
        }*/

        val stack = Stack<Int>()
        var i = 0
        while (i < heights.size) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i)
                i++
            } else {
                //calculate max when current height less than the previous one
                val currentIndex = stack.pop()
                val h = heights[currentIndex]
                val w = if (stack.isEmpty()) i else i - stack.peek() - 1
                res = Math.max(res, w * h)
            }
        }
        //handle stack is not empty situation, for example input:[1]
        while (stack.isNotEmpty()) {
            val index = stack.pop()
            val h = heights[index]
            val w = if (stack.isEmpty()) i else i - stack.peek() - 1
            res = Math.max(res, w * h)
        }
        return res
    }
}