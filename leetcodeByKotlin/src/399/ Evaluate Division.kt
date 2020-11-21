package LeetCode_399

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 399. Evaluate Division
 * https://leetcode.com/problems/evaluate-division/description/
 *
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid.
You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 * */
class Solution {
    /*
    * solution: Graph + BFS, create adjacency list by equations, then go through by bfs to check every node,
    * Time complexity:O(e+e*q), Space complexity:O(e), e is size of equations, q is size of queries
    * */
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = HashMap<String, HashMap<String, Double>>()
        //create directed weighted graph
        for (i in equations.indices) {
            val equation = equations[i]
            val a = equation[0]
            val b = equation[1]
            if (!graph.contains(a)) {
                graph.put(a, HashMap())
            }
            graph.get(a)!!.put(b, values[i])
            //for example: a / b = 2.0, if a is 2, b is 1/2
            if (!graph.contains(b)) {
                graph.put(b, HashMap())
            }
            graph.get(b)!!.put(a, 1 / values[i])
        }
        val result = DoubleArray(queries.size)
        for (i in result.indices) {
            val a = queries[i][0]
            val b = queries[i][1]
            if (!graph.contains(a) || !graph.contains(b)) {
                result[i] = -1.0
            } else {
                result[i] = bfs(a, b, graph)
            }
        }
        return result
    }

    private fun bfs(a: String, b: String, graph: HashMap<String, HashMap<String, Double>>): Double {
        val queue = LinkedList<Pair<String, Double>>()
        //init start from 1
        queue.add(Pair(a, 1.0))
        val visited = HashSet<String>()
        visited.add(a)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            if (cur.first == b) {
                return cur.second
            }
            val neighbors = graph.get(cur.first)
            if (neighbors != null) {
                for (neighbor in neighbors) {
                    if (visited.contains(neighbor.key)) {
                        continue
                    }
                    //ratio multiplied for next level
                    queue.add(Pair(neighbor.key, neighbor.value * cur.second))
                    visited.add(neighbor.key)
                }
            }
        }
        return -1.0
    }
}