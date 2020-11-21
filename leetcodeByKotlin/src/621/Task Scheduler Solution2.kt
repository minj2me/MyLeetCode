package LeetCode_621

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/***
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
However, there is a non-negative cooling interval n that means between two same tasks,
there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Constraints:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
class Solution2 {
    /*
    * solution2: HashMap + PriorityQueue,
    * Time complexity:O(nlogn), Space complexity:O(n), n is size of tasks
    * */
    fun leastInterval(tasks: CharArray, n: Int): Int {
        //key is letter, value is frequency
        val map = HashMap<Char, Int>()
        for (task in tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1)
        }
        //define MaxHeap
        //pair: first is char, second is frequency
        val maxHeap = PriorityQueue<Pair<Char, Int>> { a, b ->
            if (a.second == b.second) {
                /*
                * sort by latter: a,b,c...
                * */
                a.first - b.first
            } else {
                b.second - a.second
            }
        }
        //put all task in heap
        for (item in map) {
            maxHeap.offer(Pair(item.key, item.value))
        }
        var count = 0
        while (maxHeap.isNotEmpty()) {
            var k = n + 1
            val temp = ArrayList<Pair<Char, Int>>()
            while (k > 0 && maxHeap.isNotEmpty()) {
                var cur = maxHeap.poll()
                //decrease frequency, meaning task executed
                val newFrequency = cur.second - 1
                //because Pair like most data classes, is immutable, so we need use copy to change it's value
                cur = cur.copy(second = newFrequency)
                //check some if can put back to queue
                if (cur.second != 0) {
                    temp.add(cur)
                }
                //reduce the space count
                k--
                //execute task successfully
                count++
            }
            //put back to queue
            for (item in temp) {
                maxHeap.offer(item)
            }
            if (maxHeap.isEmpty()) {
                break
            }
            //if k > 0, then it mean we need to be idle
            count += k
        }
        return count
    }
}