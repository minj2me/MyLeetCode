package LeetCode_752

import java.util.*
import kotlin.collections.HashSet

/**
 * 752. Open the Lock
 * https://leetcode.com/problems/open-the-lock/
 *
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock,
return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * */
class Solution {
    /*
    * solution: BFS, find the shortest path in weighted undirected graph,
    * "0000" as a node, each node has 8 edge, because each number can roll up or roll down, 4*2=8, each weight is 1;
    * Time complexity: O(8*10000), because 0000-9999 has 10000 status;
    * Space complexity: O(10000)
    * */
    fun openLock(deadends: Array<String>, target: String): Int {
        //put deadends into set, can improve search speed
        val set = HashSet<String>()
        for (item in deadends) {
            set.add(item)
        }
        val start = "0000"
        if (set.contains(start)) {
            return -1
        }
        if (target == start){
            return 0
        }
        val queue = LinkedList<String>()
        val visited = HashSet<String>()
        queue.offer(start)
        visited.add(start)
        var step = 0
        while (queue.isNotEmpty()) {
            step++
            //size represent the count of node in current level
            val size = queue.size
            //expand the node
            for (i in 0 until size){
                val cur = queue.pop()
                //there are 4 number in each node
                for (n in 0 until 4){
                    val c = cur[n]
                    //simulate roll up or roll down
                    val str1 = cur.substring(0,n) + (if (c=='9') 0 else c-'0'+1) + cur.substring(n+1)
                    val str2 = cur.substring(0,n) + (if (c=='0') 9 else c-'0'-1) + cur.substring(n+1)
                    if (str1==target || str2==target){
                        return step
                    }
                    if (!visited.contains(str1) && !set.contains(str1)){
                        visited.add(str1)
                        queue.offer(str1)
                    }
                    if (!visited.contains(str2) && !set.contains(str2)){
                        visited.add(str2)
                        queue.offer(str2)
                    }
                }
            }
        }
        //if not found solution
        return -1
    }
}