package LeetCode_684

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added.
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
The resulting graph is given as a 2D-array of edges.
Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
Return an edge that can be removed so that the resulting graph is a tree of N nodes.
If there are multiple answers, return the answer that occurs last in the given 2D-array.
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
    1
   / \
  2 - 3

Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3

Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 * */
class Solution2 {
    /*
    * solution: use BFS to go through each edge, start from first, it can reach target, then there be a circle.
    * Time complexity:O(n^2), Space complexity:O(n)
    * */
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val result = IntArray(2)
        //graph represented by adjacent list
        val graph = HashMap<Int, ArrayList<Int>>()

        //for each edge, run bfs to find the circle
        for (edge in edges) {
            val first = edge[0]
            val target = edge[1]
            val queue = LinkedList<Int>()
            queue.push(first)
            //record the visited vertex, avoid put back to queue again
            val visited = HashSet<Int>()
            visited.add(first)
            while (queue.isNotEmpty()) {
                val cur = queue.pop()
                if (graph.contains(cur) && graph.get(cur)!!.contains(target)) {
                    /*
                    * if starting from first can reach target, meaning if add [first, target] will be occur circle,
                    * so this is a answer
                    * */
                    result[0] = first
                    result[1] = target
                    return result
                }
                //continue bfs to check each vertex
                if (graph.contains(cur)) {
                    val list = graph.get(cur)
                    if (list != null) {
                        for (item in list) {
                            if (visited.contains(item)) {
                                continue
                            }
                            visited.add(item)
                            queue.offer(item)
                        }
                    }
                }
            }
            if (!graph.contains(first)) {
                graph.put(first, ArrayList())
            }
            if (!graph.contains(target)) {
                graph.put(target, ArrayList())
            }
            //adjacent list
            graph.get(first)!!.add(target)
            graph.get(target)!!.add(first)
        }

        return result
    }
}