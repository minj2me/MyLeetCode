package LeetCode_88

import java.util.*

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 * */
class Solution {
    /*
    k = m+n
    * Time complexity: O(klogk), Space complexity: O(k)
    * */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val total = m + n
        var newN = 0
        //set num2 into num1
        for (i in m until total) {
            nums1.set(i, nums2[newN])
            newN++
        }
        //use heap to resort num1
        val minHeap = PriorityQueue<Int>()
        for (num in nums1) {
            minHeap.add(num)
        }
        var newIndex = 0
        while (newIndex < total) {
            nums1.set(newIndex, minHeap.poll())
            newIndex++
        }
    }
}