package LeetCode_11

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines,
 * which, together with the x-axis forms a container, such that the container contains the most water.
Notice that you may not slant the container.
 * */
class Solution {
    /*
    * solution: two pointer, Time:O(n), Space:O(1)
    * */
    fun maxArea(height: IntArray): Int {
        var area = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            //根据木桶原理(Cannikin Law),面积是决定在shortest plank
            val h = Math.min(height[left], height[right])
            //area = h*w
            val currentArea = h * (right - left)
            area = Math.max(area, currentArea)
            //move the small one
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return area
    }
}