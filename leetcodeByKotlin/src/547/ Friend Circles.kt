package LeetCode_547

import java.util.*

/**
 * 547. Friend Circles
 * https://leetcode.com/problems/friend-circles/description/
 *
 * There are N students in a class.
 * Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
Given a N*N matrix M representing the friend relationship between students in the class.
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
And you have to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
[1,1,0],
[0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.

Example 2:
Input:
[[1,1,0],
[1,1,1],
[0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(n^2), Space complexity:O(n)
    * */
    fun findCircleNum(M: Array<IntArray>): Int {
        if (M == null || M.isEmpty()) {
            return 0
        }
        var result = 0
        val size = M.size
        val visited = BooleanArray(size)
        val queue = LinkedList<Int>()
        for (i in 0 until size) {
            /*
             * If ith student has not been visited yet, it can mean that either he is the first student or that he is not
             * part of any of the previous friend circles.
             * So add i to the queue and look for all of i's direct and indirect friends.
             */
            if (!visited[i]) {
                visited[i] = true
                queue.add(i)
                while (queue.isNotEmpty()) {
                    val index = queue.poll()
                    for (j in 0 until size) {
                        if (!visited[j] && M[index][j] == 1) {
                            visited[j] = true
                            queue.offer(j)
                        }
                    }
                }
                /*
                 * All direct and indirect friends of the current student have been visited and processed.
                 * This means we have identified one friend circle.
                 */
                result++
            }
        }
        return result
    }
}