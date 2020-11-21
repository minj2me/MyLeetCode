/**
 * [2,5][6,10]
 * @param {*} intervals 
 */
var canAttendMeetings = function (intervals) {
    for (let i = 0; i < intervals.size(); i++) {
        for (let j = i + 1; j < intervals.size(); j++) {
            if (intervals[i].start >= intervals[j].start && intervals[i].start < intervals[j].end ||
                intervals[j].start >= intervals[i].start && intervals[j].start < intervals[i].end)
                return false;
        }
    }
    return true;
}