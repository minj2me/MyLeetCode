package LeetCode_1443

import java.util.*
import kotlin.collections.ArrayList

/**
 * 1443. Minimum Time to Collect All Apples in a Tree
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
 *
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices.
 * You spend 1 second to walk over one edge of the tree.
 * Return the minimum time in seconds you have to spend in order to collect all apples in the tree
 * starting at vertex 0 and coming back to this vertex.
The edges of the undirected tree are given in the array edges,
where edges[i] = [fromi, toi] means that exists an edge connecting the vertices fromi and toi.
Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple,
otherwise, it does not have any apple.
 * */
class Solution {
    //bfs
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        var result = 0
        //init and fill graph
        val graph = ArrayList<ArrayList<Int>>()
        val parent = Array(n, { -1 })
        val dist = Array(n, { -1 })
        for (i in 0 until n) {
            graph.add(ArrayList())
        }
        for (edge in edges) {
            val start = edge[0]
            val end = edge[1]
            graph[start].add(end)
            //set the node's first visited parent
            parent[end] = start
        }

        //measure the distance from each node from root
        val queue = LinkedList<Int>()
        queue.offer(0)
        dist[0] = 0
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            for (x in graph[cur]) {
                if (dist[x] == -1) {
                    dist[x] = dist[cur] + 1
                    queue.offer(x)
                }
            }
        }

        /*for (i in 0 until parent.size) {
            println("node $i's first visited parent is ${parent[i]}")
        }*/

        //accumulate the distance form each node to its first visited parent
        val visited = BooleanArray(n)
        for (i in n - 1 downTo 0) {
            if (!visited[i] && hasApple[i]) {
                //find the first visited parent of i
                var q = i
                while (parent[q] != -1 && !visited[q]) {
                    visited[q] = true
                    q = parent[q]
                    //now, q point to the first visited parent of i
                }
                visited[i] = true
                result += (dist[i] - dist[q]) * 2
            }
        }
        return result
    }

}