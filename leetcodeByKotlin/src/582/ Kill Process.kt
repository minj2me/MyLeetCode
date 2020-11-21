package LeetCode_582

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 582. Kill Process
 * (Prime)
 *Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
Each process only has one parent process, but may have one or more children processes.
This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process.
All the PIDs will be distinct positive integers.
We use two list of integers to represent a list of processes,
where the first list contains PID for each process and the second list contains the corresponding PPID.
Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end.
You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:
Input:
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation:
    3
  /  \
 1    5
     /
    10
Kill 5 will also kill 10.

Note:
1. The given kill id is guaranteed to be one of the given PIDs.
2. n >= 1.
 * */
class Solution {
    /*
    * Solution: BFS + HashMap, hashmap to create relation of pid and ppid,
    * for example:
    * pid =  [1, 3, 10, 5] , ppid = [3, 0, 5, 3], map is: {0=[3], 3=[1, 5], 5=[10]};
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun killProcess(pid:IntArray, ppid:IntArray, kill:Int): List<Int>{
        val result = ArrayList<Int>()
        //key is ppid, value is list of children
        val map = HashMap<Int,ArrayList<Int>>()
        for (i in pid.indices){
            val ppidValue = ppid[i]
            if (!map.containsKey(ppidValue)){
                map.put(ppidValue,ArrayList())
            }
            map.get(ppidValue)?.add(pid[i])
        }

        val queue = LinkedList<Int>()
        //put the ppid would like to kill
        queue.offer(kill)
        while (queue.isNotEmpty()){
            val p = queue.poll()
            result.add(p)
            //get it children list
            val list = map.get(p)
            if (list != null){
                for (item in list){
                    queue.offer(item)
                }
            }
        }

        return result
    }
}