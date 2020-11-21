package LeetCode_323

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 323. Number of Connected Components in an Undirected Graph
 * (Prime)
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.

Example 1:
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
0          3
|          |
1 --- 2    4
Output: 2

Example 2:
Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
0           4
|           |
1 --- 2 --- 3
Output:  1
Note:

You can assume that no duplicate edges will appear in edges.
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(e+n), Space complexity:O(n)
    * */
    fun countComponents(n: Int, edges: Array<Pair<Int, Int>>): Int {
        var result = 0
        val visited = BooleanArray(n)
        //create graph
        val graph = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until n) {
            graph.put(i, ArrayList())
        }
        //because it's Undirected
        for (edge in edges) {
            graph[edge.first]!!.add(edge.second)
            graph[edge.second]!!.add(edge.first)
        }
        //queue for BFS
        val queue = LinkedList<Int>()
        for (i in 0 until n) {
            if (visited[i]) {
                continue
            }
            result++
            queue.offer(i)
            while (queue.isNotEmpty()) {
                val cur = queue.poll()
                if (!visited[cur]) {
                    visited[cur] = true
                    val list = graph.get(cur)
                    if (list != null) {
                        for (g in list) {
                            queue.offer(g)
                        }
                    }
                }
            }
        }
        return result
    }
}