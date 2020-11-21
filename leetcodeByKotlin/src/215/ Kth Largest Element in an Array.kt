package LeetCode_215

import java.util.*

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * 3,2,1,5,6,4
 * */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()//always keep the smallest one on the top
        for (num in nums) {
            minHeap.add(num)//O(logn) to heapify
            println(minHeap)
            /*
            *   [3]
                [2, 3]
                [1, 3, 2]
                [2, 3, 5]
                [3, 5, 6]
                [4, 6, 5]
                [5, 6]
            * */
            if (minHeap.size > k) {
                //remove the smallest one
                minHeap.remove()
            }
        }
        println(minHeap)//[5, 6]
        return minHeap.remove()//return 5
    }
}
