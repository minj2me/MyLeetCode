package LeetCode_480

import java.util.*
/**
 * 480. Sliding Window Median
 * https://leetcode.com/problems/sliding-window-median/description/
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window.
Each time the sliding window moves right by one position.
Your job is to output the median array for each window in the original array.
For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
1 [3  -1  -3] 5  3  6  7       -1
1  3 [-1  -3  5] 3  6  7       -1
1  3  -1 [-3  5  3] 6  7       3
1  3  -1  -3 [5  3  6] 7       5
1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
Answers within 10^-5 of the actual value will be accepted as correct.
 * */
class Solution {
    /*
       * solution: two heap, minHeap and maxHeap, Time complexity:O(nlogn), Space complexity:O(n)
       * */
    //max heap, for numbers small than current median
    val maxHeap = PriorityQueue<Int> { a, b -> b - a }
    //min heap, for numbers bigger than and equals to current median
    val minHeap = PriorityQueue<Int>()

    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val n = nums.size - k + 1
        val result = DoubleArray(n)
        for (i in 0..nums.size) {
            if (i >= k) {
                /*
                * keep two heap can combination to below format:
                * [1  3  -1] -3  5  3  6  7: [1  3  -1]
                  1 [3  -1  -3] 5  3  6  7:  [3  -1  -3]
                  1  3 [-1  -3  5] 3  6  7:  [-1  -3  5]
                  1  3  -1 [-3  5  3] 6  7:  [-3  5  3]
                  1  3  -1  -3 [5  3  6] 7:  [5  3  6]
                   1  3  -1  -3  5 [3  6  7]:[3  6  7]
                * */
                result[i - k] = getMedian()
                if (nums[i - k] < getMedian()) {
                    maxHeap.remove(nums[i - k])
                } else {
                    minHeap.remove(nums[i - k])
                }
                //keep balance after heap operation
                rebalance()
            }
            if (i < nums.size) {
                if (nums[i] < getMedian()) {
                    maxHeap.offer(nums[i])
                } else {
                    minHeap.offer(nums[i])
                }
                rebalance()
            }
        }
        result.forEach { print("$it,") }
        return result
    }

    private fun getMedian(): Double {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0.0
        }
        var value = 0.0
        if (maxHeap.size == minHeap.size) {
            value = (maxHeap.peek().toDouble() + minHeap.peek().toDouble()) / 2.0
        } else {
            value = minHeap.peek().toDouble()
        }
        return value
    }

    //balance minHeap and maxHeap
    //the size of minHeap just can larger than the size fo maxHeap by 1
    private fun rebalance() {
        if (maxHeap.size > minHeap.size) {
            minHeap.offer(maxHeap.poll())
        }
        if (minHeap.size - maxHeap.size > 1) {
            maxHeap.offer(minHeap.poll())
        }
    }
}