package LeetCode_973

import java.util.*

/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * */
class Solution {
    /*
    * solution: PriorityQueue, Time complexity:O(nlogk), Space complexity:O(1)
    * because heapify: O(logk), k is size of PriorityQueue
    * */
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray>? {
        //sort by distance ascending
        val minHeap = PriorityQueue<IntArray> { a, b -> distance(b) - distance(a) }
        for (point in points) {
            minHeap.add(point)
            if (minHeap.size > K) {
                minHeap.poll()
            }
        }
        val result = Array(K){ IntArray(2) }
        for (i in minHeap.indices) {
            result[i] = minHeap.poll()
        }
        return result
    }

    /**
     * return the distance from 0 to x,y by formula: (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2),
     * here x2 and y2 are 0
     * */
    private fun distance(array: IntArray): Int {
        return array[0] * array[0] + array[1] * array[1]
    }
}