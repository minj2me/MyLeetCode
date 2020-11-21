package LeetCode_252

import java.util.Arrays

/**
 * 252. Meeting Rooms
 * (Lock by Leetcode)
 * https://www.lintcode.com/problem/meeting-rooms/description
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * */

class Interval(start: Int, end: Int) {
    var start = 0
    var end = 0
    init {
        this.start = start
        this.end = end
    }
}

class Solution {
    fun canAttendMeetings(intervals: List<Interval>?): Boolean {
        if (intervals == null) {
            return false
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

        for (i in 1 until size) {
            if (ends[i - 1] > starts[i]) {
                return false
            }
        }
        return true
    }
}