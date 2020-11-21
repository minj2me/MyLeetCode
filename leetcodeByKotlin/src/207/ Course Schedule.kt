package LeetCode_207

import java.util.*
import kotlin.collections.ArrayList

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 *
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1,which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should
also have finished course 1. So it is impossible.
 * */
class Solution {
    /**
     * solution: BFS
     * Time complexity:O(v+e), Space complexity:O(v+e), v:node count, e:edge count
     * 1.将先修关系构成一张图，由每个数对的第二个数字向第一个数字连边。
        2.首先将所有入度为 0 的点进队，准备用宽度优先搜索进行拓扑排序。
        3.宽搜过程中，将当前结点所关联的结点的入度减 1；若发现新的入度为 0 的结点，则将其进队。
        4.最后如果遍历了所有结点，则说明可以满足要求；否则，先修关系存在环。
     * */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = ArrayList<ArrayList<Int>>()
        //create graph by prerequisites
        for (i in 0 until numCourses) {
            graph.add(ArrayList())
        }
        //create adjacency list
        for (item in prerequisites){
            val start = item[1]
            val end = item[0]
            graph[start].add(end)
        }

        //calculate in degree
        val indegrees = IntArray(numCourses)
        for (g in graph){
            for (item in g){
                indegrees[item]++
            }
        }

        val queue = LinkedList<Int>()
        for (i in 0 until numCourses) {
            if (indegrees[i]==0){
                queue.offer(i)
            }
        }

        while (queue.isNotEmpty()){
            val cur = queue.poll()
            for (item in graph[cur]){
                indegrees[item]--
                if (indegrees[item]==0){
                    queue.offer(item)
                }
            }
        }

        for (i in 0 until numCourses){
            if (indegrees[i]!=0){
                //represent graph got a cycle, so return false
                return false
            }
        }

        return true
    }
}