/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 * http://www.cnblogs.com/grandyang/p/4367569.html
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @param {Interval} newInterval
 * @return {Interval[]}
 */
var insert = function (intervals, newInterval) {
    let len = intervals.length;
    let result = [];
    let insertIndex = 0;
    //[[4,6],[7,9]], newInterval = [2,6]
    //[[8,9],[3,5],[6,7],[8,10],[12,16]]
    //newInterval = [4,8]
    for (let i = 0; i < len; i++) {
        let cur = intervals[i];
        if (cur.start > newInterval.end) {
            result.push(cur);
        } else if (cur.end < newInterval.start) {
            result.push(cur);
            insertIndex++;
        } else {
            //chnage newInterval.start and newInterval.end 
            newInterval.start = Math.min(newInterval.start, cur.start);
            newInterval.end = Math.max(newInterval.end, cur.end);
            // console.log("===cur:");
            // console.log(cur);
            // console.log("===newInterval:");
            // console.log(newInterval);
        }
    }
    console.log("insertIndex:" + insertIndex);
    // let howmany = 0;//必需。要删除的项目数量。如果设置为 0，则不会删除项目。
    result.splice(insertIndex, 0, newInterval);
    return result;
};
