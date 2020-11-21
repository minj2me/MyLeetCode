package LeetCode_57

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
 * */
class Solution {
    /**
     * solution:
     * 1.insertion sort
     * 2.merge intervals
     * Time complexity:O(n), Space complexity:O(n)
     * */
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray>? {
        //1. find out the position to insert newInterval
        var index = 0
        val list = ArrayList<IntArray>()
        //if newInterval.start > the first one's start
        for (item in intervals) {
            if (newInterval[0] > item[0]) {
                index++
            }
        }
        for (item in intervals) {
            list.add(item)
        }
        list.add(index, newInterval)

        //2.merge intervals
        val resultList = ArrayList<IntArray>()
        for (item in list) {
            //if current start > prev.end, insert into new one
            if (resultList.isEmpty() || item[0] > resultList.get(resultList.size - 1)[1]) {
                resultList.add(item)
            } else {
                //change the end value of the last element
                resultList.get(resultList.size - 1)[1] = Math.max(resultList.get(resultList.size - 1)[1], item[1])
            }
        }
        val size = resultList.size
        val resultArray = Array(size, { IntArray(2) })
        for (i in 0 until size) {
            resultArray.set(i, resultList.get(i))
        }
        /*for (item in resultArray){
            item.forEach { print("$it,") }
        }*/
        return resultArray
    }
}