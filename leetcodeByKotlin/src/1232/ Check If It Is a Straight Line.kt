package LeetCode_1232

/**
 * 1232. Check If It Is a Straight Line
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 * */
class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val size = coordinates.size
        val xArray = ArrayList<Int>()
        val yArray = ArrayList<Int>()
        for (coordinate in coordinates) {
            var index = 0
            for (item in coordinate) {
                if (index % 2 == 0) {
                    xArray.add(item)
                } else {
                    yArray.add(item)
                }
                index++
            }
        }
        val xDiff1 = xArray[1] - xArray[0]
        val yDiff1 = yArray[1] - yArray[0]
        //check the slope of the line between two point
        for (i in 2 until size) {
            val xDiff = xArray[i] - xArray[i - 1]
            val yDiff = yArray[i] - yArray[i - 1]
            if (xDiff * yDiff1 != yDiff * xDiff1) {
                return false
            }
        }
        return true
    }
}