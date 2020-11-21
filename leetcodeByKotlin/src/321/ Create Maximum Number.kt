package LeetCode_321

import java.util.*

/**
 * 321. Create Maximum Number
 * https://leetcode.com/problems/create-maximum-number/description/
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 *
Note: You should try to optimize your time and space complexity.

Example 1:
Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]

we will fix two sub problem for this:
1. find k length maximum in an array
2. merge two array
 * */
class Solution {
    fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
        val n1 = nums1.size
        val n2 = nums2.size
        //for test
        var result = IntArray(k)
        //return result
        //nums1最多能够提供的数字的个数
        val maxCountOfNumFromNums1 = Math.min(n1, k)
        for (i in Math.max(0, k - maxCountOfNumFromNums1)..Math.min(k, n2)) {
            var j = k - i
            var result1 = getKMaxNumber(nums1, j)
            var result2 = getKMaxNumber(nums2, i)
            val mergeRes = mergeSortedArray(result1, result2)
            if (compare(mergeRes, result, 0, 0)) {
                result = mergeRes
            }
        }
        printArray(result)
        return result
    }

    private fun compare(nums1: IntArray, nums2: IntArray, i_: Int, j_: Int): Boolean {
        var i = i_
        var j = j_
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] > nums2[j]) {
                return true
            }
            if (nums1[i] < nums2[j]) {
                return false
            }
            i++
            j++
        }
        return i < nums1.size
    }

    private fun getKMaxNumber(nums: IntArray, count: Int): IntArray {
        val minHeap = PriorityQueue<Int>(nums.size)
        for (num in nums) {
            minHeap.add(num)
            if (minHeap.size > count) {
                minHeap.remove()
            }
        }
        val result = IntArray(minHeap.size)
        for (i in 0 until minHeap.size) {
            result.set(i, minHeap.remove())
        }
        //printArray(result)
        return result
    }

    private fun mergeSortedArray(nums1: IntArray, nums2: IntArray): IntArray {
        print("nums1:")
        printArray(nums1)
        println()
        print("nums2:")
        printArray(nums2)
        println()
        println("-------")
        val result = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        var index = 0
        while (i <= nums1.size-1 && j <= nums2.size-1) {
            if (nums1[i] <= nums2[j]) {
                result.set(index++, nums1[i++])
            } else {
                result.set(index++, nums2[j++])
            }
        }
        //just like merge sort
        //check if need add remaining elements in array
        while (i <= nums1.size-1) {
            result.set(index++, nums1[i++])
        }
        while (j <= nums2.size-1) {
            result.set(index++, nums2[j++])
        }
        println("reslut:")
        printArray(result)
        println()
        println("======")
        return result
    }

    private fun printArray(nums: IntArray) {
        for (num in nums) {
            print("$num,")
        }
    }
}