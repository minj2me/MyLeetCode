package LeetCode_253

import LeetCode_252.Interval
import java.util.Arrays

/**
 * 253. Meeting Rooms II
 * (Lock by Leetcode)
 * https://www.lintcode.com/problem/meeting-rooms-ii/description
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1
 * */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>?): Int {
        if (intervals == null || intervals.size == 0) {
            return 0
        }
        val size = intervals.size

        val starts = IntArray(size)
        val ends = IntArray(size)

        for (i in 0 until size) {
            starts[i] = intervals[i].start
            ends[i] = intervals[i].end
        }

        Arrays.sort(starts)
        Arrays.sort(ends)

        var room = 0
        var endIndex = 0

        /*
        * 如果当前起始时间小于结束时间指针的时间，则结果自增1，反之结束时间指针自增1，这样可以找出重叠的时间段，从而安排新的会议室
        * for example: [0, 30],[5, 10],[15, 20]
        * after sorted:
        * starts: 0,5,15
        * ends:  10,20,30
        *
        * [[7,10],[2,4]]
        * after sorted:
        * starts: 2, 7
        * ends:   4, 10
        * */
        for (i in 0 until size) {
            if (starts[i] < ends[endIndex]) {
                //once overlaps, room++
                room++
            } else {
                //not overlapping, release prev meeting room
                endIndex++
            }
        }

        return room
    }
}