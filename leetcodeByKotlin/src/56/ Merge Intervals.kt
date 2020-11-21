package LeetCode_56

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * */
class Solution {
    /*
    * solution: sort intervals, Time:O(nlogn), Space:O(n)
    * */
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals == null || intervals.size <= 1) {
            return intervals
        }
        val result = ArrayList<IntArray>()
        /*
        * for example: [[1,4],[0,4]],
        * after sort: [[0,4],[1,4]]
        * */
        intervals.sortWith(Comparator { a, b -> a[0] - b[0] })
        /*for (item in intervals){
            item.forEach { print(it) }
        }*/
        for (i in intervals.indices) {
            //if current start > prev.end, insert into new one
            if (result.size == 0 || intervals[i][0] > result.get(result.size - 1)[1]) {
                result.add(intervals[i])
            } else {
                //change the end value of the last element
                result.get(result.size - 1)[1] = Math.max(result.get(result.size - 1)[1], intervals[i][1])
            }
        }
        val size = result.size
        val resultArray = Array(size, { IntArray(2) })
        for (i in 0 until size) {
            resultArray.set(i, result.get(i))
        }
        return resultArray
    }
}