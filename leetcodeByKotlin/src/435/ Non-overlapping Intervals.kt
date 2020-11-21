package LeetCode_435

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:
Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Example 3:
Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * */
class Solution {
    /*
    * solution: sort intervals by end increasing, Time complexity:O(nlogn), Space complexity:O(1)
    * */
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var result = 0
        if (intervals.isEmpty()) {
            return result
        }
        //sort by end
        intervals.sortWith(Comparator { a, b -> a[1] - b[1] })
        var last = intervals[0]
        for (i in 1 until intervals.size) {
            val cur = intervals[i]
            //if cur.start < last.end overlapping
            if (cur[0] < last[1]) {
                result++
            } else {
                //update last one
                last = cur
            }
        }
        return result
    }
}