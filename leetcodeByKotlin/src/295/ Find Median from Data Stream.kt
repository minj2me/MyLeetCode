package LeetCode_295

import java.util.*

/**
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

Follow up:
If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * */
/*
* solution: Tow PriorityQueue, minHeap and maxHeap, Time complexity: O(nlogn), Space complexity:O(1)
* get element from PriorityQueue is O(1),
* insert new element in PriorityQueue is O(logn)
* */
class MedianFinder {

    /** initialize your data structure here. */
    //change to max heap, because PriorityQueue in kotlin default is Min Heap
    private val leftHeap = PriorityQueue<Int> { a, b -> b - a }
    //min heap
    private val rightHeap = PriorityQueue<Int>()

    /*
    * for example after insert: 2,3,4,5,6,7
    * maxHeap in left:
        [4, 2, 3]
        minHeap in right:
        [5, 6, 7]
      now both size is 3, so median is (maxHeap.peek()+minHeap.peed())/2 = (4+5)/2 = 4.5
    * */
    fun addNum(num: Int) {
        if (leftHeap.isEmpty() || num < leftHeap.peek()) {
            leftHeap.offer(num)
        } else {
            rightHeap.offer(num)
        }
        //balance minHeap and maxHeap
        //the size of minHeap just can larger than the size fo maxHeap by 1
        if (leftHeap.size < rightHeap.size) {
            leftHeap.offer(rightHeap.poll())
        } else if (leftHeap.size - rightHeap.size == 2) {
            rightHeap.offer(leftHeap.poll())
        }
        println("maxHeap in left:")
        println(leftHeap)
        println("minHeap in right:")
        println(rightHeap)
    }

    fun findMedian(): Double {
        //maxheap.size > minheap.size
        if (leftHeap.size > rightHeap.size) {
            println("median:${leftHeap.peek().toDouble()}")
            return leftHeap.peek().toDouble()
        } else {
            val left = leftHeap.peek().toDouble()
            println("left:${left}")
            val right = rightHeap.peek().toDouble()
            println("right:${right}")
            println("median:${(left + right) / 2}")
            return (left + right) / 2
        }
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */