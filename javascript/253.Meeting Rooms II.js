/**
 * 253. Meeting Rooms II
 * 
 * https://www.cnblogs.com/grandyang/p/5244720.html
 * 
 * Description
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example
Given intervals = [(0,30),(5,10),(15,20)], return 2.
 */
/**
 * @param {Interval[]} intervals
 * @return {number}
 * 
 * 第二种方法是用两个一维数组来做，分别保存起始时间和结束时间，然后各自排个序，我们定义结果变量res和结束时间指针endpos，然后我们开始遍历，
 * 如果当前起始时间小于结束的时间，则结果自增1，反之结束时间指针自增1，这样我们可以找出重叠的时间段，从而安排新的会议室，参见代码如下
 */
var minMeetingRooms = function (intervals) {
    let start = [];
    let end = [];
    let len = intervals.length;

    for (let i = 0; i < len; i++) {
        start[i] = intervals[i].start;
        end[i] = intervals[i].end;
    }
    //start:0, 5, 15
    //end:  10,20,30

    start.sort((a, b) => a - b);
    end.sort((a, b) => a - b);

    let rooms = 0;
    let endIndex = 0;

    for (let i = 0; i < len; i++) {
        if (start[i] < end[endIndex]) {
            rooms++;
        } else {
            endIndex++;
        }
    }

    return rooms;
};