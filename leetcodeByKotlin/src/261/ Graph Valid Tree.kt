package LeetCode_261

import java.util.*

/**
 * 261. Graph Valid Tree
 * Lock by leetcode
 * https://www.lintcode.com/problem/graph-valid-tree/description
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
You can assume that no duplicate edges will appear in edges.
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * */
class Solution {
    /*
    solution: bfs, valid Tree, must a connected graph and acyclic;
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val graph = HashMap<Int, ArrayList<Int>>()
        //init
        for (i in 0 until n) {
            graph[i] = ArrayList()
        }
        //create graph
        for (edge in edges) {
            graph[edge.get(0)]!!.add(edge.get(1))
            graph[edge.get(1)]!!.add(edge.get(0))
        }
        val visited = BooleanArray(n)
        val queue = LinkedList<Int>()
        //0 is a start point
        queue.offer(0)

        while (!queue.isEmpty()) {
            val top = queue.poll()
            if (visited[top]) {
                //if node visited, mean got a cyclic, so not a valid tree
                return false
            }
            visited[top] = true
            val list = graph[top]
            if (list == null) {
                continue
            }
            for (item in list) {
                if (!visited[item]) {
                    queue.offer(item)
                }
            }
        }

        for (v in visited) {
            //if some node visited, mean got a cyclic, so not a valid tree
            if (!v) {
                return false
            }
        }

        return true
    }
}