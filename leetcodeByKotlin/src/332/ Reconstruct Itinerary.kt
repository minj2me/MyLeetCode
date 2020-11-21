package LeetCode_332

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 332. Reconstruct Itinerary
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
But it is larger in lexical order.
 * */
class Solution {
    /*
        * dfs with stack, Time complexity: O(n), Space complexity:O(n)
        * start from JFk, try all path, find out the first path which used all ticket
        * 1. create graph
        * 2. remove the ticker in the graph after used(because ticker can only use one time)
        * */
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val result = ArrayList<String>()
        val graph = HashMap<String, ArrayList<String>>()
        for (ticket in tickets) {
            val from = ticket.get(0)
            val to = ticket.get(1)
            if (!graph.containsKey(from)) {
                graph.put(from, ArrayList<String>())
            }
            graph.get(from)!!.add(to)
        }
        //sort it
        for (item in graph) {
            item.value.sort()
        }
        //use stack for dfs
        val stack = Stack<String>()
        stack.push("JFK")
        while (stack.isNotEmpty()) {
            val cur = stack.peek()
            if (graph.containsKey(cur) && graph.get(cur)!!.size > 0) {
                //remove the ticker after used
                val station = graph.get(cur)!!.removeAt(0)
                stack.push(station)
            } else {
                result.add(0, stack.pop())
            }

        }
        //println(result)
        return result
    }
}