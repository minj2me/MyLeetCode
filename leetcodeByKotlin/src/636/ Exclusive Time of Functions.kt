package LeetCode_636

import java.util.*

/**
 * 636. Exclusive Time of Functions
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 *
 * On a single threaded CPU, we execute some functions.
 * Each function has a unique id between 0 and N-1.
We store logs in timestamp order that describe when a function is entered or exited.
Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".
For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.
"1:end:2" means the function with id 1 ended at the end of timestamp 2.
A function's exclusive time is the number of units of time spent in this function.
Note that this does not include any recursive calls to child functions.
The CPU is single threaded which means that only one function is being executed at a given time unit.
Return the exclusive time of each function, sorted by their function id.

Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]

Note:
1. 1 <= n <= 100
2. Two functions won't start or end at the same time.
3. Functions will always log when they exit.
 * */
class Solution {
    /*
    * solution: Stack,start to push in Stack, then end to pop from Stack
    * Time complexity:O(n), Space complexity:O(n/2), because do push and pop almost at the same time
    * */
    fun exclusiveTime(n: Int, logs: List<String>): IntArray? {
        //save functionId
        val stack = Stack<Int>()
        val result = IntArray(n)
        //help to record the time of each log
        var prev = 0
        for (log in logs) {
            val list = log.split(":")
            //get the value
            val functionId = list.get(0).toInt()
            val operation = list.get(1)
            val time = list.get(2).toInt()
            //if functionId exist, update the time of current functionId
            if (stack.isNotEmpty()) {
                result[stack.peek()] += time - prev
            }
            prev = time
            if (operation == "start") {
                stack.push(functionId)
            } else {
                //like suspend it, add time after finish current job then pop it from stack
                result[stack.pop()]++
                prev++
            }
        }
        return result
    }
}