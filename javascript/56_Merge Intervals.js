/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 * 
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function (intervals) {
    let len = intervals.length;
    let cur = null;
    let result = [];
    let resultLen;

    if (len <= 1)
        return intervals;

    //time complexity: O(nlogn),because will Merge
    //space complexity: O(n)

    //sort it first
    intervals.sort(function (a, b) {
        if (a.start < b.start)
            return -1;
        else if (a.start > b.start)
            return 1
        else
            return a.end - b.end;
    });

    for (let i = 0; i < len; i++) {
        resultLen = result.length;
        cur = intervals[i];
        if (resultLen == 0 || cur.start > result[resultLen - 1].end) {
            result.push(cur);//insert a new intervals
        } else {
            //if cur.start<=last.end, Merge intervals
            result[resultLen - 1].end = Math.max(result[resultLen - 1].end, cur.end);
        }
    }

    return result;
};