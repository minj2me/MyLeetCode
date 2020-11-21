package LeetCode_681

/**
 * 681. Next Closest Time
 * (Prime)
 * https://www.lintcode.com/problem/next-closest-time/description
 *
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
You may assume the given input string is always valid.
For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:
Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example 2:
Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 * */
class Solution {
    /*
    * solution: brute force, check the new time via adding every minute by 1,
    * Time complexity:O(24*60), Space complexity:O(1)
    * */
    fun nextClosestTime(time: String): String {
        if (time == null || time.length < 5) {
            return ""
        }
        //get hour and minute
        var hour = time.substring(0, 2).toInt()
        var minute = time.substring(3, 5).toInt()
        while (true) {
            //check the time via adding every minute by 1
            if (minute++ > 60) {
                minute = 0
                hour++
                hour %= 24
            }
            //generate new time string after adding one minute
            //%d: Int
            //02: mean can insert two leading zero
            val cur = String.format("%02d:%02d", hour, minute)
            var valid = true
            for (i in cur.indices) {
                //check time's every latter if in new time string
                if (time.indexOf(cur[i]) < 0) {
                    valid = false
                    break
                }
            }
            if (valid) {
                return cur
            }
        }
        //return time
    }
}