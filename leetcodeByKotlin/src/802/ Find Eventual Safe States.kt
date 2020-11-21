package LeetCode_802

/**
 * 802. Find Eventual Safe States
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 *
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.
 * If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.
More specifically, there exists a natural number K so that for any choice of where to walk,
we must have stopped at a terminal node in less than K steps.
Which nodes are eventually safe?  Return them as an array in sorted order.
The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.
The graph is given in the following form:
graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]

Note:
graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 * */
class Solution {
    /*
    * solution: DFS, check the vertex if can go through or not, if go into a circle, is not safe;
    * [[1,2],[2,3],[5],[0],[5],[],[]] represent vertex 0 connected vertex 1,2;
    * Time complexity:O(v+e), Space complexity:O(v+e)
    * */
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        //value 0:unvisited, 1:visiting, 2:visited
        val visited = IntArray(n)
        val result = ArrayList<Int>()
        for (i in 0 until n) {
            if (dfs(i, graph, visited)) {
                result.add(i)
            }
        }
        return result
    }

    private fun dfs(index: Int, graph: Array<IntArray>, visited: IntArray): Boolean {
        if (visited[index] > 0) {
            return visited[index] == 2
        }
        visited[index] = 1
        for (child in graph[index]) {
            if (visited[child] == 0) {
                if (!dfs(child, graph, visited)) {
                    return false
                }
            } else if (visited[child] == 1) {
                return false
            }
        }
        visited[index] = 2
        return true
    }
}