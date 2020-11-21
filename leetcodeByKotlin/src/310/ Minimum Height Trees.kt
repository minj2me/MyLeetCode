package LeetCode_310

import java.util.*
import kotlin.collections.ArrayList

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 * For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
Format
The graph contains n nodes which are labeled from 0 to n - 1.
You will be given the number n and a list of undirected edges (each edge is a pair of labels).
You can assume that no duplicate edges will appear in edges.
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :
Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
   0
   |
   1
  / \
 2   3
Output: [1]

 * 说明:
1. 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
2. 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 * */
class Solution {
    /*
    * solution:BFS, reduce the in-degree of each node,Time complexity:O(V+E), Space complexity:O(V+E)
    * */
    fun findMinHeightTrees(n_: Int, edges: Array<IntArray>): List<Int> {
        val n = n_
        var result = ArrayList<Int>()
        if (n == 0) {
            return result
        }
        if (n == 1) {
            result.add(0)
            return result
        }

        val indegree = IntArray(n)
        //init and create graph
        val graph = ArrayList<ArrayList<Int>>()
        for (i in 0 until n) {
            graph.add(ArrayList())
        }
        for (edge in edges) {
            graph.get(edge[0]).add(edge[1])
            graph.get(edge[1]).add(edge[0])
            indegree[edge[0]]++
            indegree[edge[1]]++
        }

        val queue = LinkedList<Int>()
        for (i in 0 until n) {
            if (indegree[i]==0){
                return result
            } else if (indegree[i]==1){
                //add leaf node into queue
                queue.offer(i)
            }
        }

        while (queue.isNotEmpty()) {
            result = ArrayList()
            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.poll()
                //result is one or two remaining node
                result.add(cur)
                indegree[cur]--
                //find out leaf node's connect node
                for (k in graph[cur].indices) {
                    val next = graph.get(cur).get(k)
                    if (indegree[next]==0){
                        continue
                    }
                    if (indegree[next]==2) {
                        queue.offer(next)
                    }
                    indegree[next]--
                }
            }
        }

        return result
    }
}