package LeetCode_729

import java.util.*

/**
 * 729. My Calendar I
 * https://leetcode.com/problems/my-calendar-i/description/
 * https://zxi.mytechroad.com/blog/algorithms/binary-search/leetcode-729-my-calendar-i/
 *
 * Implement a MyCalendar class to store your events.
 * A new event can be added if adding the event will not cause a double booking.
Your class will have the method, book(int start, int end).
Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking.
Otherwise, return false and do not add the event to the calendar.
Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * */
class MyCalendar() {
    /*
    * solution 1: brute force, Time complexity:O(n^2), Space complexity:O(n);
    *
    * solution 2: binary search(TreeMap), Time complexity:O(nlogn), Space complexity:O(n);
    * 1. key = start;
    * 2. floor: largest entry whose key <= query key;
    * 3. ceiling: smallest entry whose key > query key;
    * 4. check floor and ceiling each time;
    * overlapping situation:
    * floor.end > query.start OR ceiling.start < query.end
    * */

    val calendar = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        //floor: largest entry whose key <= query key;
        val floorValue = calendar.floorKey(start)
        if (floorValue != null && calendar.get(floorValue)!! > start) {
            //overlapping
            return false
        }
        //ceiling: smallest entry whose key > query key;
        val ceilingValue = calendar.ceilingKey(start)
        if (ceilingValue != null && ceilingValue < end) {
            //overlapping
            return false
        }
        calendar.put(start, end)
        return true
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */