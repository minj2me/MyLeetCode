package LeetCode_939

/**
 * 939. Minimum Area Rectangle
 * https://leetcode.com/problems/minimum-area-rectangle/
 *
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
 * with sides parallel to the x and y axes.
 * If there isn't any rectangle, return 0.

Example 1:
Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4

Example 2:
Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2

Note:
1. 1 <= points.length <= 500
2. 0 <= points[i][0] <= 40000
3. 0 <= points[i][1] <= 40000
4. All points are distinct.
 * */
class Solution {
    /*
    * solution: HashMap + HashSet, find out 4 points via 2 diagonal point,
    * Time:O(n^2), Space:O(n)
    * */
    fun minAreaRect(points: Array<IntArray>): Int {
        if (points == null || points.isEmpty()) {
            return 0
        }
        //key: x, value: the set of y which has same x value
        val map = HashMap<Int, HashSet<Int>>()
        for (point in points) {
            val x = point[0]
            val y = point[1]
            if (!map.contains(x)) {
                map.put(x, HashSet<Int>())
            }
            map.get(x)!!.add(y)
        }
        //map: {1=[1, 3], 2=[2], 3=[1, 3]}
        var minArea = Int.MAX_VALUE
        val n = points.size
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val x1 = points[i][0]
                val y1 = points[i][1]
                val x2 = points[j][0]
                val y2 = points[j][1]
                //same x or same y,not a diagonal point
                if (x1 == x2 || y1 == y2) {
                    continue
                }
                //exist other two point if diagonal exits
                if (map.get(x1)!!.contains(y2) && map.get(x2)!!.contains(y1)) {
                    val area = Math.abs(y2 - y1) * Math.abs(x2 - x1)
                    minArea = Math.min(minArea, area)
                }
            }
        }
        return if (minArea == Int.MAX_VALUE) 0 else minArea
    }
}