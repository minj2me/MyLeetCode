package LeetCode_986

/**
 * 986. Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/description/
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Note:
0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * */
class Solution {
    /*
    * solution: two pointer, Time complexity:O(n), Space complexity:O(n)
    * */
    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        //not ensure the size, so use list first
        val list = ArrayList<IntArray>()
        var i = 0
        var j = 0
        while (i < A.size && j < B.size) {
            val current = IntArray(2)
            //check the interval if overlapping
            val start = Math.max(A[i][0], B[j][0])
            val end = Math.min(A[i][1], B[j][1])
            if (start <= end) {
                current[0] = start
                current[1] = end
                list.add(current)
            }
            if (A[i][1] < B[j][1]) {
                i++
            } else {
                j++
            }
        }
        val result = Array(list.size, { IntArray(2) })
        for (i in list.indices) {
            result[i] = list[i]
        }
        return result
    }
}