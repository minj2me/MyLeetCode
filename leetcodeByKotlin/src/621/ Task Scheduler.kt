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
class Solution {
    /*
    * 思路是建立一个优先队列，然后把统计好的个数都存入优先队列中，那么大的次数会在队列的前面。
    * 这题还是要分块，每块能装n+1个任务，装任务是从优先队列中取，每个任务取一个，装到一个临时数组中，然后遍历取出的任务，
    * 对于每个任务，将其哈希表映射的次数减1，
    * 如果减1后，次数仍大于0，则将此任务次数再次排入队列中，遍历完后如果队列不为空，说明该块全部被填满，则结果加上n+1。
    * 我们之前在队列中取任务是用个变量cnt来记录取出任务的个数，我们想取出n+1个，如果队列中任务数少于n+1个，
    * 那就用cnt来记录真实取出的个数，当队列为空时，就加上cnt的个数
    * */
    fun leastInterval(tasks: CharArray, n: Int): Int {
        //To work on the same task again, CPU has to wait for time n,
        //therefore we can think of as if there is a cycle, of time n+1
        val cycle = n + 1
        val map = HashMap<Char, Int>()
        for (task in tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1)
        }
        //max heap
        val queue = PriorityQueue<Int>{a,b->b-a}
        for (item in map) {
            //save frequency in queue
            queue.add(item.value)
        }
        var allTime = 0
        while (queue.isNotEmpty()) {
            var workTime = 0
            //save task in temp
            val temp = ArrayList<Int>()
            for (i in 0 until cycle) {
                if (queue.isNotEmpty()) {
                    //println("queue.size:${queue.size}")
                    println("temp.add(${queue.peek()})")
                    //add high frequency task
                    temp.add(queue.poll())
                    workTime++
                }
            }
            for (i in temp.indices) {
                //println("temp[$i]")
                if (--temp[i] > 0) {
                    queue.add(temp[i])
                    println("queue.add:${temp[i]}")
                }
            }
            allTime += if (queue.isEmpty()) workTime else cycle
        }

        //solution 2: array
        /*val array = IntArray(26)
        for (c in tasks) {
            array[c - 'A']++
        }
        array.sort()
        val maxVal = array[25]-1
        println(maxVal)
        var idelSlots = maxVal * n
        println(idelSlots)
        for (item in array){
            print(item)
            print(",")
        }
        println()
        for (i in 24 downTo 0) {
            idelSlots -= Math.min(array[i], maxVal)
        }
        result = if (idelSlots > 0) idelSlots + tasks.size else tasks.size*/
        println(allTime)
        return allTime
    }
}