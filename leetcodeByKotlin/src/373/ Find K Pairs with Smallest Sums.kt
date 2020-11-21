package LeetCode_373

import java.util.*
import kotlin.collections.ArrayList

/**
 * 373. Find K Pairs with Smallest Sums
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Input: nums1 = [1,7,11],
nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]

Explanation: The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * */
class Solution {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        if (nums1.isEmpty() && nums2.isEmpty()) {
            return result
        }
        val queue = PriorityQueue<List<Int>> { a, b -> a.sum() - b.sum() }
        for (item1 in nums1) {
            for (item2 in nums2) {
                val items = ArrayList<Int>()
                items.add(item1)
                items.add(item2)
                queue.add(items)
            }
        }
        for (i in 0 until k) {
            val list = queue.poll()
            if (list != null) {
                result.add(list)
            }
        }
        return result
    }
}