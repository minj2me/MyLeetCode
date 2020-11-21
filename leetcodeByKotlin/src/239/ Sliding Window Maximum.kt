package LeetCode_239

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]

Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
 * */
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = ArrayList<Int>()
        var left = 0
        var right = left + k
        val size = nums.size
        for (i in 0 until size) {
            val intRange = IntRange(left, right - 1)
            val subArray = nums.slice(intRange)
            result.add(subArray.max()!!)
            //printList(subArray)
            left++
            right = left + k
            if (right > size) {
                break
            }
        }
        return result.toIntArray()
    }

    //1,3,-1,-3,5,3,6,7
    private fun printList(list: List<Int>) {
        for (item in list) {
            println(item)
        }
        println("=========")
    }
}