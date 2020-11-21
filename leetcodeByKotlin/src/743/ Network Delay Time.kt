package LeetCode_743

import java.util.*
import kotlin.collections.HashMap

/**
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/description/
 * https://blog.csdn.net/afei__/article/details/83780362
 * https://www.cnblogs.com/grandyang/p/8278115.html
 *
 * There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
v is the target node, and w is the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
If it is impossible, return -1
 * */

class NetCode constructor(u_: Int) {
    var u = 0
    val neighbors = HashMap<Int, Int>()//target u and weight
    var distance = Int.MAX_VALUE

    init {
        this.u = u_
    }
}

class Solution {
    /*
    * solution 1: find out the shortest path by Dijkstra Algorithm
    * */
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val map = HashMap<Int, NetCode>()
        //优先队表，sort from small to big
        val queue = PriorityQueue<NetCode>(N) { o1, o2 -> o1.distance - o2.distance }
        //init
        for (i in 1..N) {
            val node = NetCode(i)
            if (i == K) {
                //the start
                node.distance = 0
            }
            map.put(i, node)
            queue.offer(node)
        }

        //update neighbor node
        for (time in times) {
            val node = map.get(time[0])//(u, v, w)
            if (node != null) {
                node.neighbors.put(time[1], time[2])//u,v
            }
        }

        //use dijkstra
        while (!queue.isEmpty()) {
            //the head is the node which smallest distance in PriorityQueue
            val min = queue.poll()
            if (min.distance == Int.MAX_VALUE) {
                return -1
            }
            //relax:更新某个顶点的所有邻据顶点的distance
            for (v in min.neighbors.keys) {
                val curr = map.get(v)
                val distance = min.distance + min.neighbors.get(v)!!//get the weight
                if (curr != null) {
                    if (curr.distance > distance) {
                        //set the small value
                        curr.distance = distance
                        //update the position of curr in queue
                        queue.remove(curr)
                        queue.add(curr)
                    }
                }
            }
        }//end while

        //find the max
        var max = 0
        for (node in map.values) {
            if (node.distance > max) {
                max = node.distance
            }
        }
        return max
    }
}