package LeetCode_210

import java.util.*
import kotlin.collections.ArrayList

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
course 0. So the correct course order is [0,1] .
 * */
class Solution {
    /**
     * solution: BFS
     * Time complexity:O(v+e), Space complexity:O(v+e), v:node count, e:edge count
     * */
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        //init graph
        val graph = ArrayList<ArrayList<Int>>()
        for (i in 0 until numCourses) {
            graph.add(ArrayList())
        }
        for (item in prerequisites) {
            val start = item[1]
            val end = item[0]
            graph[start].add(end)
        }

        //calculate in degree
        val inDegree = Array<Int>(graph.size, { 0 })
        for (item in graph) {
            for (v in item) {
                inDegree[v]++
            }
        }

        val result = IntArray(numCourses)

        val queue = LinkedList<Int>()

        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) {
                queue.offer(i)
            }
        }

        for (i in 0 until numCourses) {
            if (queue.isEmpty()) {
                return IntArray(0)
            }

            val top = queue.poll()
            result.set(i, top)

            for (item in graph[top]) {
                inDegree[item]--
                if (inDegree[item] == 0) {
                    queue.offer(item)
                }
            }
        }

        return result
    }

}