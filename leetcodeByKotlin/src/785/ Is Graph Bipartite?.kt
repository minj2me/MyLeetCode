package LeetCode_785

import java.util.*

/**
 * 785. Is Graph Bipartite? (是否二分图)
 * https://leetcode.com/problems/is-graph-bipartite/description/
 *
 * Given an undirected graph, return true if and only if it is bipartite.
Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
Each node is an integer between 0 and graph.length - 1.
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.

Note:
graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(V+E), Space complexity:O(V)
    * */
    private var colorArray: IntArray? = null

    fun isBipartite(graph: Array<IntArray>): Boolean {
        val n = graph.size
        //set the color array
        //-1:no color, 0:red, 1:blue
        colorArray = IntArray(n,{-1})
        for (i in 0 until n) {
            if (colorArray!![i] == -1) {
                colorArray!![i] = 0
                if (!computingColor(graph, i)) {
                    return false
                }
            }
        }
        return true
    }

    private fun computingColor(graph: Array<IntArray>, current: Int): Boolean {
        val queue = LinkedList<Int>()
        queue.offer(current)
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            val color = colorArray!![temp]
            //find all non-color adjacent
            for (i in graph[temp]) {
                if (colorArray!![i] == -1) {
                    //to give opposite color to neighbour
                    colorArray!![i] = (color.xor(1))
                    queue.offer(i)
                } else {
                    if (colorArray!![i]!=(color.xor(1))){
                        return false
                    }
                }
            }
        }
        return true
    }
}