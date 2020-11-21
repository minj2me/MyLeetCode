package LeetCode_1557

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 *
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
 * and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
Find the smallest set of vertices from which all nodes in the graph are reachable.
It's guaranteed that a unique solution exists.
Notice that you can return the vertices in any order.
 * */
class Solution {
    /*
    * solution: In degree, the node's in-degree is 0 which will be the answer, Time complexity:O(V+E), Space complexity:O(V)
    * */
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val result = ArrayList<Int>()
        val indegree = IntArray(n)
        //calculate the count of toI (in-degree)
        for (edge in edges) {
            indegree[edge[1]]++
        }

        for (i in 0 until n) {
            if (indegree[i] == 0) {
                result.add(i)
            }
        }

        return result
    }
}