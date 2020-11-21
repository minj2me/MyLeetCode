package LeetCode_787

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 787. Cheapest Flights Within K Stops
https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst,
your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
 * */
class Solution {
    /**
     * solution:bfs, Time complexity:O(K*n^2), Space complexity:O(n)
     * */
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        //create graph
        //Pait: first is distance, second is cost to distance
        val graph = HashMap<Int, ArrayList<Pair<Int, Int>>>()
        for (flight in flights) {
            val form = flight[0]//u
            val to = flight[1]//v
            val cost = flight[2]//w
            if (!graph.contains(form)) {
                graph.put(form, ArrayList())
            }
            graph.get(form)?.add(Pair(to, cost))
        }
        var result = Int.MAX_VALUE
        var step = 0
        val queue = LinkedList<Pair<Int, Int>>()
        //represent need cost nothing to start
        queue.offer(Pair(src, 0))
        while (queue.isNotEmpty()) {
            //compare with all node
            for (i in 0 until queue.size) {
                val top = queue.pop()
                val curLocation = top.first
                val cost = top.second
                if (curLocation == dst) {
                    result = Math.min(result, cost)
                }
                val list = graph.get(curLocation)
                if (list != null) {
                    for (item in list) {
                        //current total cost to next location
                        if (cost + item.second > result) {
                            continue//purnning
                        }
                        queue.offer(Pair(item.first, cost + item.second))
                    }
                }
            }
            if (step++ > K) {
                break
            }
        }
        return if (result == Int.MAX_VALUE) -1 else result
    }
}