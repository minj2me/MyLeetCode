package LeetCode_378

import java.util.*

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
Example:
matrix = [
[ 1,  5,  9],
[10, 11, 13],
[12, 13, 15]
],
k = 8,
return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 * */
class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        //set the maximum heap
        val queue = PriorityQueue<Int>() { a, b -> b - a }
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                queue.offer(matrix[i][j])
                if (queue.size > k) {
                    //if size bigger than k, pop the head
                    queue.poll()
                }
            }
        }
        return queue.peek()
    }
}