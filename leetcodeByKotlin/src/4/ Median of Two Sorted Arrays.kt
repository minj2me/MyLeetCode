package LeetCode_4

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
 * */
class Solution {
    /*
    * solution 1: Merge Sort, Time complexity:O(m+n), Space complexity:O(m+n)
    * solution 2: Binary Search, Time complexity:O(log(min(m,n))), Space complexity:O(1)
    * */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = mergeArray(nums1, nums2)
        val size = mergedArray.size
        var result = 0.0
        if (size % 2 == 0) {
            //even
            result = (mergedArray[size / 2] + mergedArray[(size - 1) / 2]) / 2.0
        } else {
            //odd
            result = mergedArray[size / 2].toDouble()
        }
        return result
    }

    private fun mergeArray(nums1: IntArray, nums2: IntArray): IntArray {
        val n1 = nums1.size
        val n2 = nums2.size
        val newArray = IntArray(n1 + n2)
        var k = 0
        var i = 0
        var j = 0
        while (i < n1 && j < n2) {
            //compare two value
            if (nums1[i] <= nums2[j]) {
                newArray[k] = nums1[i]
                i++
            } else {
                newArray[k] = nums2[j]
                j++
            }
            k++
        }
        //check remaining element in nums1
        while (i < n1) {
            newArray[k] = nums1[i]
            i++
            k++
        }
        //check remaining element in nums2
        while (j < n2) {
            newArray[k] = nums2[j]
            j++
            k++
        }
        return newArray
    }
}