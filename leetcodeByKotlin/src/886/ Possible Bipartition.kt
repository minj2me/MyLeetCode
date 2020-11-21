package LeetCode_886

import java.util.*
import kotlin.collections.ArrayList

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/description/
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group.
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Constraints:
1. 1 <= N <= 2000
2. 0 <= dislikes.length <= 10000
3. dislikes[i].length == 2
4. 1 <= dislikes[i][j] <= N
5. dislikes[i][0] < dislikes[i][1]
6. There does not exist i != j for which dislikes[i] == dislikes[j].
 * */
class Solution {
    /*
    * solution: Create graph + BFS, Time complexity:O(V+E), Space complexity:O(V+E)
    * */
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val graph = Array(N + 1, { ArrayList<Int>() })
        for (i in 0 until N) {
            graph[i] = ArrayList()
        }
        //create graph
        for (dislike in dislikes) {
            graph[dislike[0]].add(dislike[1])
            graph[dislike[1]].add(dislike[0])
        }

        //-1:non-color, 0:red, 1:blue
        val corlorArray = IntArray(N + 1, { -1 })
        for (i in 0 until N) {
            if (corlorArray[i] != -1) {
                continue
            }
            corlorArray[i] = 0
            val queue = LinkedList<Int>()
            queue.offer(i)
            while (queue.isNotEmpty()) {
                val cur = queue.pop()
                for (adj in graph[cur]!!) {
                    if (corlorArray[cur] == corlorArray[adj]) {
                        return false
                    } else {
                        //give opposite color to neighbor
                        if (corlorArray[adj] == -1) {
                            corlorArray[adj] = corlorArray[cur].xor(1)
                            queue.offer(adj)
                        }
                    }
                }
            }
        }
        return true
    }
}