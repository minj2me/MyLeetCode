package LeetCode_452

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 *
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 104 balloons.
An arrow can be shot up exactly vertically from different points along the x-axis.
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:
Input:
[[10,16], [2,8], [1,6], [7,12]]
Output:
2
Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and
another arrow at x = 11 (bursting the other two balloons).
 * */
class Solution {
    /*
    * solution: sort array increasing by right, then keep tracking the right
    * Time complexity:O(nlogn), Space complexity:O(1)
    * */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points == null || points.isEmpty()) {
            return 0
        }
        //have one balloon, so need one arrow
        var result = 1
        //sorting by the right
        points.sortWith(Comparator { a, b -> a[1] - b[1] })
        var right = points[0][1]
        for (item in points) {
            //if left large than current right, mean need new arrow
            if (item[0] > right) {
                //update the right
                right = item[1]
                result++
            }
        }
        return result
    }
}