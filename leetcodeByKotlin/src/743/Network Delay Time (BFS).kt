package LeetCode_743

import java.util.*
import kotlin.collections.ArrayList

/**
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * There are N network nodes, labelled 1 to N.
Given times, a list of travel times as directed edges times[i] = (u, v, w),
where u is the source node,
v is the target node,
w is the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
If it is impossible, return -1

Note:
1. N will be in the range [1, 100].
2. K will be in the range [1, N].
3. The length of times will be in the range [1, 6000].
4. All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * */
class Solution2 {
    /*
    * solution:BFS + Bellman Ford, to find out the shortest path,
    * Time complexity:O(E+V), Space complexity:O(E+V), E: size of times, V: N
    * times[0]:source node
    * times[1]:target node
    * times[2]:the time from source to target (weight)
    * */
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        var res = 0
        //create adjacency list
        val graph = ArrayList<ArrayList<Pair<Int, Int>>>()
        for (i in 0..N) {
            graph.add(ArrayList())
        }
        for (time in times) {
            //init graph: source->target, and weight
            graph.get(time[0]).add(Pair(time[1], time[2]))
        }
        val distance = IntArray(N + 1) { Int.MAX_VALUE }
        //the starting
        distance[K] = 0
        val visited = BooleanArray(N + 1)
        val queue = LinkedList<Int>()
        queue.offer(K)
        visited[K] = true
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            visited[cur] = false
            for (edge in graph.get(cur)) {
                val target = edge.first
                val weight = edge.second
                if (distance[cur] != Int.MAX_VALUE && distance[cur] + weight < distance[target]) {
                    //relaxation
                    distance[target] = distance[cur] + weight
                    if (visited[target]) {
                        continue
                    }
                    visited[target] = true
                    queue.offer(target)
                }
            }
        }
        //the result is the max distance can reach each node
        for (i in 1..N) {
            res = Math.max(res, distance[i])
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}