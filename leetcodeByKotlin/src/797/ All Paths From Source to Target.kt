package LeetCode_797

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 * Given a directed, acyclic graph of N nodes.
 * Find all possible paths from node 0 to node N-1, and return them in any order.
The graph is given as follows:
the nodes are 0, 1, ..., graph.length - 1.graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * */
class Solution {
    /*
    * Time complexity is O(2^n), Space complexity is O(2^n),
    * */
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>>? {
        val result = ArrayList<List<Int>>()
        //bfs
        /*val n = graph.size
        if (graph.isEmpty()) {
            return result
        }
        val queue = LinkedList<List<Int>>()
        queue.offer(Arrays.asList(0))

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val size = cur.size
            val last = cur.get(size - 1)
            if (last == n - 1) {
                result.add(cur)
                //println("result.add($cur)")
                continue
            }

            //traverse to all the node connected to current vertex and push new path to queue
            for (item in graph.get(last)){
                val newPath = ArrayList<Int>(cur)
                newPath.add(item)
                println(newPath)
                queue.offer(newPath)
            }
        }*/

        val temp = ArrayList<Int>()
        val fistNode = 0//because result need 0, like:0 -> 1 -> 3
        temp.add(fistNode)
        dfs(graph, fistNode, temp, result)
        return result
    }

    private fun dfs(graph: Array<IntArray>, node: Int, temp: ArrayList<Int>, result: ArrayList<List<Int>>) {
        if (node == graph.size - 1) {
            result.add(ArrayList(temp))
            return
        }
        for (item in graph.get(node)) {
            temp.add(item)
            dfs(graph, item, temp, result)
            temp.removeAt(temp.size - 1)
        }
    }
}