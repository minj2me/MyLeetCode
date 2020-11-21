package LeetCode_703

import java.util.*

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Returns the element representing the kth largest element in the stream.

Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8

Constraints:
1. 1 <= k <= 104
2. 0 <= nums.length <= 104
3. -104 <= nums[i] <= 104
4. -104 <= val <= 104
5. At most 104 calls will be made to add.
6. It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 * */
class KthLargest(k: Int, nums: IntArray) {
    /*
    * solution: PriorityQueue, just contains K largest element by minHeap
    * Time complexity: O(nlogn), Space complexity: O(1)
    * */

    val minHeap = PriorityQueue<Int>()
    var K = 0

    init {
        this.K = k
        //Time:O(nlogn)
        for (num in nums) {
            minHeap.offer(num)
        }
    }

    fun add(`val`: Int): Int {
        //Time:O(logk), because just keep K largest element
        minHeap.offer(`val`)
        while (minHeap.size > K) {
            minHeap.poll()
        }
        return minHeap.peek()
    }

}
/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */