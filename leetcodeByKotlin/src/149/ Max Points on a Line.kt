package LeetCode_149

/**
 * 149. Max Points on a Line
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
 * */
class Solution {
    /*
    * solution: math, calculate same slope of each point;get slope of two point: (y2-y1)/(x2-x1)
    * Time complexity:O(n^2), Space complexity:O(n)
    * */
    fun maxPoints(points: Array<IntArray>): Int {
        var res = 0
        if (points == null || points.isEmpty()) {
            return 0
        }
        if (points.size <= 2) {
            return points.size
        }
        val n = points.size
        //val map = HashMap<String, Int>()
        val map = HashMap<Double, Int>()
        for (i in 0 until n) {
            map.clear()
            //key is slope of a point
            //value is the count of same slope
            var duplicate = 0
            var sameX = 0
            for (j in (i+1) until n) {
                if (i == j) {
                    continue
                }
                val deltaX = points[j][0] - points[i][0]
                val deltaY = points[j][1] - points[i][1]
                //the point overlapping
                if (deltaX == 0 && deltaY == 0) {
                    duplicate++
                    //avoid case:[[1,1],[1,1],[1,1]]
                    //continue
                }
                if (points[j][0] == points[i][0]) {
                    sameX++
                    continue
                }
                val slope = (points[j][1] - points[i][1]).toDouble() / (points[j][0] - points[i][0]).toDouble()
                if (map.contains(slope)) {
                    map.put(slope, map.get(slope)!! + 1)
                } else {
                    map.put(slope, 2)
                }
                res = Math.max(res, map.get(slope)!! + duplicate)
            }
            res = Math.max(res, sameX)
        }
        return res
    }

    //return the greatest common divisor
    /*private fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return gcd(b, a % b)
    }*/
}