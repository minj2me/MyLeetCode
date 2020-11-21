package LeetCode_42

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 * */
class Solution {
    fun trap(height: IntArray): Int {
        /*
        * 当前点的水量等于他左边的最高值与右边的最高值的差-当前点的量
        * val n = height.size
        * iVal = min(max(height[0,i]), max(height[i,n-1])) - height[i]
        *
        * time complexity O(n*n)
        * space complexity O(1)
        *
        * 还可以优化！
        * */
        var result = 0
        val n = height.size
        for (i in 0 until n) {
            var left = height[i]
            //find the maximum element in its left
            for (l in 0 until i) {
                left = Math.max(left, height[l])
            }
            var right = height[i]
            //find the maximum element in its right
            for (r in i until n) {
                right = Math.max(right, height[r])
            }
            result += Math.min(left, right) - height[i]
        }
        return result
    }
}